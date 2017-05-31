package com.ecomm.ws.services;

import java.util.List;
import javax.ws.rs.core.UriInfo;
import com.ecomm.wsentity.Member;
import javax.ws.rs.core.Response;
import com.ecomm.wsentity.Members;
import com.ecomm.ws.utils.EcommResponse;
import com.ecomm.exception.EcommException;
import com.ecomm.exception.EcommWebException;
import com.ecomm.commonutility.logger.EcommLogger;
import com.ecomm.db.services.MemberDaoServicesImpl;
import com.ecomm.ws.services.utils.beanmappers.MemberMapper;


public class MemberServicesImpl implements MemberServices {

	private MemberDaoServicesImpl memberDaoServices;
	
	public void setMemberDaoServices(MemberDaoServicesImpl memberDaoServices) {
		this.memberDaoServices = memberDaoServices;
	}
	
	public Response listAllMembers() {
		try{ 
			List<com.ecomm.dbentity.Member> dbMemberList = memberDaoServices.listAllMembers();
			EcommLogger.info("FROM DAO: "+dbMemberList);
			Members wsmembers = new Members();
			if(dbMemberList!=null && !dbMemberList.isEmpty()){
				for (com.ecomm.dbentity.Member dbmember : dbMemberList) {
					wsmembers.addMember(MemberMapper.mapDbToWs(dbmember));
				}
			}	
			return EcommResponse.getResponseOk(wsmembers);
		}catch (EcommException e) {
			e.printStackTrace();
			throw new EcommWebException(e);
		}catch(Exception e){
			e.printStackTrace();
			throw new EcommWebException(500, e);
		}
	}

	public Response listMemberById(String memberId) {
		
		return null;
	}

	public Response addMember(Member member, UriInfo uriInfo) {
		
		return null;
	}

	public Response updateMember(Member member, UriInfo uriInfo) {
		
		return null;
	}

	public Response deleteMember(Member member) {
		
		return null;
	}

	public Response deleteMemberById(String memberId) {
		
		return null;
	}

	public Response deleteAllMembers() {
		
		return null;
	}

	public Response addMembers(Members members) {
		
		return null;
	}
	
}
