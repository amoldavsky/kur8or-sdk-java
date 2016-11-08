package com.kur8or.sdk.collection.impl;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.kur8or.sdk.collection.Collection;
import com.kur8or.sdk.collection.CollectionSource;
import com.kur8or.sdk.user.User;

/**
 * A Collection POJO
 * 
 * @author Assaf Moldavsky
 */
@SuppressWarnings("serial")
public class BasicCollection implements Collection,Serializable {
	
	String id;
	String imageUrl;
	String title;
	String description;
	List<CollectionSource> sources;
	String publicUrl;
	Integer ownerId;
	Date dateCreated;
	Date dateModified;
	
	public BasicCollection() {
		
	}
	
	public BasicCollection(Collection initialCollection) {
		this.id = initialCollection.getId();
		this.imageUrl = initialCollection.getImageUrl();
		this.title = initialCollection.getTitle();
		this.description = initialCollection.getDescription();
		this.sources = initialCollection.getSources();
		this.publicUrl = initialCollection.getPublicUrl();
		this.ownerId = initialCollection.getOwnerId();
		this.dateCreated = initialCollection.getDateCreated();
		this.dateModified = initialCollection.getDateModified();
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<CollectionSource> getSources() {
		return sources;
	}
	public void setSources(List<CollectionSource> sources) {
		this.sources = sources;
	}
	public String getPublicUrl() {
		return publicUrl;
	}
	public void setPublicUrl(String pulicUrl) {
		this.publicUrl = pulicUrl;
	}
	public Integer getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(Integer ownerId) {
		this.ownerId = ownerId;
	}
	public Date getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}
	public Date getDateModified() {
		return dateModified;
	}
	public void setDateModified(Date dateModified) {
		this.dateModified = dateModified;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
}
