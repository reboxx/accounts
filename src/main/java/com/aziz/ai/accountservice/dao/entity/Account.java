package com.aziz.ai.accountservice.dao.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.aziz.ai.accountservice.common.AccountStatus;
import com.aziz.ai.accountservice.common.AccountType;

/**
 * 
 * @author Aziz ai
 *
 */
@Entity
@Table(name = "accounts")
public class Account implements Serializable{

	@Id
	@Column(name = "id")
	@GeneratedValue
	private int id;

	@Column(name = "available_balance")
	private double availbaleBalance;
	@Column(name = "current")
	private double current;
	@Column(name = "status")
	private AccountStatus status = AccountStatus.ACTIVE;
	@Column(name = "type")
	private AccountType type;
	@Column(name = "account_no")
	private String accountNo;
	@Column(name = "civil_id_no")
	private String cidNo;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getAvailbaleBalance() {
		return availbaleBalance;
	}

	public void setAvailbaleBalance(double availbaleBalance) {
		this.availbaleBalance = availbaleBalance;
	}

	public double getCurrent() {
		return current;
	}

	public void setCurrent(double current) {
		this.current = current;
	}

	public AccountStatus getStatus() {
		return status;
	}

	public void setStatus(AccountStatus status) {
		this.status = status;
	}

	public AccountType getType() {
		return type;
	}

	public void setType(AccountType type) {
		this.type = type;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	
	public String getCidNo() {
		return cidNo;
	}
	
	public void setCidNo(String cidNo) {
		this.cidNo = cidNo;
	}

	@Override
	public String toString() {
		return "id: " + this.id + ", status: " + this.status;
	}
}
