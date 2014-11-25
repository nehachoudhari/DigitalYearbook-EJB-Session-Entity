package entity;

import javax.persistence.Entity;
import javax.persistence.Table;


/**
 * @author nhchdhr
 * 
 * This class represents the Research Group entity and provides getters and setters for its fields
 * This entity is mapped to ResearchGroup table in the database 
 *
 */
@Entity
@Table(name="RESEARCH_GROUP")
public class ResearchGroup{

	private int groupId;
	private String name;
	private String description;
	private Photograph photo;
	private String url;
	public int getGroupId() {
		return groupId;
	}
	public void setGroupId(int groupId) {
		this.groupId = groupId;
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
	public Photograph getPhoto() {
		return photo;
	}
	public void setPhoto(Photograph photo) {
		this.photo = photo;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	
	
}


