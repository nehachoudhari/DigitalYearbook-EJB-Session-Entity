package service;

import java.util.List;

import entity.Event;
import entity.Photograph;
import exception.YearbookException;

public interface EventService{
	
	public void addEvent(Event event, List<Photograph> photoList) throws YearbookException;
	
	public void updateEvent(Event event, List<Photograph> photoList) throws YearbookException;
	
	public void deleteEvent(Event event) throws YearbookException;
}
