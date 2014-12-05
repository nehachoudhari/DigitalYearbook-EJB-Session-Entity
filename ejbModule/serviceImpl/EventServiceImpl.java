package serviceImpl;

import java.util.Collection;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import service.EventService;
import entity.Event;
import exception.YearbookException;

@Stateless
public class EventServiceImpl implements EventService{

	 @PersistenceContext(unitName="digital-yearbook")
	 EntityManager em;
	 
	@Override
	public boolean addEvent(String eventName, String description, String date, String url, String photoUrl)
			throws YearbookException {
		
		Event event = new Event();
		try{
			event.setName(eventName);
			event.setDescription(description);
			event.setDate(date);
			event.setUrl(url);
			event.setPhotoUrl(photoUrl);			
			em.persist(event);
			em.flush();
			return true;
		}
		catch(Exception ex){
			if(ex.equals(EntityExistsException.class)){
				throw new YearbookException("Event with given information already exists");
			}
			else{
				throw new YearbookException("Error in saving event information, message: "+ex.getLocalizedMessage());
			}
		}
	}

	@Override
	public boolean updateEvent(long eventId, String eventName, String description, String date, String url, String photoUrl)
			throws YearbookException {
		
		Event event = null;
		try{
			event = em.find(Event.class, eventId);
			if(event == null){
				throw new EntityNotFoundException();
			}
			event.setName(eventName);
			event.setDescription(description);
			event.setDate(date);
			event.setUrl(url);
			if(photoUrl != null && photoUrl != ""){
				event.setPhotoUrl(photoUrl);
			}
			return true;
		}
		catch(Exception ex){
			if(ex.equals(EntityNotFoundException.class)){
				throw new YearbookException("Event with eventId:  "+ eventId +" not found");
			}
			else{
				throw new YearbookException("Error in updating event information, eventId: "+ eventId+" message: "+ex.getLocalizedMessage() );
			}
		}
	}

	@Override
	public boolean deleteEvent(long eventId) throws YearbookException {
		
		Event event = null;
		try{
			event = em.find(Event.class, eventId);
			if(event == null){
				throw new EntityNotFoundException();
			}
			em.remove(event);
			return true;
		}
		catch(Exception ex){
			if(ex.equals(EntityNotFoundException.class)){
				throw new YearbookException("Event with eventId:  "+ eventId +" not found");
			}
			else{
				throw new YearbookException("Error in deleting event information, eventId: "+ eventId+" message: "+ex.getLocalizedMessage() );
			}
		}
	}

	@Override
	public Event getEvent(long eventId) throws YearbookException {
	
		Event event = null;
		try{
			event = em.find(Event.class, eventId);
			if(event == null){
				throw new EntityNotFoundException();
			}
			return event;				
		}
		catch(Exception ex){
			if(ex.equals(EntityNotFoundException.class)){
				throw new YearbookException("Event with eventId:  "+ eventId +" not found");
			}
			else{
				throw new YearbookException("Error in retrieving event information, eventId: "+ eventId+" message: "+ex.getLocalizedMessage() );
			}
		}
	}
	
	public List<Event> getAllEvents() throws YearbookException {
		  Query query = em.createQuery("SELECT e FROM Event e");
		   try{
			   return query.getResultList();
		   }
		   catch (Exception e) {
			   throw new YearbookException("Error occured while fetching all events");
		   }
	}
}