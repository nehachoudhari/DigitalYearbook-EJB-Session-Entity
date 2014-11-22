package serviceImpl;

import javax.ejb.Stateless;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.ConstraintViolationException;

import service.StudentService;
import entity.Photograph;
import entity.Student;
import exception.YearbookException;

@Stateless
public class StudentImpl implements StudentService{
	 @PersistenceContext(unitName="digital-yearbook")
	 EntityManager em;
	 
	public String addStudent(long buckId, String contactNumber, int deptId, String dob, String email,
			String firstName, String gradYear, String jobInternDetails, String lastName,
			  String password, String username, Photograph photo) throws YearbookException{
		Student student = new Student();
		try{
			student.setBuckId(buckId);
			student.setContactNumber(contactNumber);
			student.setDeptId(deptId);
			student.setDob(dob);
			student.setEmail(email);
			student.setFirstName(firstName);
			student.setGradYear(gradYear);
			student.setJobInternDetails(jobInternDetails);
			student.setLastName(lastName);
			student.setPassword(password);
			student.setUsername(username);
			em.persist(student);
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
			throw new YearbookException("Some error occurred while adding Student..");
		}
		return "success";
	}
}
