package service;

import java.util.List;

import entity.Student;
import exception.YearbookException;

public interface StudentService{
	/**
	 * Add a new student with buck id as unique.
	 * @param buckId
	 * @param contactNumber
	 * @param deptId
	 * @param dob
	 * @param email
	 * @param firstName
	 * @param gradYear
	 * @param jobInternDetails
	 * @param lastName
	 * @param password
	 * @param username
	 * @param url
	 * @return
	 * @throws YearbookException
	 */
	public boolean addStudent(long buckId, String contactNumber, int deptId, String dob, String email,
			String firstName, String gradYear, String jobInternDetails, String lastName,
			  String password, String username, String url) throws YearbookException;
	
	/**
	 * Updates student by buck id.
	 * @param buckId
	 * @param contactNumber
	 * @param deptId
	 * @param dob
	 * @param email
	 * @param firstName
	 * @param gradYear
	 * @param jobInternDetails
	 * @param lastName
	 * @param password
	 * @param username
	 * @param url
	 * @return
	 * @throws YearbookException
	 */
	public boolean updateStudent(long buckId, String contactNumber, int deptId, String dob, String email,
			String firstName, String gradYear, String jobInternDetails, String lastName,
			  String password, String username, String url) throws YearbookException;
	
	
	/**
	 * Get student by buck id
	 * @param buckId
	 * @return
	 * @throws YearbookException
	 */
	public Student getStudent(long buckId) throws YearbookException;
	
	/**
	 * Deletes a student by buck id
	 * @param buckId
	 * @return
	 * @throws YearbookException
	 */
	public boolean deleteStudent(long buckId) throws YearbookException;
	
	/**
	 * Get all students to display in digital yearbook
	 * @return
	 * @throws YearbookException
	 */
	public List<Student> getAllStudents() throws YearbookException;
	
	/**
	 * Logs in the student if the username and password provided are correct.
	 * @param username
	 * @param password
	 * @return
	 * @throws YearbookException
	 */
	public Student login(String username, String password) throws YearbookException;

}