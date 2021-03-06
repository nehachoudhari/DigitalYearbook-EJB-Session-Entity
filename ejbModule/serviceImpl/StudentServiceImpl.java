package serviceImpl;

import java.util.Collection;
import java.util.List;

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
			em.persist(student);
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
			throw new YearbookException(e.getLocalizedMessage());
		}
		return true;
	}

	@Override
	public boolean updateStudent(long buckId, String contactNumber, int deptId, String dob, String email,
			String firstName, String gradYear, String jobInternDetails, String lastName, String password,
			String username, String photoUrl) throws YearbookException {
		
		Student student = null;
		
		try{
			student = em.find(Student.class, buckId);
			
			if(student == null){
				throw new EntityNotFoundException();				
			}
			
			
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
			if(photoUrl != null && photoUrl != "") {
				student.setPhotoUrl(photoUrl);
			}
			
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
		Student student = null;
		System.out.println("Inside getStudent");
		Query query = em.createQuery("SELECT s FROM Student s where s.buckId = "+buckId);
		try{
			System.out.println("Inside getstudent "+buckId);
			student = (Student)query.getResultList().get(0);//em.find(Student.class, buckId);
			System.out.println(student);
			if(student == null){
				throw new YearbookException("No student with id " + buckId);
			}
			return student;
		}catch(Exception e) {
			throw new YearbookException("An error occurred retriving student with id " + buckId);
		}
		
	}

	@Override
	public boolean deleteStudent(long buckId) throws YearbookException {
	
		Student student = null;
		
		try{
			student = em.find(Student.class, buckId);
			if(student == null){
				throw new EntityNotFoundException();
			}
			em.remove(student);
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

	public List<Student> getAllStudents() throws YearbookException {
		Query query = em.createQuery("SELECT s FROM Student s");//where s.deptId = " + deptId);
		   try{
			   return (List<Student>) query.getResultList();
		   }
		   catch (Exception e) {
			   throw new YearbookException("Error occured while fetching all students");
		   }
		
	}

	@Override
	public Student login(String username, String password)
			throws YearbookException {
		Query query = em.createQuery("SELECT s FROM Student s where s.username = '"+username+"' and s.password = '"+password+"'");
		try{
			List<Student> students = query.getResultList();
			if(!students.isEmpty() && students.size()==1){
				System.out.println("There is user!!");
				return students.get(0);
			}
		}catch (Exception e) {
			throw new YearbookException("An error occured while fetching a student with given username and password");
		}
		return null;
	}
	
}