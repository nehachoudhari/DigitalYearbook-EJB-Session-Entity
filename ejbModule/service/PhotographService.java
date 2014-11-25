package service;

import entity.Photograph;
import exception.YearbookException;


public interface PhotographService {
	public boolean addPhoto(String details, long photoId, String type, long typeId, String url) throws YearbookException;
	
	public Photograph getPhoto(long photoId) throws YearbookException;
	
	public boolean updatePhoto(long photoId, String details) throws YearbookException;
	
	public boolean deletePhoto(long photoId) throws YearbookException;
}
