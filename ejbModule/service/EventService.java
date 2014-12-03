package service;

import java.util.Collection;
import java.util.List;

import entity.Event;
import exception.YearbookException;

public interface EventService{
	
	public boolean addEvent(String eventName, String description, String date, String url, String photoUrl) throws YearbookException;

	public boolean updateEvent(long eventId, String eventName, String description, String date, String url, String photoUrl) throws YearbookException;
	
	public Event getEvent (long eventId) throws YearbookException;
	
	public boolean deleteEvent(long eventId) throws YearbookException;
	
	public Collection<Event> getAllEvents() throws YearbookException;
}