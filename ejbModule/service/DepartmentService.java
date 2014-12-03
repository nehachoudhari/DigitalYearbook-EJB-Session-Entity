package service;

import java.util.Collection;

import entity.Department;
import exception.YearbookException;

public interface DepartmentService {
	public boolean addDepartment(int deptId, String location, String mission, String name, String url, String photoUrl) throws YearbookException;
	
	public Department getDepartment(int deptId) throws YearbookException;
	
	public boolean updateDepartment(int deptId, String location, String mission, String name, String url, String photoUrl) throws YearbookException;
	
	public boolean deleteDepartment(int deptId) throws YearbookException;
	
	public Collection<Department> getAllDepartments() throws YearbookException;
	
	
}
