package service;

import java.util.List;

import entity.ResearchGroup;
import exception.YearbookException;

public interface ResearchGroupService {

	/**
	 * Add a new research group. Group id is automatically generated.
	 * @param name
	 * @param deptId
	 * @param description
	 * @param url
	 * @param photoUrl
	 * @return
	 * @throws YearbookException
	 */
	public boolean addResearchGroup(String name,int deptId, String description, String url, String photoUrl) throws YearbookException;
	
	/**
	 * Get research group by research id.
	 * @param groupId
	 * @return
	 * @throws YearbookException
	 */
	public ResearchGroup getResearchGroup(long groupId) throws YearbookException;
	
	/**
	 * Update research by research id.
	 * @param groupId
	 * @param name
	 * @param deptId
	 * @param description
	 * @param url
	 * @param photoUrl
	 * @return
	 * @throws YearbookException
	 */
	public boolean updateResearchGroup(long groupId, String name, int deptId, String description, String url, String photoUrl) throws YearbookException;
	
	/**
	 * Given a group id, deletes record for that research.
	 * @param groupId
	 * @return
	 * @throws YearbookException
	 */
	public boolean deleteReseachGroup(long groupId) throws YearbookException;

	/**
	 * Gets all research groups for digital yearbook display.
	 * @return
	 * @throws YearbookException
	 */
	public List<ResearchGroup> getAllResearchGroups() throws YearbookException;
	
}
