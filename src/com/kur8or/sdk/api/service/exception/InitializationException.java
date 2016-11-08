package com.kur8or.sdk.api.service.exception;

/**
 *  
 * @author Assaf Moldavsky
 */

public class InitializationException extends RuntimeException {
	
	private static final long serialVersionUID = 581752830306110614L;

	public InitializationException( String message ) {
		super( message );
	}
	
	public InitializationException(String message, Throwable t) {
		super( message, t );
	}
}
