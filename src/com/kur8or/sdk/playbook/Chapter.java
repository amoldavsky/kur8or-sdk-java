package com.kur8or.sdk.playbook;

import java.io.Serializable;
import java.net.URI;
import java.sql.Date;
import java.util.List;

/**
 * Playbook Chapter POJO
 * 
 * @author Assaf Moldavsky
 */

public class Chapter implements Serializable {

	private static final long serialVersionUID = 7950834344422955242L;

	Integer index;
	URI url;
	URI imageUrl;
	String title;
	String content;
	Boolean isPublished;
	Date dateCreated;
	Date dateModified;

	public Integer getIndex() { return index; }
	public void setIndex(Integer index) { this.index = index; }
	
	public URI getUrl() { return url; }
	public void setUrl(URI url) { this.url = url; }
	
	public URI getImageUrl() { return imageUrl; }
	public void setImageUrl(URI imageUrl) { this.imageUrl = imageUrl; }
	
	public String getTitle() { return title; }
	public void setTitle(String title) { this.title = title; }
	
	public String getContent() {return content; }
	public void setContent(String content) { this.content = content; }
	
	public Boolean getIsPublished() { return isPublished; }
	public void setIsPublished(Boolean isPublished) { this.isPublished = isPublished; }
	
	public Date getDateCreated() { return dateCreated; }
	public void setDateCreated(Date dateCreated) { this.dateCreated = dateCreated; }

	public Date getDateModified() { return dateModified; }
	public void setDateModified(Date dateModified) { this.dateModified = dateModified; }
	
}
