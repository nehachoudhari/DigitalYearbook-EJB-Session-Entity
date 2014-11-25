package serviceImpl;

import javax.ejb.Stateless;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.ConstraintViolationException;

import service.PhotographService;
import entity.Department;
import entity.Photograph;
import exception.YearbookException;

@Stateless
public class PhotographServiceImpl implements PhotographService{
	@PersistenceContext(unitName="digital-yearbook")
	 EntityManager em;
	
	public boolean addPhoto(String details, long photoId, String type, long typeId, String url) throws YearbookException{
		Photograph photo = new Photograph();
		try{
			photo.setDetails(details);
			photo.setPhotoId(photoId);
			photo.setType(type);
			photo.setTypeId(typeId);
			photo.setUrl(url);
			em.persist(photo);
			em.flush();
		}
		catch(EntityExistsException e)
		{
			return false;
		}
		
		catch(ConstraintViolationException e)
		{
			return false;
		}
		catch(Exception e){
			throw new YearbookException("Some error occurred while adding Photograph..");
		}
		return true;
	}
	
	public boolean updatePhoto(long photoId, String details) throws YearbookException{
		
		Photograph photo = null;
		try{
			photo = em.find(Photograph.class, photoId);
			if(photo == null) {
				throw new YearbookException("No photo with id " + photoId);
			}
			photo.setDetails(details);
			return true;
		}catch(Exception e) {
			throw new YearbookException("Some error occurred while updating photo with id " + photoId);
		}
	}
	
	public Photograph getPhoto(long photoId) throws YearbookException{
	
		Photograph photo = null;
		try{
			photo = em.find(Photograph.class, photoId);
			if(photo == null) {
				throw new YearbookException("No photo with id " + photoId);
			}
			
			return photo;
		}catch(Exception e) {
			throw new YearbookException("Some error occurred while fetching photo with id " + photoId);
		}
	}
	
	
	public boolean deletePhoto(long photoId) throws YearbookException{
		
		Photograph photo = null;
		try{
			photo = em.find(Photograph.class, photoId);
			if(photo == null) {
				throw new YearbookException("No photo with id " + photoId);
			}
			em.remove(photo);
			return true;
		}catch(Exception e) {
			throw new YearbookException("Some error occurred while deleting photo with id " + photoId);
		}
	}
}
