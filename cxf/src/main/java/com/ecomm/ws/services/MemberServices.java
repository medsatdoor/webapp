package com.ecomm.ws.services;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import com.ecomm.ws.servicelines.ServicePaths;
import com.ecomm.wsentity.Member;
import com.ecomm.wsentity.Members;


@Path(ServicePaths.MEMBER_SERVICE_BASE_URI)
public interface MemberServices {

	// Unit operation
	@GET
	@Path(ServicePaths.LIST_ALL_MEMBERS)
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response listAllMembers();
	
	@GET
	@Path(ServicePaths.LIST_MEMBER_BY_ID)
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response listMemberById(@PathParam("memberId") String memberId);
	
	
	@POST
	@Path(ServicePaths.ADD_MEMBER)
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Response addMember(Member member, @Context UriInfo uriInfo);
	
	@PUT
	@Path(ServicePaths.UPDATE_MEMBER)
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Response updateMember(Member member, @Context UriInfo uriInfo);
		
	@DELETE
	@Path(ServicePaths.DELETE_MEMBER)
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Response deleteMember(Member member);
	
	@DELETE
	@Path(ServicePaths.DELETE_MEMBER_BY_ID)
	public Response deleteMemberById(@PathParam("memberId") String memberId);

	
	// Bulk operations
	
	@DELETE
	@Path(ServicePaths.DELETE_ALL_MEMBERS)
	public Response deleteAllMembers();

	@POST
	@Path(ServicePaths.ADD_MEMBERS)
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Response addMembers(Members members);

}
