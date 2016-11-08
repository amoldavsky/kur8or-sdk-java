package com.kur8or.sdk.user.impl;

import com.kur8or.sdk.user.User;

import java.util.Date;

public class UserSession {

	String sessionToken;
	Date dateExpire;
	User user;
	
	public UserSession() {
		
	}
	
	public UserSession( String accessToken, Date expire ) {
		this.setDateExpire( expire );
		this.setSessionToken( accessToken );
	}

	public UserSession( String accessToken, Date expire, User user ) {
		this.setDateExpire( expire );
		this.setSessionToken( accessToken );
		this.setUser( user );
	}
	
	public String getSessionToken() {
		return sessionToken;
	}

	public void setSessionToken(String sessionToken) {
		this.sessionToken = sessionToken;
	}

	public Date getDateExpire() { return dateExpire; }

	public void setDateExpire( Date dateExpire ) { this.dateExpire = dateExpire; }
	
	public User getUser() {
		return user;
	}

	public void setUser( User user ) {
		this.user = user;
	}

	
}
