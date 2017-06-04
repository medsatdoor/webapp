package com.ecomm.aspects;

import java.util.ArrayList;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import com.ecomm.commonutility.logger.EcommLogger;
import com.ecomm.commonutility.logger.LoggerConstants;
import com.ecomm.exception.EcommException;
import com.ecomm.exception.EcommWebException;
import org.aspectj.lang.annotation.Aspect;

public class GenericMethodAspect {
	
	public void retrieveMethodOnInvoke(JoinPoint joinPoint) {
		// start aspect
		EcommLogger.info(LoggerConstants.wing);
		
		// logging class and method name
		String target = LoggerConstants.ENTER_CAPTION+"METHOD: "+joinPoint.getSignature().toLongString();
		EcommLogger.info(target);
		String className = joinPoint.getTarget().toString();
		if(className.contains(".services.")){
			target = LoggerConstants.TAB_ENTER+"SERVICE CLASS: "+className;
		}else if(className.contains(".dao.")){
			target = LoggerConstants.TAB_ENTER+"DAO CLASS: "+className;
		}else{
			target = LoggerConstants.TAB_ENTER+"CLASS: "+className;
		}
		EcommLogger.info(target);
		
		// logging method parameters
		Object[] methodArguments = joinPoint.getArgs();
		if(methodArguments.length > 0){
			List<String> argList = new ArrayList<String>();
			for(Object argument : methodArguments){
				argList.add(argument.toString());
			}
			EcommLogger.info(LoggerConstants.TAB_ENTER+"METHOD ARGUMENTS - "+argList);
		}
		
		// end aspect
		EcommLogger.info(LoggerConstants.wing);
	}

	public void errorListenerOnMethodInvoke(JoinPoint joinPoint, Throwable ex) {
		// start aspect
		EcommLogger.error(LoggerConstants.wing);
		
		String target = LoggerConstants.ERROR_CAPTION+"METHOD: "+joinPoint.getSignature().toLongString();
		EcommLogger.error(target);
		target = LoggerConstants.TAB_ERROR+"CLASS: "+joinPoint.getTarget().toString()+" ";
		EcommLogger.error(target);
		
		if(ex instanceof EcommWebException){
			EcommWebException ecommWebException = (EcommWebException) ex;
			EcommLogger.error("EcommWebException error code: "+ ecommWebException.getErrorCode());
			EcommLogger.error("EcommWebException error message: "+ecommWebException.getErrorMessage());
		}else if(ex instanceof EcommException){
			EcommException ecommException = (EcommException) ex;
			EcommLogger.error("EcommException error code: "+ ecommException.errorCode);
			EcommLogger.error("EcommException error message: "+ecommException.getMessage());
			EcommLogger.error("**************************************************************");
			EcommLogger.error("Error Stack trace Details: ");
			EcommLogger.logExceptionStackTrace(ecommException);
			EcommLogger.error("**************************************************************");
		}else{
			EcommLogger.error("**************************************************************");
			EcommLogger.error("Unrecognized Exception/erro: "+ex.getMessage());
			try{
				EcommLogger.error("Error Stack trace Details: ");
				EcommLogger.logExceptionStackTrace((Exception)ex);
				EcommLogger.error("**************************************************************");
			}catch(Exception e){
				EcommLogger.error("Failed retrievinhg stack trace: "+e.getMessage());
			}
		}

		// end aspect
		EcommLogger.error(LoggerConstants.wing);
	}
	
	public void leaveMethodAfterInvoke(JoinPoint joinPoint) {
		// start aspect
		EcommLogger.info(LoggerConstants.wing);
		
		String target = LoggerConstants.LEAVE_CAPTION+"METHOD: "+joinPoint.getSignature().toLongString();
		EcommLogger.info(target);
		target = LoggerConstants.TAB_LEAVE+"CLASS: "+joinPoint.getTarget().toString()+" ";
		EcommLogger.info(target);
		
		// end aspect
		EcommLogger.info(LoggerConstants.wing);
	}

}
