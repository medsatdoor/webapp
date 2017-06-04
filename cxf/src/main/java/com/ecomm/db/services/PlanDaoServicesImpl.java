package com.ecomm.db.services;

import java.util.List;
import org.springframework.transaction.annotation.Transactional;
import com.ecomm.commonutility.logger.EcommLogger;
import com.ecomm.dao.PlanDAO;
import com.ecomm.dao.ProductDAO;
import com.ecomm.dbentity.Plan;
import com.ecomm.dbentity.Product;
import com.ecomm.exception.EcommException;


public class PlanDaoServicesImpl {

	private PlanDAO planDAO;
	
	public void setPlanDAO(PlanDAO planDAO) {
		this.planDAO = planDAO;
	}
	
	@Transactional
	public List<Plan> listAllPlans() throws EcommException {
		try{
			return planDAO.listAllPlans();
		}catch(Exception e){
			throw new EcommException(500, e);
		}
	}

	@Transactional
	public Plan listPlanById(String planId) throws EcommException {
		try{
			Plan plan =  planDAO.listPlanById(planId);
			if(plan == null){
				throw new EcommException(404, "No Plan found with id: "+planId);
			}
			return plan;
		}catch(EcommException e){
			throw e;
		}catch(Exception e){
			throw new EcommException(500, e);
		}
	}

	@Transactional
	public Plan addPlan(Plan plan) throws EcommException {
		try{
			return planDAO.addPlan(plan);
		}catch(Exception e){
			throw new EcommException(500, e);
		}
	}

	@Transactional
	public Plan updatePlan(Plan plan) throws EcommException {
		try{
			return planDAO.updatePlan(plan);
		}catch(Exception e){
			throw new EcommException(500, e);
		}
	}

	@Transactional
	public void deletePlan(Plan plan) throws EcommException {
		try{
			planDAO.deletePlan(plan);
		}catch(Exception e){
			throw new EcommException(500, e);
		}	
	}

	@Transactional
	public void deletePlanById(String planId) throws EcommException {
		try{
			Plan plan = planDAO.listPlanById(planId);
			planDAO.deletePlan(plan);
		}catch(Exception e){
			throw new EcommException(500, e);
		}
	}

	@Transactional
	public void deleteAllPlans() throws EcommException {
		try{
			planDAO.deleteAllPlans();
		}catch(Exception e){
			throw new EcommException(500, e);
		}
	}

	@Transactional
	public void addPlanList(List<Plan> dbplanList) throws EcommException {
		try{
			List<Plan> list = planDAO.addPlanList(dbplanList);
			EcommLogger.info(list.toString());
		}catch(Exception e){
			throw new EcommException(500, e);
		}
	}
}
