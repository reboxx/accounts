package com.aziz.ai.accountservice.dao.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * @author Aziz ai
 *
 */
public class AccountDto {

	@JsonProperty("id")
	private int id;
	@JsonProperty("available_balance")
	private double availbaleBalance;
	@JsonProperty("current")
	private double current;
	@JsonProperty("status")
	private String status;
	@JsonProperty("type")
	private String type;
	@JsonProperty("account_no")
	private String accountNo;
	@JsonProperty("civil_id_no")
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
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
		return "id: " + this.id + ", status: " + this.status + ", available_balance: " + this.availbaleBalance
				+ ", current: " + this.current + ", type: " + this.type;
	}
}
