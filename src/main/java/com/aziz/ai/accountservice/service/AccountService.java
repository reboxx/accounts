package com.aziz.ai.accountservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.aziz.ai.accountservice.dao.AccountDao;
import com.aziz.ai.accountservice.dao.entity.Account;
import com.aziz.ai.accountservice.dao.entity.Customer;

@Component
public class AccountService {

	@Autowired
	public AccountDao dao;
	
	public Account getAccountByNo(String accountNo) {
		return dao.getAccountByNo(accountNo);
	}

	public Account createAccount(Account req) {
		return dao.createAccount(req);
	}

	public Customer createCustomer(Customer customer) {
		return dao.createCustomer(customer);
	}

	public Customer getCustomerByCid(String cid) {
		return dao.getCustomerByCid(cid);
	}
	
	public List<Customer> getCustomers(){
		return dao.getCustomers();
	}

}
