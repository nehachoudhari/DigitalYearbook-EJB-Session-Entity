package service;

import entity.Photograph;
import entity.Student;
import exception.YearbookException;

public interface StudentService{
	public String addStudent(long buckId, String contactNumber, int deptId, String dob, String email,
			String firstName, String gradYear, String jobInternDetails, String lastName,
			  String password, String username, Photograph photo) throws YearbookException;
	
	public boolean updateStudent(long buckId, String contactNumber, int deptId, String dob, String email,
			String firstName, String gradYear, String jobInternDetails, String lastName,
			  String password, String username, Photograph photo) throws YearbookException;
	
	
	public Student getStudent(long buckId) throws YearbookException;
	
	public boolean deleteStudent(long buckId) throws YearbookException;
	

}