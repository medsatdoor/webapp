package com.ecomm.ws.services;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import com.ecomm.commonutility.logger.EcommLogger;
import com.ecomm.db.services.PlanDaoServicesImpl;
import com.ecomm.exception.EcommException;
import com.ecomm.exception.EcommWebException;
import com.ecomm.ws.services.utils.beanmappers.PlanMapper;
import com.ecomm.ws.services.utils.beanmappers.ProductMapper;
import com.ecomm.ws.utils.EcommResponse;
import com.ecomm.wsentity.Plan;
import com.ecomm.wsentity.Plans;
import com.ecomm.wsentity.Products;


public class PlanServicesImpl implements PlanServices {

	private PlanDaoServicesImpl planDaoServices;
	
	public void setPlanDaoServices(PlanDaoServicesImpl planDaoServices) {
		this.planDaoServices = planDaoServices;
	}
	
	public Response listAllPlans() {
		try{ 
			List<com.ecomm.dbentity.Plan> dbplanList = planDaoServices.listAllPlans();
			EcommLogger.info("FROM DAO: "+dbplanList);
			Plans wsplans = new Plans();
			if(dbplanList!=null && !dbplanList.isEmpty()){
				for (com.ecomm.dbentity.Plan dbplan : dbplanList) {
					wsplans.addPlan(PlanMapper.mapDbToWs(dbplan));
				}
			}	
			return EcommResponse.getResponseOk(wsplans);
		}catch (EcommException e) {
			e.printStackTrace();
			throw new EcommWebException(e);
		}catch(Exception e){
			e.printStackTrace();
			throw new EcommWebException(500, e);
		}
	}

	public Response listPlanById(String planId) {
		if(planId == null || planId.isEmpty()) {
			throw new EcommWebException(404, "Plan id = null");
		}
		try {
			com.ecomm.dbentity.Plan dbplan = planDaoServices.listPlanById(planId);
			if (dbplan == null) {
				throw new EcommWebException(404, "Plan id: "+planId+" was not found");
			}
			com.ecomm.wsentity.Plan wsplan = PlanMapper.mapDbToWs(dbplan);
			return EcommResponse.getResponseOk(wsplan);
		}catch (EcommException e) {
			e.printStackTrace();
			throw new EcommWebException(e);
		}catch(Exception e){
			e.printStackTrace();
			throw new EcommWebException(500, e);
		}
	}

	public Response addPlan(Plan wsplan, UriInfo uriInfo) {
		if(wsplan.getPlanId() != null){
			throw new EcommWebException(400, "INVALID PLAN ID: is system generated should be null");
		}
		try{
			com.ecomm.dbentity.Plan dbplan = planDaoServices.addPlan(PlanMapper.mapWsToDb(wsplan));
			com.ecomm.wsentity.Plan wsCreatedPlan = PlanMapper.mapDbToWs(dbplan);
			return EcommResponse.getResponseCreated(wsCreatedPlan, uriInfo);
		}catch (EcommException e) {
			e.printStackTrace();
			throw new EcommWebException(e);
		}catch(Exception e){
			e.printStackTrace();
			throw new EcommWebException(500, e);
		}
	}

	public Response updatePlan(Plan wsplan, UriInfo uriInfo) {
		if (wsplan.getPlanId() == null) {
			throw new EcommWebException(400, "INVALID PLAN ID = null");
		}
		try{
			com.ecomm.dbentity.Plan dbplan = planDaoServices.updatePlan(PlanMapper.mapWsToDb(wsplan));
			return EcommResponse.getResponseUpdated(PlanMapper.mapDbToWs(dbplan), uriInfo);
		}catch (EcommException e) {
			e.printStackTrace();
			throw new EcommWebException(e);
		}catch(Exception e){
			e.printStackTrace();
			throw new EcommWebException(500, e);
		}

	}

	public Response deletePlan(Plan wsplan) {
		if (wsplan.getPlanId() == null) {
			throw new EcommWebException(400, "INVALID PLAN ID = null");
		}
		try{	
			planDaoServices.deletePlan(PlanMapper.mapWsToDb(wsplan));
			return EcommResponse.getResponseNoContent();
		}catch (EcommException e) {
			e.printStackTrace();
			throw new EcommWebException(e);
		}catch(Exception e){
			e.printStackTrace();
			throw new EcommWebException(500, e);
		}
	}

	public Response deletePlanById(String planId) {
		if (planId == null || planId.isEmpty()) {
			throw new EcommWebException(400, "INVALID PLAN ID = null");
		}
		try{
			planDaoServices.deletePlanById(planId);
			return EcommResponse.getResponseNoContent();
		}catch (EcommException e) {
			e.printStackTrace();
			throw new EcommWebException(e);
		}catch(Exception e){
			e.printStackTrace();
			throw new EcommWebException(500, e);
		}
	}

	public Response deleteAllPlans() {
		try{
			planDaoServices.deleteAllPlans();
			return EcommResponse.getResponseNoContent();
		}catch (EcommException e) {
			e.printStackTrace();
			throw new EcommWebException(e);
		}catch(Exception e){
			e.printStackTrace();
			throw new EcommWebException(500, e);
		}
	}

	public Response addPlans(Plans wsplans) {
		try{
			List<com.ecomm.wsentity.Plan> wsplanList = wsplans.getPlanList();
			List<com.ecomm.dbentity.Plan> dbplanList = new ArrayList();
			for(com.ecomm.wsentity.Plan wsplan : wsplanList){
				dbplanList.add(PlanMapper.mapWsToDb(wsplan));
			}
			planDaoServices.addPlanList(dbplanList);
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
