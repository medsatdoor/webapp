package com.ecomm.ws.services.utils.beanmappers;

import java.util.List;

import com.ecomm.wsentity.Members;
import com.ecomm.wsentity.Plans;

public class MemberMapper {

	private static final String MAP_ID = "member_mapping"; 
	
	public static com.ecomm.dbentity.Member mapWsToDb(com.ecomm.wsentity.Member wsmember) {
		com.ecomm.dbentity.Member dbmember = new com.ecomm.dbentity.Member();
		DozerMapper.getBeanMapper().map(wsmember, dbmember, MemberMapper.MAP_ID);
		return dbmember;
	}

	public static com.ecomm.wsentity.Member mapDbToWs(com.ecomm.dbentity.Member dbmember) {
		com.ecomm.wsentity.Member wsmember = new com.ecomm.wsentity.Member();
		DozerMapper.getBeanMapper().map(dbmember, wsmember, MemberMapper.MAP_ID);
		return wsmember;
	}

	public static com.ecomm.wsentity.Members mapDbToWs(List<com.ecomm.dbentity.Member> dbmemberList) {
		Members wsmembers = new Members();
		if(dbmemberList!=null && !dbmemberList.isEmpty()){
			for (com.ecomm.dbentity.Member dbmember : dbmemberList) {
				com.ecomm.wsentity.Member wsmember = new com.ecomm.wsentity.Member();
				DozerMapper.getBeanMapper().map(dbmember, wsmember, MemberMapper.MAP_ID);
				wsmembers.addPlan(wsmember);
			}
		}	
		return wsmembers;
	}
	
}
