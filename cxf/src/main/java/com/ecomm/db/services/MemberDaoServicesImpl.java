package com.ecomm.db.services;

import java.util.List;
import com.ecomm.dao.MemberDAO;
import com.ecomm.dbentity.Member;
import com.ecomm.exception.EcommException;
import com.ecomm.commonutility.logger.EcommLogger;
import org.springframework.transaction.annotation.Transactional;


public class MemberDaoServicesImpl {

	private MemberDAO memberDAO;
	
	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}
	
	@Transactional
	public List<Member> listAllMembers() throws EcommException {
		try{
			return memberDAO.listAllMembers();
		}catch(Exception e){
			throw new EcommException(500, e);
		}
	}

	@Transactional
	public Member listMemberById(String memberId) throws EcommException {
		try{
			Member member =  memberDAO.listMemberById(memberId);
			if(member == null){
				throw new EcommException(404, "No Member found with id: "+memberId);
			}
			return member;
		}catch(EcommException e){
			throw e;
		}catch(Exception e){
			throw new EcommException(500, e);
		}
	}

	@Transactional
	public Member addMember(Member member) throws EcommException {
		try{
			return memberDAO.addMember(member);
		}catch(Exception e){
			throw new EcommException(500, e);
		}
	}

	@Transactional
	public Member updateMember(Member member) throws EcommException {
		try{
			return memberDAO.updateMember(member);
		}catch(Exception e){
			throw new EcommException(500, e);
		}
	}

	@Transactional
	public void deleteMember(Member member) throws EcommException {
		try{
			memberDAO.deleteMember(member);
		}catch(Exception e){
			throw new EcommException(500, e);
		}	
	}

	@Transactional
	public void deleteMemberById(String memberId) throws EcommException {
		try{
			Member member = memberDAO.listMemberById(memberId);
			memberDAO.deleteMember(member);
		}catch(Exception e){
			throw new EcommException(500, e);
		}
	}

	@Transactional
	public void deleteAllMembers() throws EcommException {
		try{
			memberDAO.deleteAllMembers();
		}catch(Exception e){
			throw new EcommException(500, e);
		}
	}

	@Transactional
	public void addMemberList(List<Member> dbmemberList) throws EcommException {
		try{
			List<Member> list = memberDAO.addMemberList(dbmemberList);
			EcommLogger.info(list.toString());
		}catch(Exception e){
			throw new EcommException(500, e);
		}
	}

}
