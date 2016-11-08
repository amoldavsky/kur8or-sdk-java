package com.kur8or.sdk.collection;

import java.time.Instant;

/**
 * The source interface. All sources should implement this interface.
 * 
 * @author Assaf Moldavsky
 */

public class CollectionSource {

	Integer index;
	String url;
	String imageUrl;
	String title;
	String description;
	String[] keywords;
	Instant dateCreated;

	public Integer getIndex() {
		return this.index;
	}
	public void setIndex( Integer index ) {
		this.index = index;
	}
	
	public String getUrl() {
		return url;
	}
	public void setUrl( String url ) {
		this.url = url;
	}

	public String getImageUrl() {
		return this.imageUrl;
	}
	public void setImageUrl( String url ) {
		this.imageUrl = url;
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

	public String[] getKeywords() {
		return keywords;
	}
	public void setKeywords(String[] keywords) {
		this.keywords = keywords;
	}
	
	public Instant getDateCreated() {
		return this.dateCreated;
	}
	public void setDateCreated( Instant date ) {
		this.dateCreated = date;
	}
	
}
