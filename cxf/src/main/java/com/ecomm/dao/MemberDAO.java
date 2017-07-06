package com.ecomm.dao;

import java.util.List;
import com.ecomm.dbentity.Member;

public interface MemberDAO {

	List<Member> listAllMembers();
    Member listMemberById(String memberId);
	
    Member addMember(Member member);
	Member updateMember(Member member);
	void deleteMember(Member member);
	
	// Bulk operations
	void deleteAllMembers();
	List<Member> addMemberList(List<Member> dbmemberList);
}
