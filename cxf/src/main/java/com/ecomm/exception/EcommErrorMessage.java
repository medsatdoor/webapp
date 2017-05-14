package com.ecomm.exception;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class EcommErrorMessage {

	private int errorCode;
	private String errorMessage;
	private String internalErrorMessage;
	
	public EcommErrorMessage() {
		// No argument constructor for erialization & deserialization;
	}

	public EcommErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public EcommErrorMessage(int errorCode, String errorMessage) {
		this(errorMessage);
		this.errorCode = errorCode;
	}
	
	public EcommErrorMessage(int errorCode, String errorMessage, String internalErrorMessage) {
		this(errorCode, errorMessage);
		this.internalErrorMessage = internalErrorMessage;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public String getInternalErrorMessage() {
		return internalErrorMessage;
	}

	public void setInternalErrorMessage(String internalErrorMessage) {
		this.internalErrorMessage = internalErrorMessage;
	}
}