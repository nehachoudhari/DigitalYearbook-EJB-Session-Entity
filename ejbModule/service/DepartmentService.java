package service;

import java.util.Collection;

import entity.Department;
import exception.YearbookException;

public interface DepartmentService {
	/**
	 * Adds a department and deptId is automatically generated.
	 * @param deptId
	 * @param location
	 * @param mission
	 * @param name
	 * @param url
	 * @param photoUrl
	 * @return
	 * @throws YearbookException
	 */
	public boolean addDepartment(int deptId, String location, String mission, String name, String url, String photoUrl) throws YearbookException;
	
	/**
	 * Gets department by department id.
	 * @param deptId
	 * @return
	 * @throws YearbookException
	 */
	public Department getDepartment(int deptId) throws YearbookException;
	
	/**
	 * Updates department by department id.
	 * @param deptId
	 * @param location
	 * @param mission
	 * @param name
	 * @param url
	 * @param photoUrl
	 * @return
	 * @throws YearbookException
	 */
	public boolean updateDepartment(int deptId, String location, String mission, String name, String url, String photoUrl) throws YearbookException;
	
	/**
	 * Deletes a department by department id
	 * @param deptId
	 * @return
	 * @throws YearbookException
	 */
	public boolean deleteDepartment(int deptId) throws YearbookException;
	
	/**
	 * Gets all departments for yearbook.
	 * @return
	 * @throws YearbookException
	 */
	public Collection<Department> getAllDepartments() throws YearbookException;
	
	
}
