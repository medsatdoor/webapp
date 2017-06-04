package com.ecomm.exception;

public class EcommException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;
	
	public int errorCode;
	public Exception internalException;
	
	public EcommException(int errorCode, String message){
		super(message);
		this.errorCode = errorCode;
	}
	
	public EcommException(int errorCode, Exception internalException){
		this(errorCode, internalException.getClass()+": "+internalException.getMessage());
		this.internalException = internalException;
	}

	
}
