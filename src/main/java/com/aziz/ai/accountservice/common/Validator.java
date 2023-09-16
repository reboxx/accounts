package com.aziz.ai.accountservice.common;

import com.aziz.ai.accountservice.dao.dto.AccountDto;
import com.aziz.ai.accountservice.dao.dto.CustomerDto;
import com.aziz.ai.accountservice.exception.AccountServiceException;
import com.aziz.ai.accountservice.exception.ErrorType;

/**
 * 
 * @author Aziz ai
 *
 */
public class Validator {

	public static void validateCreateCustomerReq(CustomerDto req) throws AccountServiceException {

		if (isEmpty(req.getCivilId())) {
			throw new AccountServiceException(ErrorType.CIVIL_ID_MANDATORY);
		}

		if (isEmpty(req.getMobileNo())) {
			throw new AccountServiceException(ErrorType.MOBILE_NO_MANDATORY);
		}

		if (isEmpty(req.getFirstName())) {
			throw new AccountServiceException(ErrorType.FIRST_NAME_MANDATORY);
		}
	}

	public static void validateCreateAccountReq(AccountDto req) throws AccountServiceException {

		if (isEmpty(req.getAccountNo())) {
			throw new AccountServiceException(ErrorType.ACCOUNT_NO_MANDATORY);
		}

		if (isEmpty(req.getCidNo())) {
			throw new AccountServiceException(ErrorType.CIVIL_ID_MANDATORY);
		}

		if (isEmpty(req.getStatus())) {
			throw new AccountServiceException(ErrorType.ACCOUNT_STATUS_MANDATORY);

		}

		if (isEmpty(req.getStatus())) {
			throw new AccountServiceException(ErrorType.CIVIL_ID_MANDATORY);
		}

	}

	public static boolean isEmpty(String value) {

		if (value == null || value.trim().isEmpty()) {
			return true;
		}
		return false;
	}

}
