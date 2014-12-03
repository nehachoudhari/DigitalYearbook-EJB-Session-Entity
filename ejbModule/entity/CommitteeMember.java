package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author nhchdhr
 * 
 * This class represents the Committee Member entity and provides getters and setters for its fields
 * Student entity is mapped to Committee_Member table in the database 
 *
 */

@Entity
@Table(name="Committee_Member")
public class CommitteeMember {

	@Id
	@Column(name="MEMBER_ID")
	private long member_id;
	
	@Column(name="FNAME")
	private String fName;
	
	@Column(name="LNAME")
	private String lName;
	
	@Column(name="DESIGNATION")
	private String designation;
	
	@Column(name="DEPT_ID")
	private int deptId;
	
	@Column(name="URL")
	private String url;
	

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public long getMember_id() {
		return member_id;
	}

	public void setMember_id(long member_id) {
		this.member_id = member_id;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

}
