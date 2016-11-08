package com.kur8or.sdk.api.service;

/**
 * ApiService config Object
 *  
 * @author Assaf Moldavsky
 */

public class ApiServiceConfig {

	String clientId;
	String clientSecret;
	String callbackUrl;
	
	public String getClientId() {
		return clientId;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	public String getClientSecret() {
		return clientSecret;
	}
	public void setClientSecret(String clientSecret) {
		this.clientSecret = clientSecret;
	}
	public String getCallbackUrl() {
		return callbackUrl;
	}
	public void setCallbackUrl(String callbackUrl) {
		this.callbackUrl = callbackUrl;
	}
	
}
