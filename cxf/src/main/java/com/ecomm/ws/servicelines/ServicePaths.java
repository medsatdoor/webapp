package com.ecomm.ws.servicelines;

public interface ServicePaths {

	// System properties
	String PROTOCOL 				=	"http";
	String HOST 					=	"localhost";
	String PORT 					= 	"8280";

	// applicatiion properties
	String APPLICATION_CONTEXT  	= 	"/cxf";
	String SERVICE_BASE_URL 		= 	"/services";

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
}
