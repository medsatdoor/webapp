package com.ecomm.ws.services.utils.beanmappers;

import java.util.List;
import com.ecomm.wsentity.Plans;

public class PlanMapper {

	private static final String MAP_ID = "plan_mapping"; 
	
	public static com.ecomm.dbentity.Plan mapWsToDb(com.ecomm.wsentity.Plan wsplan) {
		com.ecomm.dbentity.Plan dbplan = new com.ecomm.dbentity.Plan();
		DozerMapper.getBeanMapper().map(wsplan, dbplan, PlanMapper.MAP_ID);
		return dbplan;
	}

	public static com.ecomm.wsentity.Plan mapDbToWs(com.ecomm.dbentity.Plan dbplan) {
		com.ecomm.wsentity.Plan wsplan = new com.ecomm.wsentity.Plan();
		DozerMapper.getBeanMapper().map(dbplan, wsplan, PlanMapper.MAP_ID);
		return wsplan;
	}

	public static com.ecomm.wsentity.Plans mapDbToWs(List<com.ecomm.dbentity.Plan> dbplanList) {
		Plans wsplans = new Plans();
		if(dbplanList!=null && !dbplanList.isEmpty()){
			for (com.ecomm.dbentity.Plan dbplan : dbplanList) {
				com.ecomm.wsentity.Plan wsplan = new com.ecomm.wsentity.Plan();
				DozerMapper.getBeanMapper().map(dbplan, wsplan, PlanMapper.MAP_ID);
				wsplans.addPlan(wsplan);
			}
		}	
		return wsplans;
	}
	
}
