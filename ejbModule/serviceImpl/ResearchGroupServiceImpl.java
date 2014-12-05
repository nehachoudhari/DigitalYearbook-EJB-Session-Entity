package serviceImpl;

import java.util.Collection;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import service.ResearchGroupService;
import entity.ResearchGroup;
import exception.YearbookException;

@Stateless
public class ResearchGroupServiceImpl implements ResearchGroupService{

	@PersistenceContext(unitName="digital-yearbook")
	 EntityManager em;
	
	public boolean addResearchGroup(String name, int deptId, String description, String url, String photoUrl) throws YearbookException {
		ResearchGroup group = null;
		try{
			group = new ResearchGroup();
		
			group.setName(name);
			group.setDeptId(deptId);
			group.setUrl(url);
			group.setPhotoUrl(photoUrl);
			group.setDescription(description);
			em.persist(group);
			em.flush();
			return true;
		}catch(Exception e) {
			throw new YearbookException("An error occurred while adding the Research Group");
		}
		
	}
	
	public ResearchGroup getResearchGroup(int groupId) throws YearbookException {
		ResearchGroup group = null;
		try{
			group = em.find(ResearchGroup.class, groupId);
			if(group == null) {
				throw new YearbookException("No Research Group with id " + groupId);
			}
			return group;
		}catch(Exception e) {
			throw new YearbookException("An error occurred while fetching Research Group with id " + groupId);
		}
	}
	
	public boolean updateResearchGroup(int groupId, String name, int deptId, String description, String url, String photoUrl) throws YearbookException{
		ResearchGroup group = null;
		try{
			group = em.find(ResearchGroup.class, groupId);
			if(group == null) {
				throw new YearbookException("No Research Group with id " + groupId);
			}
			group.setName(name);
			group.setDeptId(deptId);
			group.setUrl(url);
			if(photoUrl != null && photoUrl != "") {
				group.setPhotoUrl(photoUrl);	
			}
			group.setDescription(description);
			return true;
		}catch(Exception e) {
			throw new YearbookException("An error occurred while updating Research Group with id " + groupId);
		}
	}
	
	public boolean deleteReseachGroup(int groupId) throws YearbookException{
		ResearchGroup group = null;
		try{
			group = em.find(ResearchGroup.class, groupId);
			if(group == null) {
				throw new YearbookException("No Research Group with id " + groupId);
			}
			em.remove(group);
			return true;
		}catch(Exception e) {
			throw new YearbookException("An error occurred while deleting Research Group with id " + groupId);
		}
	}
	
	public List<ResearchGroup> getAllResearchGroups() throws YearbookException {
		
		 Query query = em.createQuery("SELECT r FROM ResearchGroup r");
		   try{
			   return query.getResultList();
		   }
		   catch (Exception e) {
			   throw new YearbookException("An error occured while fetching all research groups");
		   }
		
	}
	
}
