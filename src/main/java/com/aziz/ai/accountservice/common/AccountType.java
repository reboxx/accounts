package com.aziz.ai.accountservice.common;

/**
 * 
 * @author Aziz ai
 *
 */
public enum AccountType {
	
	SAVING, CURRENT, STUDENT, FIXED_DEPOSIT;
	
	public static String getValues() {
		return AccountType.values().toString();
	}
}
