package serviceImpl;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entity.Department;
import entity.Photograph;
import entity.ResearchGroup;
import entity.Student;
import exception.YearbookException;

public class ReasearchGroupServiceImpl {

	@PersistenceContext(unitName="digital-yearbook")
	 EntityManager em;
	
	public boolean addResearchGroup(String name, String description, String url, Photograph photo) throws YearbookException {
		ResearchGroup group = null;
		try{
			group = new ResearchGroup();
		
			group.setName(name);
			group.setUrl(url);
			group.setPhoto(photo);
			group.setDescription(description);
			em.persist(group);
			em.flush();
			return true;
		}catch(Exception e) {
			throw new YearbookException("Some error occurred while adding the Research Group");
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
			throw new YearbookException("Some error occurred while fetching Research Group with id " + groupId);
		}
	}
	
	public boolean updateResearchGroup(int groupId, String name, String description, String url, Photograph photo) throws YearbookException{
		ResearchGroup group = null;
		try{
			group = em.find(ResearchGroup.class, groupId);
			if(group == null) {
				throw new YearbookException("No Research Group with id " + groupId);
			}
			group.setName(name);
			group.setUrl(url);
			group.setPhoto(photo);
			group.setDescription(description);
			return true;
		}catch(Exception e) {
			throw new YearbookException("Some error occurred while updating Research Group with id " + groupId);
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
			throw new YearbookException("Some error occurred while deleting Research Group with id " + groupId);
		}
	}
	
	public Collection<ResearchGroup> getAllResearchGroups() throws YearbookException {
		
		 Query query = em.createQuery("SELECT r FROM ResearchGroup r");
		   try{
			   return (Collection<ResearchGroup>) query.getResultList();
		   }
		   catch (Exception e) {
			   throw new YearbookException("Error occured while fetching all students");
		   }
		
	}
	
}
