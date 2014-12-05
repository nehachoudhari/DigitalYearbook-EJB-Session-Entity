package entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author nhchdhr
 * 
 * This class represents the Event entity and provides getters and setters for its fields
 * Student entity is mapped to Event table in the database 
 *
 */
@Entity
@Table(name="EVENT")
public class Event implements Serializable{
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="DESCRIPTION")
	private String description;
	
	@Column(name="EVENT_DATE")
	private String date;
	
	@Column(name="URL")
	private String url;
	
	@Id
	@GeneratedValue
	@Column(name="EVENT_ID")
	private long eventId;
	

	@Column(name="PHOTO_URL")
	private String photoUrl;
	
	
	public String getPhotoUrl() {
		return photoUrl;
	}
	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public long getEventId() {
		return eventId;
	}
	public void setEventId(long eventId) {
		this.eventId = eventId;
	}
}
