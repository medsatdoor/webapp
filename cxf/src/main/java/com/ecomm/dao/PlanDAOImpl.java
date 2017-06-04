package com.ecomm.dao;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import com.ecomm.dao.utils.DatabaseSessionManager;
import com.ecomm.dao.utils.HibernateProperties;
import com.ecomm.dbentity.Plan;


public class PlanDAOImpl implements PlanDAO {

	public List listAllPlans() {
		return DatabaseSessionManager.getDatabaseSession().createQuery("from Plan").list();
	}

	public Plan listPlanById(String planId) {
		return (Plan)DatabaseSessionManager.getDatabaseSession().get(Plan.class, planId);
	}

	public Plan addPlan(Plan plan) {
		Session session = DatabaseSessionManager.getDatabaseSession();
		String id = (String)session.save(plan);
		return (Plan)session.get(Plan.class, id);
	}

	public Plan updatePlan(Plan plan) {
		Session session = DatabaseSessionManager.getDatabaseSession();
		session.update(plan);
		return (Plan)session.get(Plan.class, plan.getPlanId());
	}

	public void deletePlan(Plan plan) {
		DatabaseSessionManager.getDatabaseSession().delete(plan);
	}

	public void deleteAllPlans() {
		DatabaseSessionManager.getDatabaseSession().createQuery("delete from Plan").executeUpdate();
	}

	public List addPlanList(List dbplanList) {
		int batchSize = HibernateProperties.getBatchSize();
		Session session = DatabaseSessionManager.getDatabaseSession();
		List<Plan> addedPlans = new ArrayList();
		for(int i=0;i<dbplanList.size();++i){
			String id = (String)session.save(dbplanList.get(i));
			addedPlans.add((Plan)session.get(Plan.class, id));
			if(i==batchSize){
				session.flush();
		        session.clear();
			}
		}
		return addedPlans;
	}

}
