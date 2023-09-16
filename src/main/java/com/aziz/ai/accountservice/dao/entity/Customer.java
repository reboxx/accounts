package com.aziz.ai.accountservice.dao.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * 
 * @author Aziz ai
 *
 */
@Entity
@Table(name="customers")
public class Customer implements Serializable{
	
	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	@Column(name="mobile_no")
	private String mobileNo;
	@Column(name="civil_id_no")
	private String cidNo;
	@Column(name="first_name")
	private String firstName;
	@Column(name="middle_name")
	private String middleName;
	@Column(name="last_name")
	private String lastName;
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name = "civil_id_no", referencedColumnName = "civil_id_no")
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
		if(account==null) {
			account = new ArrayList<Account>();
		}
		return account;
	}
	
	public void setAccount(List<Account> account) {
		this.account = account;
	}
}
