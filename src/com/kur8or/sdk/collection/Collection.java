package com.kur8or.sdk.collection;

import java.util.Date;
import java.util.List;

/**
 * A Collection POJO interface
 * 
 * @author Assaf Moldavsky
 */
public interface Collection {
	
	public String getId();
	public void setId(String id);
	
	public String getImageUrl();
	public void setImageUrl(String imageUrl);
	
	public String getTitle();
	public void setTitle(String title);
	
	public String getDescription();
	public void setDescription(String description);
	
	public List<CollectionSource> getSources();
	public void setSources(List<CollectionSource> sources);
	
	public String getPublicUrl();
	public void setPublicUrl(String publicUrl);
	
	public Integer getOwnerId();
	public void setOwnerId(Integer ownerId);
	
	public Date getDateCreated();
	public void setDateCreated(Date dateCreated);
	
	public Date getDateModified();
	public void setDateModified(Date dateModified);
	
}
