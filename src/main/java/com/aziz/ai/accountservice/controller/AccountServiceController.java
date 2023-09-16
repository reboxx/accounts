package com.aziz.ai.accountservice.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.aziz.ai.accountservice.common.Validator;
import com.aziz.ai.accountservice.dao.dto.AccountDto;
import com.aziz.ai.accountservice.dao.dto.CustomerDto;
import com.aziz.ai.accountservice.dao.entity.Account;
import com.aziz.ai.accountservice.dao.entity.Customer;
import com.aziz.ai.accountservice.exception.AccountServiceException;
import com.aziz.ai.accountservice.exception.ErrorType;
import com.aziz.ai.accountservice.service.AccountService;

/**
 * 
 * @author Aziz ai
 *
 */
@RestController
@RequestMapping("/account")
public class AccountServiceController {

	@Autowired
	public AccountService ser;

	static Logger log = LogManager.getRootLogger();;

	ModelMapper modelMapper;

	Map<String, Customer> cachedCustomers = new HashMap<>();

	@PostConstruct
	public void loadCustomers() {
		modelMapper = new ModelMapper();
		ser.getCustomers().forEach(a -> cachedCustomers.put(a.getCivilId(), a));
	}

	@RequestMapping(value = "/{accountNo}", method = RequestMethod.GET)
	public ResponseEntity<Account> getAccount(@PathVariable("accountNo") String accountNo)
			throws AccountServiceException {

		log.info("getting account with account number {}", accountNo);

		if (Validator.isEmpty(accountNo)) {
			throw new AccountServiceException(ErrorType.CIVIL_ID_MANDATORY);
		}

		Account account = ser.getAccountByNo(accountNo);

		if (account == null) {
			throw new AccountServiceException(ErrorType.ACCOUNT_NO_DOES_NOT_EXIST);
		}

		return ResponseEntity.status(HttpStatus.OK).body(account);

	}

	@RequestMapping(value = "", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<AccountDto> createAccount(@RequestBody AccountDto accountDto) throws AccountServiceException {

		log.info("creating account with  {}", accountDto.toString());

		Validator.validateCreateAccountReq(accountDto);

		Customer cust = cachedCustomers.get(accountDto.getCidNo());

		if (cust == null) {
			throw new AccountServiceException(ErrorType.CIVIL_ID_DOES_NOT_EXIST);
		}

		if (ser.getAccountByNo(accountDto.getAccountNo()) != null) {
			throw new AccountServiceException(ErrorType.ACCOUNT_NO_EXIST);
		}

		Account account = modelMapper.map(accountDto, Account.class);
		cust.getAccount().add(account);

		ser.createAccount(account);

		return ResponseEntity.status(HttpStatus.CREATED).body(accountDto);

	}

	@RequestMapping(value = "/customer", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<Customer> createCustomer(@RequestBody CustomerDto req) throws AccountServiceException {

		log.info("creating customer with {}", req.toString());

		if (cachedCustomers.containsKey(req.getCivilId())) {
			throw new AccountServiceException(ErrorType.CIVIL_ID_EXIST);
		}
		Validator.validateCreateCustomerReq(req);

		Customer customer = modelMapper.map(req, Customer.class);
		cachedCustomers.put(customer.getCivilId(), customer);

		ser.createCustomer(customer);

		return ResponseEntity.status(HttpStatus.CREATED).body(customer);

	}

	@RequestMapping(value = "/customer/{cidNo}", method = RequestMethod.GET)
	public ResponseEntity<Customer> getCustomers(@PathVariable("cidNo") String cidNo) throws AccountServiceException {

		log.info("getting customer with civil_id {}", cidNo);

		if (!cachedCustomers.containsKey(cidNo)) {
			throw new AccountServiceException(ErrorType.CIVIL_ID_DOES_NOT_EXIST);
		}

		return ResponseEntity.status(HttpStatus.OK).body(ser.getCustomerByCid(cidNo));

	}
}
