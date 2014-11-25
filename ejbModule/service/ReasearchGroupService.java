package service;

import java.util.List;

import entity.Department;
import entity.Photograph;
import entity.ResearchGroup;
import exception.YearbookException;

public interface ReasearchGroupService {

	public boolean addResearchGroup(String name, String description, String url, Photograph photo) throws YearbookException;
	
	public ResearchGroup getResearchGroup(int groupId) throws YearbookException;
	
	public boolean updateResearchGroup(int groupId, String name, String description, String url, Photograph photo) throws YearbookException;
	
	public boolean deleteReseachGroup(int groupId) throws YearbookException;
	

}
