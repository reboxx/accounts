package com.aziz.ai.accountservice.exception;

/**
 * 
 * @author Aziz ai
 *
 */
public enum ErrorType {

	ACCOUNT_NO_MANDATORY("account_no is mandatory", "AS_001"), 
	MOBILE_NO_MANDATORY("mobile_no is mandatory", "AS_002"), 
	FIRST_NAME_MANDATORY("first_name is mandatory","AS_003"), 
	CIVIL_ID_MANDATORY("civil_id_no is mandatory", "AS_004"),
	CIVIL_ID_EXIST("Customer with civil_id_no exist", "AS_005"),
	CIVIL_ID_DOES_NOT_EXIST("Customer with civil_id_no does not exist", "AS_006"),
	ACCOUNT_NO_DOES_NOT_EXIST("account_no does not exist", "AS_007"),
	ACCOUNT_TYPE_MANDATORY("account_type is mandatory", "AS_008"),
	ACCOUNT_NO_EXIST("account_no exist", "AS_009"),
	ACCOUNT_STATUS_MANDATORY("account_type is mandatory", "AS_010"),
	INTERNAL_SERVER_ERROR("Customer with civil_id_no exist", "AS_011");

	private String msg;
	private String errorCode;

	private ErrorType(String msg, String errorCode) {
		this.msg = msg;
		this.errorCode = errorCode;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
}
