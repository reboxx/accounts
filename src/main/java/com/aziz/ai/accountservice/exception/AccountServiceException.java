package com.aziz.ai.accountservice.exception;

/**
 * 
 * @author Aziz ai
 *
 */
public class AccountServiceException extends Exception{

    private String errorCode;
	
	public AccountServiceException(ErrorType errorCode) {
		super(errorCode.getMsg());
		this.errorCode = errorCode.getErrorCode();
	}
	
	public String getErrorCode() {
		return errorCode;
	}
	
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
}
