package com.ecomm.ws.servicelines;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import com.ecomm.commonutility.logger.EcommLogger;
import com.ecomm.exception.EcommException;

public class ServiceProperties {

	public static final Properties serviceProperties = new Properties();

	public ServiceProperties(String propertiesFilePath) throws EcommException {
		//serviceProperties = new Properties();
		loadProperties(propertiesFilePath);
	}

	public void loadProperties(String propertiesFilePath) throws EcommException {
		InputStream input = null;	
		try {
			input = getClass().getClassLoader().getResourceAsStream(propertiesFilePath);
			serviceProperties.load(input);				
		}catch (Exception e) {
			throw new EcommException(500, e.getMessage());
		}finally {
			if(input != null) {
				try{
					input.close();
				}catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
