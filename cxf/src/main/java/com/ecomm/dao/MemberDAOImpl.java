package com.ecomm.dao;

import java.util.List;
import java.util.ArrayList;
import org.hibernate.Session;
import com.ecomm.dbentity.Member;
import com.ecomm.dao.utils.HibernateProperties;
import com.ecomm.dao.utils.DatabaseSessionManager;


public class MemberDAOImpl implements MemberDAO{

	// NAMED QUERY
	
	public List listAllMembers() {
		return DatabaseSessionManager.getDatabaseSession().createQuery("from Member").list();
	}

	public Member listMemberById(String memberId) {
		return (Member)DatabaseSessionManager.getDatabaseSession().get(Member.class, memberId);
	}

	public Member addMember(Member member) {
		Session session = DatabaseSessionManager.getDatabaseSession();
		String id = (String)session.save(member);
		return (Member)session.get(Member.class, id);
	}

	public Member updateMember(Member member) {
		Session session = DatabaseSessionManager.getDatabaseSession();
		session.update(member);
		return (Member)session.get(Member.class, member.getMemberId());
	}

	public void deleteMember(Member member) {
		DatabaseSessionManager.getDatabaseSession().delete(member);
	}

	public void deleteAllMembers() {
		DatabaseSessionManager.getDatabaseSession().createQuery("delete from Member").executeUpdate();
	}

	public List addMemberList(List dbmemberList) {
		int batchSize = HibernateProperties.getBatchSize();
		Session session = DatabaseSessionManager.getDatabaseSession();
		List<Member> addedMembers = new ArrayList();
		for(int i=0;i<dbmemberList.size();++i){
			String id = (String)session.save(dbmemberList.get(i));
			addedMembers.add((Member)session.get(Member.class, id));
			if(i==batchSize){
				session.flush();
		        session.clear();
			}
		}
		return addedMembers;
	}

}
