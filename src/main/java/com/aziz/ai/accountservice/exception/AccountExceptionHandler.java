package com.aziz.ai.accountservice.exception;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 
 * @author Aziz ai
 *
 */
@ControllerAdvice
public class AccountExceptionHandler {
	
	static Logger log = LogManager.getRootLogger();;


	@ExceptionHandler({AccountServiceException.class})
	public ResponseEntity<Object> badRequestException(AccountServiceException ex){
		log.error("error", ex);
		ApiError error = new ApiError(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(), ex.getErrorCode());
		return new ResponseEntity<Object>(error, new HttpHeaders(), error.getStatus());
	}
	
	@ExceptionHandler({Exception.class})
	public ResponseEntity<Object> anyException(Exception ex){
		log.error("error", ex);
		ApiError error = new ApiError(HttpStatus.INTERNAL_SERVER_ERROR, ex.getLocalizedMessage(), ErrorType.INTERNAL_SERVER_ERROR.getErrorCode());
		return new ResponseEntity<Object>(error, new HttpHeaders(), error.getStatus());
	}
}
