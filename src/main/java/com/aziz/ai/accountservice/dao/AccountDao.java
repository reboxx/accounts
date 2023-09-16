package com.aziz.ai.accountservice.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.aziz.ai.accountservice.dao.entity.Account;
import com.aziz.ai.accountservice.dao.entity.Customer;

/**
 * 
 * @author Aziz ai
 *
 */
@Repository
public class AccountDao{

	@Autowired
	private EntityManager entityManager;

	/*
	 * create account
	 */
	@Transactional
	public Account createAccount(Account account) {
		return entityManager.merge(account);
	}

	/*
	 * create customer
	 */
	@Transactional
	public Customer createCustomer(Customer customer) {
		return entityManager.merge(customer);
	}

	/*
	 * get account by account number
	 */
	public Account getAccountByNo(String accountNo) {
		
		List<Account> res = entityManager.createQuery("SELECT a FROM Account a where a.accountNo = " + accountNo, Account.class).getResultList(); 
		
		if(res == null || res.isEmpty()) {
			return null;
		}
		return res.get(0);
	}

	/*
	 * get customer by civil id
	 */
	public Customer getCustomerByCid(String cidNo) {
		return entityManager.createQuery("SELECT c FROM Customer c where c.cidNo = " + cidNo, Customer.class)
				.getSingleResult();

	}

	/*
	 * get all customer
	 */
	public List<Customer> getCustomers() {
		List<Customer> res = entityManager.createQuery("SELECT c FROM Customer c", Customer.class)
				.getResultList();
		if (res == null) {
			return new ArrayList<Customer>();
		}
		return res;
	}

}
