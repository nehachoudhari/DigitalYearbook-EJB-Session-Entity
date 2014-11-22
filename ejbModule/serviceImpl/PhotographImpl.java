package serviceImpl;

import javax.ejb.Stateless;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.ConstraintViolationException;

import service.PhotographService;
import entity.Photograph;
import exception.YearbookException;

@Stateless
public class PhotographImpl implements PhotographService{
	@PersistenceContext(unitName="digital-yearbook")
	 EntityManager em;
	
	public String addPhoto(String details, long photoId, String type, long typeId, String url) throws YearbookException{
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
			return "Exists";
		}
		
		catch(ConstraintViolationException e)
		{
			return "Exists";
		}
		catch(Exception e){
			throw new YearbookException("Some error occurred while adding Photograph..");
		}
		return "success";
	}
}
