package serviceImpl;

import java.util.Collection;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintViolationException;

import service.CommitteeMemberService;
import entity.CommitteeMember;
import entity.Department;
import exception.YearbookException;


@Stateless
public class CommitteeMemberServiceImpl implements CommitteeMemberService{

	 @PersistenceContext(unitName="digital-yearbook")
	 EntityManager em;

	@Override
	public boolean addMember(String fName, String lName, String designation
			, int deptId, String photoUrl)
			throws YearbookException {
		CommitteeMember member = new CommitteeMember();
		try{
			member.setDeptId(deptId);
			member.setDesignation(designation);
			member.setfName(fName);
			member.setlName(lName);
			member.setPhotoUrl(photoUrl);
		
			em.persist(member);
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
			throw new YearbookException("An error occurred while adding a committee member");
		}
		return true;
		
	}

	@Override
	public boolean updateMember(long memberId, String fName, String lName,
			String designation, int deptId,  String photoUrl) throws YearbookException {
		
		CommitteeMember member = null;
		try{
			member = em.find(CommitteeMember.class, memberId);
			if(member == null) {
				throw new YearbookException("No committee member with id " + memberId);
			}
			member.setDeptId(deptId);
			member.setDesignation(designation);
			member.setfName(fName);
			member.setlName(lName);
			if(photoUrl != null || photoUrl != ""){ 
				member.setPhotoUrl(photoUrl);	
			}
			return true;
		}catch(Exception e) {
			throw new YearbookException("An error occurred while updating Committee member with id " + memberId);
		}
	}

	@Override
	public boolean deleteMember(long memberId) throws YearbookException {
		
		CommitteeMember member = null;
		try{
			member = em.find(CommitteeMember.class, memberId);
			if(member == null) {
				throw new YearbookException("No committee member with id " + memberId);
			}
			em.remove(member);
			return true;
		}catch(Exception e) {
			throw new YearbookException("An error occurred while deleting Committee member with id " + memberId);
		}
	}
	
	public CommitteeMember getMember(int memberId) throws YearbookException{
		
		CommitteeMember member = null;
		try{
			member = em.find(CommitteeMember.class, memberId);
			if(member == null) {
				throw new YearbookException("No committee member with id " + memberId);
			}
			return member;
		}catch(Exception e) {
			throw new YearbookException("An error occurred retriving committee member with id " + memberId);
		}
	}
	
	public List<CommitteeMember> getAllCommitteeMembers() throws YearbookException {
		 Query query = em.createQuery("SELECT c FROM CommitteeMember c");
		 	//	+ "where c.deptId = "+ deptId);
		   try{
			   return (List<CommitteeMember>) query.getResultList();
		   
		   }
		   catch (Exception e) {
			   throw new YearbookException("An error occured while fetching all committee members");
		   }
	}

}
