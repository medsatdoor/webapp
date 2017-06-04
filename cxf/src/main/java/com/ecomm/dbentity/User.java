package com.ecomm.dbentity;

import java.util.Date;

public class User {

	private String userId;
	private String emailAddress;
	private int mobileNumber;
	private String password;
	
	private char nameIndex;
	private String name;
	
	private String type;
	private long balance;
	private String state;
	private Date registeredDate;
	
	public User() {
		// Constructor for Hibernate serialize 
	}
	
	public User(String emailAddress, int mobileNumber, String password, String name) {
		this.emailAddress = emailAddress;
		this.mobileNumber = mobileNumber;
		this.password = password;
		this.name = name;
	}
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public int getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(int mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public char getNameIndex() {
		return nameIndex;
	}
	public void setNameIndex(char nameIndex) {
		this.nameIndex = nameIndex;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public long getBalance() {
		return balance;
	}
	public void setBalance(long balance) {
		this.balance = balance;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Date getRegisteredDate() {
		return registeredDate;
	}
	public void setRegisteredDate(Date registeredDate) {
		this.registeredDate = registeredDate;
	}
}