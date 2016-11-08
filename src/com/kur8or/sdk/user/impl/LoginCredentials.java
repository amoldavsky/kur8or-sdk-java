package com.kur8or.sdk.user.impl;

public class LoginCredentials {

	String login;
	String password;

	public LoginCredentials() {
	}

	public LoginCredentials(String login, String password ) {
		setLogin( login );
		setPassword( password );
	}
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
