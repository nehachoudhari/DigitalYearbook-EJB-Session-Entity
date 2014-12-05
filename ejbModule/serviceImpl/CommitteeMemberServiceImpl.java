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
import exception.YearbookException;


@Stateless
public class CommitteeMemberServiceImpl implements CommitteeMemberService{

	 @PersistenceContext(unitName="digital-yearbook")
	 EntityManager em;
	
//	public CommitteeMemberServiceImpl(EntityManager em) {
//		this.em = em;
//	}
	
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
			throw new YearbookException("Some error occurred while adding Department..");
		}
		return true;
		
	}

	@Override
	public boolean updateMember(int memberId, String fName, String lName,
			String designation, int deptId,  String photoUrl) throws YearbookException {
		
		Query query = em.createQuery("Update CommitteeMember c WHERE c.MEMBER_ID = :id");
		int deletedCount = query.setParameter("id", memberId).executeUpdate();	
		if(deletedCount>0){
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean deleteMember(int memberId) throws YearbookException {
		Query query = em.createQuery("DELETE FROM CommitteeMember c WHERE c.MEMBER_ID = :id");
		int deletedCount = query.setParameter("id", memberId).executeUpdate();	
		if(deletedCount>0){
			return true;
		} else {
			return false;
		}
	}
	
	@SuppressWarnings("unchecked")
	public CommitteeMember getMember(int memberId) throws YearbookException{
		
		List<CommitteeMember> members= null;
		CommitteeMember  member = null;
		Query query = em.createNativeQuery
				("select * from CommitteeMember where MEMBER_ID='" + memberId + "'", CommitteeMember.class);

		members = query.getResultList();
		if(!members.isEmpty()){
			member = members.get(0);
			return member;
		}
		else {
			throw new YearbookException("No committee member with id " + memberId);
		}
	}
	
	
	public Collection<CommitteeMember> getAllCommitteeMembers() throws YearbookException {
		 Query query = em.createQuery("SELECT c FROM CommitteeMember c");
		   try{
			   return (Collection<CommitteeMember>) query.getResultList();
		   }
		   catch (Exception e) {
			   throw new YearbookException("Error occured while fetching all committee members");
		   }
	}

}
