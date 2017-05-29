package com.ecomm.ws.services.utils.beanmappers;

import java.util.List;

import com.ecomm.wsentity.Products;
import com.ecomm.wsentity.Users;

public class UserMapper {

	private static final String MAP_ID = "user_mapping"; 
	
	public static com.ecomm.dbentity.User mapWsToDb(com.ecomm.wsentity.User wsuser) {
		com.ecomm.dbentity.User dbuser = new com.ecomm.dbentity.User();
		DozerMapper.getBeanMapper().map(wsuser, dbuser, UserMapper.MAP_ID);
		return dbuser;
	}

	public static com.ecomm.wsentity.User mapDbToWs(com.ecomm.dbentity.User dbuser) {
		com.ecomm.wsentity.User wsuser = new com.ecomm.wsentity.User();
		DozerMapper.getBeanMapper().map(dbuser, wsuser, UserMapper.MAP_ID);
		return wsuser;
	}
	
	public static com.ecomm.wsentity.Users mapDbToWs(List<com.ecomm.dbentity.User> dbuserList) {
		Users wsusers = new Users();
		if(dbuserList!=null && !dbuserList.isEmpty()){
			for (com.ecomm.dbentity.User dbuser : dbuserList) {
				com.ecomm.wsentity.User wsuser = new com.ecomm.wsentity.User();
				DozerMapper.getBeanMapper().map(dbuser, wsuser, UserMapper.MAP_ID);
				wsusers.addUser(wsuser);
			}
		}	
		return wsusers;
	}
}
