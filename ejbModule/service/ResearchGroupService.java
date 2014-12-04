package service;

import java.util.Collection;

import entity.ResearchGroup;
import exception.YearbookException;

public interface ResearchGroupService {

	public boolean addResearchGroup(String name, String description, String url, String photoUrl) throws YearbookException;
	
	public ResearchGroup getResearchGroup(int groupId) throws YearbookException;
	
	public boolean updateResearchGroup(int groupId, String name, String description, String url, String photoUrl) throws YearbookException;
	
	public boolean deleteReseachGroup(int groupId) throws YearbookException;

	public Collection<ResearchGroup> getAllResearchGroups() throws YearbookException;
	
}
