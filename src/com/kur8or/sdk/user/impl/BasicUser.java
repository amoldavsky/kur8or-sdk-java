package com.kur8or.sdk.user.impl;


import java.io.Serializable;
import java.util.Date;
import com.kur8or.sdk.user.User;

/**
 * A User POJO basic implementation
 * 
 * @author Assaf Moldavsky
 */
public class BasicUser implements User,Serializable {

	private static final long serialVersionUID = 1L;
	
	Integer id;
	String profileImageUrl;
	String username;
	String firstName;
	String lastName;
	String email;
	Date dateCreated;

	User user;
	
	public BasicUser() {
		
	}

	/**
	 * Copy constructor
	 * @param user
     */
	public BasicUser( User user ) {
		
		setId( user.getId() );
		setProfileImageUrl( user.getProfileImageUrl() );
		setUsername( user.getUsername() );
		setFirstName( user.getFirstName() );
		setLastName( user.getLastName() );
		setEmail( user.getEmail() );
		setDateCreated( user.getDateCreated() );
		
	}
	
	@Override
	public Integer getId() {
		return id;
	}
	@Override
	public void setId(Integer id) {
		this.id = id;
	}
	@Override
	public String getUsername() {
		return username;
	}
	@Override
	public void setUsername(String username) {
		this.username = username;
	}
	@Override
	public String getFirstName() {
		return firstName;
	}
	@Override
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	@Override
	public String getLastName() {
		return lastName;
	}
	@Override
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	@Override
	public String getEmail() {
		return email;
	}
	@Override
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public Date getDateCreated() {
		return dateCreated;
	}
	@Override
	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}
	@Override
	public String getProfileImageUrl() {
		return profileImageUrl;
	}
	@Override
	public void setProfileImageUrl( String url ) {
		this.profileImageUrl = url;
		
	}
	
}
