package com.ecomm.dao.utils;

import java.util.Properties;

import com.ecomm.commonutility.property.PropertyUtils;

public class HibernateProperties {

	private static Properties hibernateProperties;

	private HibernateProperties(String propertiesFilePath) throws Exception {
		hibernateProperties = new PropertyUtils().loadPropertiesFromFile(propertiesFilePath);
	}

	public static int getBatchSize() {
		return Integer.parseInt(hibernateProperties.getProperty("hibernate.jdbc.batch_size"));
	}

}
