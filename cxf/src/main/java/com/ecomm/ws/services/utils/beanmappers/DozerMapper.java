package com.ecomm.ws.services.utils.beanmappers;

import java.util.ArrayList;
import java.util.List;
import org.dozer.Mapper;
import org.dozer.DozerBeanMapper;

public class DozerMapper {

	private static Mapper beanMapper;
	
	private DozerMapper(final String dozerMappingFilePath) {
		List<String> list = new ArrayList();
		list.add(dozerMappingFilePath);
		this.beanMapper = new DozerBeanMapper(list);
	}
	
	public static Mapper getBeanMapper(){
		return beanMapper;
	}
}
