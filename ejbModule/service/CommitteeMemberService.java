package service;

import java.util.List;

import entity.CommitteeMember;
import exception.YearbookException;

public interface CommitteeMemberService {


	public boolean updateMember(int memberId, String fName, String lName,
			String designation, int deptId,  String photoUrl) throws YearbookException;
	
	
	public boolean addMember(String fName, String lName,
			String designation, int deptId,  String photoUrl) throws YearbookException;

	public boolean deleteMember(int memberId) throws YearbookException;
	
	public List<CommitteeMember> getAllCommitteeMembers(int deptId) throws YearbookException;
	
	public CommitteeMember getMember(int memberId) throws YearbookException;
}
