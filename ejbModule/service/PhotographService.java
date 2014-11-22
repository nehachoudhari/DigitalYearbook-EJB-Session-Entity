package service;

import exception.YearbookException;


public interface PhotographService {
	public String addPhoto(String details, long photoId, String type, long typeId, String url) throws YearbookException;
	
}
