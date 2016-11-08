package com.kur8or.sdk.api.service;

import com.kur8or.sdk.api.ApiResponse;
import com.kur8or.sdk.user.impl.LoginCredentials;
import com.kur8or.sdk.user.impl.UserSession;

public interface ApiService {
	
	// TODO: Assaf: JavaDoc
	public ApiResponse<UserSession> login( LoginCredentials user );
	
	// TODO: Assaf: JavaDoc
	public <T> ApiResponse<T> get( String endpoint );
	
	// TODO: Assaf: JavaDoc
	public <T> ApiResponse<T> create( String endpoint, T data );
	
	// TODO: Assaf: JavaDoc
	public <T> ApiResponse<T> update( String endpoint, T data );
	
	// TODO: Assaf: JavaDoc
	public <T> ApiResponse<T> delete( String endpoint );
	
}
