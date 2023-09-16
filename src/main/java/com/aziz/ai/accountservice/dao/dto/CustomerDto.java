package com.aziz.ai.accountservice.dao.dto;

import java.util.List;

import com.aziz.ai.accountservice.dao.entity.Account;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * @author Aziz ai
 *
 */
public class CustomerDto {

	@JsonProperty("id")
	private int id;
	@JsonProperty("mobile_no")
	private String mobileNo;
	@JsonProperty("civil_id_no")
	private String cidNo;
	@JsonProperty("first_name")
	private String firstName;
	@JsonProperty("middle_name")
	private String middleName;
	@JsonProperty("last_name")
	private String lastName;
	@JsonProperty("account")
	private List<Account> account;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getCivilId() {
		return cidNo;
	}

	public void setCivilId(String civilId) {
		this.cidNo = civilId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public List<Account> getAccount() {
		return account;
	}

	public void setAccount(List<Account> account) {
		this.account = account;
	}

	@Override
	public String toString() {
		return "civil_id_no: " + this.cidNo + ", first_name: " + this.firstName + ", middle_name: " + this.middleName
				+ ", last_name: " + this.lastName + ", mobile_no: " + this.mobileNo;
	}
}
