package com.ecomm.dbentity;

import java.util.Date;

public class Member {

	private String memberId;
	private String userId;
	private String planId;
	private Date fromDate;
	private Date toDate;
	
	public Member(){
		// Constructor for Hibernate serialization
	}
	
	public Member(String userId, String planId, Date fromDate, Date toDate){
		this.userId = userId;
		this.planId = planId;
		this.fromDate = fromDate;
		this.toDate = toDate;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPlanId() {
		return planId;
	}

	public void setPlanId(String planId) {
		this.planId = planId;
	}

	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}
}
