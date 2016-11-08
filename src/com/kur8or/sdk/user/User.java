package com.kur8or.sdk.user;

import java.util.Date;

/**
 * A User POJO interface
 * 
 * @author Assaf Moldavsky
 */
public interface User {

	Integer getId();
	void setId(Integer id);
	String getProfileImageUrl();
	void setProfileImageUrl( String url );
	void setUsername( String username );
	String getUsername();
	String getFirstName();
	void setFirstName(String firstName);
	String getLastName();
	void setLastName(String lastName);
	String getEmail();
	void setEmail(String email);
	Date getDateCreated();
	void setDateCreated(Date dateCreated);

}
