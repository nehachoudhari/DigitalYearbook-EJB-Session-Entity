package entity;
import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author nhchdhr
 * 
 * This class represents the Student entity and provides getters and setters for its fields
 * Student entity is mapped to Student table in the database 
 *
 */
@Entity
@Table(name="STUDENT")
public class Student implements Serializable{
	
	
	@Id
	@Column(name="BUCK_ID")
	private long buckId;
	
	@Column(name="FNAME")
	private String firstName;
	
	@Column(name="LNAME")
	private String lastName;
	
	@Column(name="USER_NAME")
	private String username;
	
	@Column(name="PASSWORD")
	private String password;
	
	@Column(name="DATE_OF_BIRTH")
	private String dob;
	
	@Column(name="GRAD_YEAR")
	private String gradYear;
	
	@Column(name="CONTACT_NUMBER")
	private String contactNumber;
	
	@Column(name="JOB_INTERN_DETAILS")
	private String jobInternDetails;
	
	@Column(name="DEPARTMENT_ID")
	private int deptId;
	
	@Column(name="EMAIL")
	private String email;
	
	@Column(name="URL")
	private String url;
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getDeptId() {
		return deptId;
	}
	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getJobInternDetails() {
		return jobInternDetails;
	}
	public void setJobInternDetails(String jobInternDetails) {
		this.jobInternDetails = jobInternDetails;
	}
	public long getBuckId() {
		return buckId;
	}
	public void setBuckId(long buckId) {
		this.buckId = buckId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getGradYear() {
		return gradYear;
	}
	public void setGradYear(String gradYear) {
		this.gradYear = gradYear;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	
	@Override
	public String toString() {
		StringBuffer  sb = new StringBuffer();
		sb.append("The details of the Student are: \nid : " + this.buckId);
		sb.append("\nName : " + firstName + " " + lastName);
		sb.append("\nDate of birth : " + dob);
		sb.append("\nYear of graduation: " + dob + "\n");
		return sb.toString();
	}
}
