package entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author nhchdhr
 * 
 * This class represents the Department entity and provides getters and setters for its fields
 * Student entity is mapped to Department table in the database 
 *
 */
@Entity
@Table(name="DEPARTMENT")
public class Department {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ID")
	private int deptId;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="MISSION")
	private String mission;
	
	@Column(name="LOCATION")
	private String location;
	
	@Column(name="URL")
	private String url;
	

	@Column(name="PHOTO_URL")
	private String photoUrl;
	
	public String getPhotoUrl() {
		return photoUrl;
	}
	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}
	/**
	@JoinTable(name="DEPT_PHOTO_REF", joinColumns= @JoinColumn(name="TYPE_ID", referencedColumnName = "ID"))
	@OneToOne(cascade=CascadeType.REMOVE)
	private Photograph photo;
	
	public Photograph getPhoto() {
		return photo;
	}
	public void setPhoto(Photograph photo) {
		this.photo = photo;
	}**/
	
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public int getDeptId() {
		return deptId;
	}
	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMission() {
		return mission;
	}
	public void setMission(String mission) {
		this.mission = mission;
	}
	
	@Override
	public String toString() {
		StringBuffer  sb = new StringBuffer();
		sb.append("The Department details are : \nDept id: " + this.deptId);
		sb.append("\nName : " + name);
		sb.append("\nMission : " + mission + "\n");
		return sb.toString();
	}

}
