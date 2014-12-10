package service;

import java.util.List;

import entity.CommitteeMember;
import exception.YearbookException;

public interface CommitteeMemberService {


	/**
	 * Committee member is updated given the member id.
	 * @param memberId
	 * @param fName
	 * @param lName
	 * @param designation
	 * @param deptId
	 * @param photoUrl
	 * @return boolean
	 * @throws YearbookException
	 */
	public boolean updateMember(long memberId, String fName, String lName,
			String designation, int deptId,  String photoUrl) throws YearbookException;
	
	
	/**
	 * Add a new committee member. Member id is automatically generated.
	 * @param fName
	 * @param lName
	 * @param designation
	 * @param deptId
	 * @param photoUrl
	 * @return boolean
	 * @throws YearbookException
	 */
	public boolean addMember(String fName, String lName,
			String designation, int deptId,  String photoUrl) throws YearbookException;

	/**
	 * Delete a member by member id.
	 * @param memberId
	 * @return boolean
	 * @throws YearbookException
	 */
	public boolean deleteMember(long memberId) throws YearbookException;
	
	/**
	 * Gets all committee members for yearbook display.
	 * @return
	 * @throws YearbookException
	 */
	public List<CommitteeMember> getAllCommitteeMembers() throws YearbookException;
	
	/**
	 * Get member by member id
	 * @param memberId
	 * @return
	 * @throws YearbookException
	 */
	public CommitteeMember getMember(long memberId) throws YearbookException;
}
