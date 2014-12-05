package service;

import java.util.Collection;
import java.util.List;

import entity.ResearchGroup;
import exception.YearbookException;

public interface ResearchGroupService {

	public boolean addResearchGroup(String name,int deptId, String description, String url, String photoUrl) throws YearbookException;
	
	public ResearchGroup getResearchGroup(int groupId) throws YearbookException;
	
	public boolean updateResearchGroup(int groupId, String name, int deptId, String description, String url, String photoUrl) throws YearbookException;
	
	public boolean deleteReseachGroup(int groupId) throws YearbookException;

	public List<ResearchGroup> getAllResearchGroups() throws YearbookException;
	
}
