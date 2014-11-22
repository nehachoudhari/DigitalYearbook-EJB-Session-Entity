package service;

import java.util.List;

import entity.Photograph;
import exception.YearbookException;

public interface DepartmentService {
	public String addDepartment(int deptId, String location, String mission, String name, String url, List<Photograph> photoList) throws YearbookException;
	
}
