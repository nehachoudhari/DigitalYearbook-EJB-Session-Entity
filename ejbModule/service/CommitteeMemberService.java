package service;

import java.util.List;

import entity.Event;
import entity.Photograph;
import exception.YearbookException;

public interface CommitteeMemberService {

	//TODO change everything

	public void updateMember(Event event, List<Photograph> photoList) throws YearbookException;
	
	
	String addMember(int memberId, String fName, String lName,
			String designation, int deptId) throws YearbookException;

	void deleteMember(int memberId) throws YearbookException;
}
