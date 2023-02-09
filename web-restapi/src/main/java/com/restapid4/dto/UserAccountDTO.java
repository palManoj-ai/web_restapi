package com.restapid4.dto;

public class UserAccountDTO {
	
	private long userId;
	private String userName;
	private String ssn;
	private String address;
	private String phone;
	private String email;
	private long initialBalance;
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
	
	public UserAccountDTO() {}
	public UserAccountDTO(long userId, String userName, String ssn, String address, String phone, String email,
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
