package com.ecomm.commonutility.property;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyUtils {

	public Properties loadPropertiesFromFile(final String propertiesFilePath) throws Exception {
		Properties fileProperties = new Properties();
		InputStream input = null;
		try {
			InputStream in = getClass().getClassLoader().getResourceAsStream(propertiesFilePath);
			fileProperties.load(in);
		}finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return fileProperties;
	}
}
