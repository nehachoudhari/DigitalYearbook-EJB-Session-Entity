package service;

import java.util.List;

import entity.Event;
import exception.YearbookException;

public interface EventService{
	
	/**
	 * Add a new event. Event is automatically generated.
	 * @param eventName
	 * @param description
	 * @param date
	 * @param url
	 * @param photoUrl
	 * @return
	 * @throws YearbookException
	 */
	public boolean addEvent(String eventName, String description, String date, String url, String photoUrl) throws YearbookException;

	/**
	 * Updates event by event id.
	 * @param eventId
	 * @param eventName
	 * @param description
	 * @param date
	 * @param url
	 * @param photoUrl
	 * @return
	 * @throws YearbookException
	 */
	public boolean updateEvent(long eventId, String eventName, String description, String date, String url, String photoUrl) throws YearbookException;
	
	/**
	 * Get event by event id.
	 * @param eventId
	 * @return
	 * @throws YearbookException
	 */
	public Event getEvent (long eventId) throws YearbookException;
	
	/**
	 * Deletes an event by event id.
	 * @param eventId
	 * @return
	 * @throws YearbookException
	 */
	public boolean deleteEvent(long eventId) throws YearbookException;
	
	/**
	 * Returns all events for displaying in digital yearbook.
	 * @return
	 * @throws YearbookException
	 */
	public List<Event> getAllEvents() throws YearbookException;
}