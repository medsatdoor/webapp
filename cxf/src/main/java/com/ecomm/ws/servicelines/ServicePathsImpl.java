package com.ecomm.ws.servicelines;

public final class ServicePathsImpl implements ServicePaths {

	// System properties
	public static String PROTOCOL;
	public static String HOST;
	public static String PORT;

	// applicatiion properties
	public static String APPLICATION_CONTEXT;
	public static String SERVICE_BASE_URL;

	public ServicePathsImpl() {
		// This is only a dummy implementation for jsp:usebean
	}

	public void setPROTOCOL(String pROTOCOL) {
		ServicePathsImpl.PROTOCOL = pROTOCOL;
	}

	public void setHOST(String hOST) {
		ServicePathsImpl.HOST = hOST;
	}

	public void setPORT(String pORT) {
		ServicePathsImpl.PORT = pORT;
	}

	public void setAPPLICATION_CONTEXT(String aPPLICATION_CONTEXT) {
		ServicePathsImpl.APPLICATION_CONTEXT = aPPLICATION_CONTEXT;
	}

	public void setSERVICE_BASE_URL(String sERVICE_BASE_URL) {
		ServicePathsImpl.SERVICE_BASE_URL = sERVICE_BASE_URL;
	}

	
}
