package com.ecomm.interceptors;

import java.io.IOException;
import java.util.List;

import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.binding.soap.interceptor.AbstractSoapInterceptor;
import org.apache.cxf.headers.Header;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.message.Message;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;

import com.ecomm.commonutility.logger.EcommLogger;

public class HeaderInterceptor extends AbstractPhaseInterceptor {

	public HeaderInterceptor() {
		super(Phase.RECEIVE);
	}
/*
	public void handleMessage(SoapMessage message) throws Fault {
		try{
			List<Header> headerList = message.getHeaders();
			EcommLogger.info("Request Headers - Phase INVOKE: "+headerList);
		}catch(Exception e){
			e.printStackTrace();
			EcommLogger.error(e.getMessage());
		}
	}
*/

	public void handleMessage(Message message) throws Fault {
		EcommLogger.info("Interceptor invoked....");
	}
	
}
