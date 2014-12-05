package service;

import java.util.Collection;

import entity.Student;
import exception.YearbookException;

public interface StudentService{
	public boolean addStudent(long buckId, String contactNumber, int deptId, String dob, String email,
			String firstName, String gradYear, String jobInternDetails, String lastName,
			  String password, String username, String url) throws YearbookException;
	
	public boolean updateStudent(long buckId, String contactNumber, int deptId, String dob, String email,
			String firstName, String gradYear, String jobInternDetails, String lastName,
			  String password, String username, String url) throws YearbookException;
	
	
	public Student getStudent(long buckId) throws YearbookException;
	
	public boolean deleteStudent(long buckId) throws YearbookException;
	
	public Collection<Student> getAllStudents() throws YearbookException;
	
	public Student login(String username, String password) throws YearbookException;

}