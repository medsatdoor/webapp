package com.ecomm.dao;

import java.util.List;
import com.ecomm.dbentity.Plan;


public interface PlanDAO {

	List<Plan> listAllPlans();
    Plan listPlanById(String id);
	
    Plan addPlan(Plan plan);
	Plan updatePlan(Plan plan);
	void deletePlan(Plan plan);
	
	// Bulk operations
	void deleteAllPlans();
	List<Plan> addPlanList(List<Plan> dbplanList);

}
