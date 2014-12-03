package serviceImpl;

import java.util.Collection;

import javax.ejb.Stateless;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintViolationException;

import service.StudentService;
import entity.Student;
import exception.YearbookException;

@Stateless
public class StudentServiceImpl implements StudentService{
	 @PersistenceContext(unitName="digital-yearbook")
	 EntityManager em;
	 
	public boolean addStudent(long buckId, String contactNumber, int deptId, String dob, String email,
			String firstName, String gradYear, String jobInternDetails, String lastName,
			  String password, String username, String url) throws YearbookException{
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
			student.setPhotoUrl(url);
			em.getTransaction().begin();
			em.persist(student);
			//em.flush();
			em.getTransaction().commit();
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
			throw new YearbookException(e.getLocalizedMessage());
		}
		return true;
	}

	@Override
	public boolean updateStudent(long buckId, String contactNumber, int deptId, String dob, String email,
			String firstName, String gradYear, String jobInternDetails, String lastName, String password,
			String username, String url) throws YearbookException {
		
		Student student = null;
		
		try{
			student = em.find(Student.class, buckId);
			
			if(student == null){
				throw new EntityNotFoundException();				
			}
			
			em.getTransaction().begin();
			
			student.setContactNumber(contactNumber);
			student.setDeptId(deptId);
			student.setDob(dob);
			student.setEmail(email);
			student.setFirstName(firstName);
			student.setLastName(lastName);
			student.setGradYear(gradYear);
			student.setJobInternDetails(jobInternDetails);
			
			student.setUsername(username);
			student.setPassword(password);
			
			student.setPhotoUrl(url);
			
			em.getTransaction().commit();
			
			return true;
			
		}
		catch(Exception ex){
			if (ex.equals(EntityNotFoundException.class)){
				throw new YearbookException("Student not found with buckId: "+buckId);
			}
			else{
				throw new YearbookException("Error in updating in student information, buckID: "+buckId + " message: "+ ex.getLocalizedMessage());
			}
		}
		
	}

	@Override
	public Student getStudent(long buckId) throws YearbookException{
		try{
			Student student = em.find(Student.class, buckId);
			
			if(student == null){
				throw new EntityNotFoundException();
			}
			
			return student;
		}
		catch(Exception ex){
			if (ex.equals(EntityNotFoundException.class)){
				throw new YearbookException("Student not found with buckId: "+ buckId);
			}
			else{
				throw new YearbookException("Error in retreiving student information, buckID: "+buckId + " message: " + ex.getLocalizedMessage());
			}
		}
		
	}

	@Override
	public boolean deleteStudent(long buckId) throws YearbookException {
		// TODO Auto-generated method stub
		
		Student student = null;
		
		try{
			student = em.find(Student.class, buckId);
			if(student == null){
				throw new EntityNotFoundException();
			}
			em.getTransaction().begin();
			em.remove(student);
			em.getTransaction().commit();
			return true;
			
		}
		catch(Exception ex){
			if (ex.equals(EntityNotFoundException.class)){
				throw new YearbookException("Student not found with buckId: "+buckId);
			}
			else{
				throw new YearbookException("Error in deleting student information, buckID: "+buckId + " message: " + ex.getLocalizedMessage());
			}
		}
		
	}

	public Collection<Student> getAllStudents() throws YearbookException {
		   Query query = em.createQuery("SELECT s FROM Student s");
		   try{
			   return (Collection<Student>) query.getResultList();
		   }
		   catch (Exception e) {
			   throw new YearbookException("Error occured while fetching all students");
		   }
		
	}
	
}