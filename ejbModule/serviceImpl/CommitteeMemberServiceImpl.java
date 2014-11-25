package serviceImpl;

import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintViolationException;

import service.CommitteeMemberService;
import entity.CommitteeMember;
import entity.Event;
import entity.Photograph;
import exception.YearbookException;

public class CommitteeMemberServiceImpl implements CommitteeMemberService{

	 @PersistenceContext(unitName="digital-yearbook")
	 EntityManager em;
	
	public CommitteeMemberServiceImpl(EntityManager em) {
		this.em = em;
	}
	
	@Override
	public String addMember(int memberId, String fName, String lName, String designation
			, int deptId)
			throws YearbookException {
		CommitteeMember member = new CommitteeMember();
		try{
			member.setDeptId(deptId);
			member.setDesignation(designation);
			member.setfName(fName);
			member.setlName(lName);
			member.setMember_id(memberId);
		
			em.persist(member);
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
			throw new YearbookException("Some error occurred while adding Department..");
		}
		return "success";
		
	}

	@Override
	public void updateMember(Event event, List<Photograph> photoList)
			throws YearbookException {
		
		
	}

	@Override
	public void deleteMember(int memberId) throws YearbookException {
		Query query = em.createQuery("DELETE FROM COMMITTEE_MEMBER c WHERE c.MEMBER_ID = :id");
			  int deletedCount = query.setParameter("id", memberId).executeUpdate();			 
	}
	
	@SuppressWarnings("unchecked")
	public CommitteeMember getMember(int memberId) throws YearbookException{
		
		List<CommitteeMember> members= null;
		CommitteeMember  member = null;
		Query query = em.createNativeQuery
				("select * from COMMITTEE_MEMBER where MEMBER_ID='" + memberId + "'", CommitteeMember.class);

		members = query.getResultList();
		if(!members.isEmpty()){
			member = members.get(0);
			return member;
		}
		else {
			throw new YearbookException("No committee member with id " + memberId);
		}
	}

}
