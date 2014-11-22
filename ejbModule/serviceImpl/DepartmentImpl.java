package serviceImpl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.ConstraintViolationException;

import service.DepartmentService;
import entity.Department;
import entity.Photograph;
import exception.YearbookException;

@Stateless
public class DepartmentImpl implements DepartmentService{
	@PersistenceContext(unitName="digital-yearbook")
	 EntityManager em;
	
 	public String addDepartment(int deptId, String location, String mission, String name, String url, List<Photograph> photoList)
	throws YearbookException{
		Department dept = new Department();
		try{
			dept.setDeptId(deptId);
			dept.setLocation(location);
			dept.setMission(mission);
			dept.setName(name);
			dept.setUrl(url);
			em.persist(dept);
			em.flush();
		}
		catch(EntityExistsException e)
		{
			return "Exists";
		}
		
		catch(ConstraintViolationException e)
		{
			return "Exists";
		}
		catch(Exception e){
			throw new YearbookException("Some error occurred while adding Department..");
		}
		return "success";
	}

}
