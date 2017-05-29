package com.ecomm.dbentity;

public class Plan {

	private String planId;
	private String planName;
	private String description;
	
	public Plan(){
		// Constructor for Hibernate Serialization
	}
	
	public Plan(String planName, String description){
		this.planName = planName;
		this.description = description;
	}

	public String getPlanId() {
		return planId;
	}

	public void setPlanId(String planId) {
		this.planId = planId;
	}

	public String getPlanName() {
		return planName;
	}

	public void setPlanName(String planName) {
		this.planName = planName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}	
}
