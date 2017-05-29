package com.ecomm.ws.servicelines;

public interface ServicePaths {

	// product service path constants
	String PRODUCT_SERVICE_BASE_URI = 	"/product-services";
	String LIST_ALL_PRODUCTS 		= 	"/products";
	String LIST_PRODUCT_BY_ID 		= 	"/products/{id}";
	String ADD_PRODUCT 				= 	"/products";
	String UPDATE_PRODUCT 			= 	"/products";
	String DELETE_PRODUCT 			= 	"/products";
	String DELETE_PRODUCT_BY_ID 	= 	"/products/{id}";
	String DELETE_ALL_PRODUCTS 		= 	"/products/all";
	String ADD_BULK 				=   "/product_bulk/add";

	// user service path constants
	String USER_SERVICE_BASE_URI 	= 	"/user-services";
	String LIST_ALL_USERS	 		= 	"/users";
	String LIST_USER_BY_ID 			= 	"/users/{userId}";
	String LIST_USER_BY_EMAIL		= 	"/users-by-mail/{email}";
	String LIST_USER_BY_MOBILE_NO	= 	"/users-by-mobile-no/{mobileNo}";
	String ADD_USER					= 	"/users";
	String UPDATE_USER				=	"/users";
	
	// user service path constants
	String PLAN_SERVICE_BASE_URI 	= 	"/plan-services";
	String LIST_ALL_PLANS	 		= 	"/plans";
	String LIST_PLAN_BY_ID 			= 	"/plans/{planId}";
	String ADD_PLAN					=	"/plans";
	String UPDATE_PLAN				=	"/plans";
	String DELETE_PLAN				=	"/plans";
	String DELETE_PLAN_BY_ID		=	"/plans/{planId}";
	String DELETE_ALL_PLANS			=	"/plans/all";
	String ADD_PLANS				=	"/plan-list";
	
}
