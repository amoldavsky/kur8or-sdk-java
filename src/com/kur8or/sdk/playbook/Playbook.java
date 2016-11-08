package com.kur8or.sdk.playbook;

import com.kur8or.sdk.user.User;

import java.io.Serializable;
import java.net.URI;
import java.util.Date;
import java.util.List;

/**
 * Playbook POJO
 * 
 * @author Assaf Moldavsky
 */

public class Playbook implements Serializable {
	
	private static final long serialVersionUID = 7318405136831741447L;

	String id;
	String title;
	String description;
	URI url;
	URI imageUrl;
	List<Chapter> chapters;
	Boolean isPublished;
	Integer ownerId;
	Date dateCreated;
	Date dateModified;

	// additional optional fields
	User user;

	/**
	 * Default constructor
	 */
	public Playbook() {}

	/**
	 * Copy constructor
	 */
	public Playbook( Playbook playbook ) {

		setId( playbook.getId() );
		setTitle( playbook.getTitle() );
		setDescription( playbook.getDescription() );
		setUrl( playbook.getUrl() );
		setImageUrl( playbook.getImageUrl() );
		setChapters( playbook.getChapters() );
		setIsPublished( playbook.getIsPublished() );
		setOwnerId( playbook.getOwnerId() );
		setDateCreated( playbook.getDateCreated() );
		setDateModified( playbook.getDateModified() );

		// optional fields
		setUser( playbook.getUser() );

	}

	public String getId() { return id; }
	public void setId(String id) { this.id = id; }
	
	public String getTitle() { return title; }
	public void setTitle(String title) { this.title = title; }
	
	public String getDescription() { return description; }
	public void setDescription(String description) { this.description = description; }
	
	public URI getUrl() { return url; }
	public void setUrl(URI url) { this.url = url; }
	
	public URI getImageUrl() { return imageUrl; }
	public void setImageUrl(URI imageUrl) { this.imageUrl = imageUrl; }
	
	public List<Chapter> getChapters() { return chapters; }
	public void setChapters(List<Chapter> chapters) { this.chapters = chapters; }
	
	public Boolean getIsPublished() { return isPublished; }
	public void setIsPublished(Boolean isPublished) { this.isPublished = isPublished; }
	
	public Integer getOwnerId() { return ownerId; }
	public void setOwnerId(Integer ownerId) { this.ownerId = ownerId; }
	
	public Date getDateCreated() { return dateCreated; }
	public void setDateCreated( Date dateCreated ) { this.dateCreated = dateCreated; }

	public Date getDateModified() { return dateModified; }
	public void setDateModified(Date dateModified) { this.dateModified = dateModified; }


	public User getUser() {
		return this.user;
	}
	public void setUser( User user ) {
		this.user = user;
	}
}
