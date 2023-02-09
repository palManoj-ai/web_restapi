package com.restapid4.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_accountDetails")
public class AccountModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator="seq1")
	@SequenceGenerator(name="seq1", initialValue = 1500,allocationSize = 50)
	private long userId;
	@Column(name="username",nullable = false)
	private String userName;
	@Column(name="ssn",nullable = false)
	private String ssn;
	@Column(name="address",nullable = false)
	private String address;
	@Column(name="phone",nullable = false)
	private String phone;
	@Column(name="email",nullable = false)
	private String email;
	@Column(name="initialBalance",nullable = false)
	private long initialBalance;
	@Column(name="accountType",nullable = false)
	private String accountType;
	
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getInitialBalance() {
		return initialBalance;
	}
	public void setInitialBalance(long initialBalance) {
		this.initialBalance = initialBalance;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	
	
	
	
	@Override
	public String toString() {
		return "AccountModel [userId=" + userId + ", userName=" + userName + ", ssn=" + ssn + ", address=" + address
				+ ", phone=" + phone + ", email=" + email + ", initialBalance=" + initialBalance + ", accountType="
				+ accountType + "]";
	}
	public AccountModel() {}
	public AccountModel(long userId, String userName, String ssn, String address, String phone, String email,
			long initialBalance, String accountType) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.ssn = ssn;
		this.address = address;
		this.phone = phone;
		this.email = email;
		this.initialBalance = initialBalance;
		this.accountType = accountType;
	}

	
	
}
