package com.ecomm.wsentity;

import java.util.List;
import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name="plans")
@XmlAccessorType(XmlAccessType.FIELD)
public class Plans {

	@XmlElement(name="plan")
	private List<Plan> planList; 
	
	public Plans(){
    	this.planList = new ArrayList<Plan>();
    }
	
	public Plans(List<Plan> productList){
    	this.planList = planList;
    }

	public List<Plan> getPlanList() {
		return planList;
	}

	public void setPlanList(List<Plan> planList) {
		this.planList = planList;
	}
	
	public void addPlan(Plan plan) {
		this.planList.add(plan);
	}
}
