package serviceImpl;

import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;

import service.EventService;
import entity.Event;
import entity.Photograph;
import exception.YearbookException;

public class EventServiceImpl extends ParentAbstract implements EventService{

	 @PersistenceContext(unitName="digital-yearbook")
	 EntityManager em;
	 
	
	@Override
	public boolean addEvent(String eventName, String description, String date, String url, List<Photograph> photoList)
			throws YearbookException {
		
		Event event = new Event();
		try{
			event.setName(eventName);
			event.setDescription(description);
			event.setDate(date);
			event.setUrl(url);
			
			em.getTransaction().begin();
			em.persist(event);
			em.getTransaction().commit();
			
			//TODO : photolist
			
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
	public boolean updateEvent(long eventId, String eventName, String description, String date, String url, List<Photograph> photoList)
			throws YearbookException {
		
		Event event = null;
		
		try{
			event = em.find(Event.class, eventId);
			if(event == null){
				throw new EntityNotFoundException();
			}
			
			em.getTransaction().begin();
			event.setName(eventName);
			event.setDescription(description);
			event.setDate(date);
			event.setUrl(url);
			
			//TODO : photolist
			
			em.getTransaction().commit();
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
			em.getTransaction().begin();
			em.remove(event);
			em.getTransaction().commit();
			
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
}