package com.ecomm.ws.services;

import java.util.ArrayList;
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
import com.ecomm.ws.services.utils.beanmappers.PlanMapper;


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
		if(memberId == null || memberId.isEmpty()) {
			throw new EcommWebException(404, "Member id = null");
		}
		try {
			com.ecomm.dbentity.Member dbmember = memberDaoServices.listMemberById(memberId);
			if (dbmember == null) {
				throw new EcommWebException(404, "Member id: "+memberId+" was not found");
			}
			com.ecomm.wsentity.Member wsmember = MemberMapper.mapDbToWs(dbmember);
			return EcommResponse.getResponseOk(wsmember);
		}catch (EcommException e) {
			e.printStackTrace();
			throw new EcommWebException(e);
		}catch(Exception e){
			e.printStackTrace();
			throw new EcommWebException(500, e);
		}

	}

	public Response addMember(Member wsmember, UriInfo uriInfo) {
		if(wsmember.getPlanId() != null){
			throw new EcommWebException(400, "INVALID Member ID: is system generated should be null");
		}
		try{
			com.ecomm.dbentity.Member dbmember = memberDaoServices.addMember(MemberMapper.mapWsToDb(wsmember));
			com.ecomm.wsentity.Member wsCreatedMember = MemberMapper.mapDbToWs(dbmember);
			return EcommResponse.getResponseCreated(wsCreatedMember, uriInfo);
		}catch (EcommException e) {
			e.printStackTrace();
			throw new EcommWebException(e);
		}catch(Exception e){
			e.printStackTrace();
			throw new EcommWebException(500, e);
		}
	}

	public Response updateMember(Member wsmember, UriInfo uriInfo) {
		if (wsmember.getPlanId() == null) {
			throw new EcommWebException(400, "INVALID MEMBER ID = null");
		}
		try{
			com.ecomm.dbentity.Member dbmember = memberDaoServices.updateMember(MemberMapper.mapWsToDb(wsmember));
			return EcommResponse.getResponseUpdated(MemberMapper.mapDbToWs(dbmember), uriInfo);
		}catch (EcommException e) {
			e.printStackTrace();
			throw new EcommWebException(e);
		}catch(Exception e){
			e.printStackTrace();
			throw new EcommWebException(500, e);
		}
	}
	
	public Response deleteMember(Member wsmember) {
		if (wsmember.getPlanId() == null) {
			throw new EcommWebException(400, "INVALID MEMBER ID = null");
		}
		try{	
			memberDaoServices.deleteMember(MemberMapper.mapWsToDb(wsmember));
			return EcommResponse.getResponseNoContent();
		}catch (EcommException e) {
			e.printStackTrace();
			throw new EcommWebException(e);
		}catch(Exception e){
			e.printStackTrace();
			throw new EcommWebException(500, e);
		}
	}

	public Response deleteMemberById(String memberId) {
		if (memberId == null || memberId.isEmpty()) {
			throw new EcommWebException(400, "INVALID MEMBER ID = null");
		}
		try{
			memberDaoServices.deleteMemberById(memberId);
			return EcommResponse.getResponseNoContent();
		}catch (EcommException e) {
			e.printStackTrace();
			throw new EcommWebException(e);
		}catch(Exception e){
			e.printStackTrace();
			throw new EcommWebException(500, e);
		}
	}

	public Response deleteAllMembers() {
		try{
			memberDaoServices.deleteAllMembers();
			return EcommResponse.getResponseNoContent();
		}catch (EcommException e) {
			e.printStackTrace();
			throw new EcommWebException(e);
		}catch(Exception e){
			e.printStackTrace();
			throw new EcommWebException(500, e);
		}
	}

	public Response addMembers(Members wsmembers) {
		try{
			List<com.ecomm.wsentity.Member> wsmemberList = wsmembers.getMemberList();
			List<com.ecomm.dbentity.Member> dbmemberList = new ArrayList();
			for(com.ecomm.wsentity.Member wsmember : wsmemberList){
				dbmemberList.add(MemberMapper.mapWsToDb(wsmember));
			}
			memberDaoServices.addMemberList(dbmemberList);
			return EcommResponse.getResponseOk();
		}catch (EcommException e) {
			e.printStackTrace();
			throw new EcommWebException(e);
		}catch(Exception e){
			e.printStackTrace();
			throw new EcommWebException(500, e);
		}
	}
	
}
