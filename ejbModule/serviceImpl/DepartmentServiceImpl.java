package serviceImpl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintViolationException;

import service.DepartmentService;
import entity.Department;
import exception.YearbookException;

@Stateless
public class DepartmentServiceImpl implements DepartmentService{
	
	@PersistenceContext(unitName="digital-yearbook")
	EntityManager em;
	
 	public boolean addDepartment(int deptId, String location, String mission, String name, String url, String photoUrl)
	throws YearbookException{
		Department dept = new Department();
		try{
			dept.setDeptId(deptId);
			dept.setLocation(location);
			dept.setMission(mission);
			dept.setName(name);
			dept.setUrl(url);
			dept.setPhotoUrl(photoUrl);
			em.persist(dept);
			em.flush();
		}
		catch(EntityExistsException e)
		{
			return false;
		}
		
		catch(ConstraintViolationException e)
		{
			return false;
		}
		catch(Exception e){
			System.out.println(e.getMessage());
			throw new YearbookException("An error occurred while adding Department..");
		}
		return true;
	}


	public Department getDepartment(int deptId) throws YearbookException {
		Department dept = null;
		try{
			dept = em.find(Department.class, deptId);
			if(dept == null) {
				throw new YearbookException("No Department with id " + deptId);
			}
			return dept;
		}catch(Exception e) {
			throw new YearbookException("An error occurred retriving Department with id " + deptId);
		}
		
	}
	
	public boolean updateDepartment(int deptId, String location, String mission, String name, String url, String photoUrl) throws YearbookException {
		Department dept = null;
		try{
			dept = em.find(Department.class, deptId);
			if(dept == null) {
				throw new YearbookException("No Department with id " + deptId);
			}
			dept.setLocation(location);
			dept.setMission(mission);
			dept.setName(name);
			dept.setUrl(url);
			if(photoUrl != null && photoUrl != ""){
				dept.setPhotoUrl(photoUrl);
			}
			return true;
		}catch(Exception e) {
			throw new YearbookException("An error occurred while updating Department with id " + deptId);
		}
	}
	
	public boolean deleteDepartment(int deptId) throws YearbookException {
		Department dept = null;
		try{
			Query query = em.createQuery("DELETE FROM CommitteeMember where deptId = "+deptId);
			query.executeUpdate();
			query = em.createQuery("DELETE FROM ResearchGroup where deptId = "+deptId);
			query.executeUpdate();
			query = em.createQuery("DELETE FROM Student where deptId = "+deptId);
			query.executeUpdate();
			dept = em.find(Department.class, deptId);
			if(dept == null) {
				throw new YearbookException("No Department with id " + deptId);
			}
			em.remove(dept);
			return true;
		}catch(Exception e) {
			throw new YearbookException("An error occurred while updating Department with id " + deptId);
		}
	}
 	
	public List<Department> getAllDepartments() throws YearbookException{
		  Query query = em.createQuery("SELECT d FROM Department d");
		   try{
			   return query.getResultList();
		   }
		   catch (Exception e) {
			   throw new YearbookException("An error occured while fetching all departments");
		   }
	}
}
