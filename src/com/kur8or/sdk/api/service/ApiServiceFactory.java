package com.kur8or.sdk.api.service;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.kur8or.sdk.user.impl.LoginCredentials;
import org.apache.cxf.jaxrs.client.WebClient;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider;
import com.kur8or.sdk.api.ApiResponse;
import com.kur8or.sdk.api.service.exception.InitializationException;
import com.kur8or.sdk.user.User;
import com.kur8or.sdk.user.impl.BasicUser;
import com.kur8or.sdk.user.impl.UserSession;

public class ApiServiceFactory implements ApiService {
	
	/**
	 * This is the global Jackson ObjectMapper to be used for all JSON Serialization and Deserialization
	 */
	private static ObjectMapper objectMapper;
	private static WebClient webClient;
	private static String API_SERVICE_URI = "http://api.kur8or.com";
	
	static {
		//--------------------- configure JSON Serializaer and Deserializers:
		final StdDeserializer<BasicUser> userAbstractDeserializer = new StdDeserializer<BasicUser>( BasicUser.class ) {

			private static final long serialVersionUID = 1187365719390311892L;
			
			@Override
			public BasicUser deserialize(JsonParser jp, DeserializationContext ctx)
					throws IOException, JsonProcessingException {
				ObjectMapper mapper = (ObjectMapper) jp.getCodec();
				return mapper.readValue( jp, BasicUser.class );
			}
			
		};
		/*
		final StdSerializer<BasicUser> userAbstractSerializer = new StdSerializer<BasicUser>( BasicUser.class, false ) {

			private static final long serialVersionUID = 1187365719390311892L;

			ObjectMapper objectMapper = new ObjectMapper();
			
			@Override
			public void serialize( BasicUser value, JsonGenerator gen, SerializerProvider provider)
					throws IOException {
				gen.writeString( objectMapper.writeValueAsString( value ) );
				
			}
			
		};
		*/
		
		SimpleModule module = new SimpleModule( 
				"Kur8or Web App",
				new Version(1, 0, 0, null, "com.kur8or", "spring")
		);
		
		module.addDeserializer( User.class, userAbstractDeserializer );
		//module.addSerializer( BasicUser.class, userAbstractSerializer );
		//module.addDeserializer(Collection.class, );
		
		objectMapper = new ObjectMapper();
		objectMapper.registerModule(module);
		
	}
	
	private URI serviceUri;
	private ApiServiceConfig config;
	
	protected ApiServiceFactory( final String serviceUri, final ApiServiceConfig config ) throws InitializationException {
		
		// TODO: add parameter validation and throw IllegalArgumentExceptions
		
		try{
			this.serviceUri = new URI( serviceUri );
		} catch( URISyntaxException use ) {
			
			InitializationException ie = new InitializationException( String.format( "unable to parse serviceUri \"%s\"", serviceUri ), use );
			ie.setStackTrace( use.getStackTrace() );
			throw ie;
			
		}
		
		this.config = config;
		
		try {
			initCxf();
		} catch( Throwable t ) {
			
		}
		
	}
	
	public ApiServiceFactory( ApiServiceConfig config ) {
		this( API_SERVICE_URI, config );
	}
	
	/**
	 * Initializes the CXF WebClient
	 */
	private void initCxf() {
		
		final List<Object> providers = new ArrayList<Object>();
		JacksonJaxbJsonProvider jacksonJsonProvider = new JacksonJaxbJsonProvider();
		jacksonJsonProvider.setMapper( objectMapper );
		
		providers.add( jacksonJsonProvider );
		webClient = WebClient.create( String.valueOf( this.serviceUri ), providers );
		webClient
			.accept( MediaType.APPLICATION_JSON )
			.type( MediaType.APPLICATION_JSON );
		
	}
	
	/**
	 * TODO: add JavaDoc
	 * @param serviceUri
	 * @param config
	 * @return
	 */
	public static ApiService createInstance( final String serviceUri, final ApiServiceConfig config ) {
		return new ApiServiceFactory( serviceUri, config );
	}
	
	/**
	 * TODO: add JavaDoc
	 * @param config
	 * @return
	 */
	public static ApiService createInstance( final ApiServiceConfig config ) {
		return new ApiServiceFactory( config );
	}
	
	/**
	 * WebClient is not Thread safe so we must create a new copy
	 * for each connection.
	 * 
	 * TODO: add thread pooling for these objects
	 * 
	 * @return
	 */
	private WebClient getWebClient() {
		
		return WebClient.fromClient( webClient ) 
					.accept( MediaType.APPLICATION_JSON )
					.type( MediaType.APPLICATION_JSON );
		
	}
	
	/**
	 * TODO: add JavaDoc
	 */
	@Override
	public <T> ApiResponse<T> get( String endpoint ) {
		WebClient webClient = getWebClient();
		webClient.path( endpoint );
		
		ApiResponse<T> response = null;
		
		try {

			response = webClient.get( new GenericType<ApiResponse<T>>(){} );
						
		} catch( Throwable t ) {
			
			// TODO: Assaf: decide what to do here
			
		}
		
		return response;
	}

	/**
	 * TODO: add JavaDoc
	 */
	@Override
	public ApiResponse<UserSession> login( LoginCredentials login ) {
		
		WebClient webClient = getWebClient();
		webClient.path( "/user/login" );
		
		ApiResponse<UserSession> apiResponse = null;
		
		try {
			Response clientResponse = webClient.post( login );
			String responseStr = clientResponse.readEntity( String.class );
			
			apiResponse = objectMapper.readValue( 
				responseStr,
				objectMapper.getTypeFactory().constructType( new TypeReference<ApiResponse<UserSession>>(){} )
			);
		} catch( Throwable t) {
			// TODO: Assaf: decide what to do here
		}
		
		return apiResponse;
	}
	
	/**
	 * TODO: add JavaDoc
	 */
	@Override
	public <T> ApiResponse<T> create( String endpoint, T data ) {
		
		WebClient webClient = getWebClient();
		webClient.path( endpoint );
		
		ApiResponse<T> apiResponse = null;
		
		try {
			Response clientResponse = webClient.post( data );
			String responseStr = clientResponse.readEntity( String.class );
			
			apiResponse = objectMapper.readValue( 
				responseStr,
				objectMapper.getTypeFactory().constructType( new TypeReference<ApiResponse<T>>(){} )
			);
		} catch( Throwable t) {
			apiResponse.setResultCode( ApiResponse.FAILURE );
			apiResponse.setMessage( t.toString() );
		}
		
		return apiResponse;
	}

	/**
	 * TODO: add JavaDoc
	 */
	@Override
	public <T> ApiResponse<T> update( String endpoint, T data ) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * TODO: add JavaDoc
	 */
	@Override
	public <T> ApiResponse<T> delete( String endpoint ) {
		// TODO Auto-generated method stub
		return null;
	}

}
