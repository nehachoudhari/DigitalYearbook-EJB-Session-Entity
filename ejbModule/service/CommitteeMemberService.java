package service;

import java.util.List;

import entity.Event;
import entity.Photograph;
import exception.YearbookException;

public interface CommitteeMemberService {

	//TODO change everything

	public boolean updateMember(int memberId, String fName, String lName,
			String designation, int deptId,  String photoUrl) throws YearbookException;
	
	
	public boolean addMember(String fName, String lName,
			String designation, int deptId,  String photoUrl) throws YearbookException;

	public boolean deleteMember(int memberId) throws YearbookException;
	
}
