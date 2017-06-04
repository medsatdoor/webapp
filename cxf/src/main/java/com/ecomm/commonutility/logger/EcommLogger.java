package com.ecomm.commonutility.logger;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;


public class EcommLogger {

    private static Logger logger = Logger.getLogger(EcommLogger.class.getName());
    private static String propertiesFilePath; 
    
    /**
     * 
     * ****************************  Service restart = NOT_REQUIRED  ******************************
     *  Initialize properties file path by spring container 
     *  --> changes in xml configuration is auto-injected in to the variable propertiesFilePath <--
     *  PropertyConfigurator.configure(propertiesFilePath) 
     *  --> points the log4j.properties file path each time logging methods are callled <--
     * ******************************************************************************************** 
     *  
    * */
    public void setPropertiesFilePath(String propertiesFilePath) {
		EcommLogger.propertiesFilePath = propertiesFilePath;
	}

	private EcommLogger(){
    	// class can not be instantiated
    }
    
    public static Logger getLoggerInstance(){
    	PropertyConfigurator.configure(propertiesFilePath);
    	return logger;
    }
    
    public static void info(String message){
    	PropertyConfigurator.configure(propertiesFilePath);
    	logger.info(message);
    }

    public static void debug(String message){
    	PropertyConfigurator.configure(propertiesFilePath);
    	logger.debug(message);
    }
    
    public static void error(String message){
    	PropertyConfigurator.configure(propertiesFilePath);
    	logger.error(message);
    }
    
    public static void fatal(String message){
    	PropertyConfigurator.configure(propertiesFilePath);
        logger.fatal(message);
    }
    
    public static void warn(String message){
    	PropertyConfigurator.configure(propertiesFilePath);
        logger.warn(message);
    }
    
    public static void logExceptionStackTrace(Exception ex){
    	StringWriter stack = new StringWriter();
    	ex.printStackTrace(new PrintWriter(stack));
    	logger.error("ERROR STACK: " + stack.toString());
	}
}
