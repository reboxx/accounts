package com.aziz.ai.accountservice.exception;

import org.springframework.http.HttpStatus;

/**
 * 
 * @author Aziz ai
 *
 */
public class ApiError {

	private HttpStatus status;
	private String errorMessage;
	private String errorCode;

	public ApiError(HttpStatus status, String message, String error) {
		super();
		this.status = status;
		this.errorMessage = message;
		this.errorCode = error;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public String getMessage() {
		return errorMessage;
	}

	public void setMessage(String message) {
		this.errorMessage = message;
	}

	public String getErrors() {
		return errorCode;
	}

	public void setErrors(String errors) {
		this.errorCode = errors;
	}

}
