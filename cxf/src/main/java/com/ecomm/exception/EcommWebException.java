package com.ecomm.exception;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

public class EcommWebException extends WebApplicationException {

	private static final long serialVersionUID = 111L;
	private int errorCode;
	private String errorMessage;
	private Exception applicationException;

	/**
	 * User to throw exception with error code and message on validation or if
	 * other Runtime exceptions handled in catch block
	 */
	public EcommWebException(final int errorCode, final String errorMessage) {
		super(Response.status(errorCode)
				.entity(new EcommErrorMessage(errorCode, errorMessage)).build());
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}

	/**
	 * Raised exceptions of internal layers
	 */
	public EcommWebException(final EcommException ecommException) {
		super(Response
				.status(ecommException.errorCode)
				.entity(new EcommErrorMessage(ecommException.errorCode,
						ecommException.getMessage())).build());
		this.errorCode = ecommException.errorCode;
		this.errorMessage = ecommException.getMessage();
		this.applicationException = ecommException;
	}

	public EcommWebException(final int errorCode, final Exception applicationException) {
		super(Response.status(errorCode)
			.entity(new EcommErrorMessage(errorCode,
				applicationException.getCause()+": "+ applicationException.getMessage()))
					.build());
		this.errorCode = errorCode;
		this.errorMessage = applicationException.getCause()+": "+applicationException.getMessage();
		this.applicationException = applicationException;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}
	
	public Exception getApplicationException(){
		return applicationException;
	}

}
