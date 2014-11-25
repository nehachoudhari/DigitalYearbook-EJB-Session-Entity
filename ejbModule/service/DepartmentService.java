package service;

import java.util.Collection;
import java.util.List;

import entity.Department;
import entity.Photograph;
import exception.YearbookException;

public interface DepartmentService {
	public boolean addDepartment(int deptId, String location, String mission, String name, String url, List<Photograph> photoList) throws YearbookException;
	
	public Department getDepartment(int deptId) throws YearbookException;
	
	public boolean updateDepartment(int deptId, String location, String mission, String name, String url, Photograph photo) throws YearbookException;
	
	public boolean deleteDepartment(int deptId) throws YearbookException;
	
	public Collection<Department> getAllDepartments() throws YearbookException;
	
	
}
