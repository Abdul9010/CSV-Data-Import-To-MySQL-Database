package com.example.demo.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class User {
	
	@Id
	@GeneratedValue
	public Long Count;
	
	public String Name;
	
	public String	Mobile;
	
	public String Account;
	
	public String	Branch;
	
	public String	Balance;
	
	public String Year;
	
	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(Long count, String name, String mobile, String account, String branch, String balance, String year) {
		super();
		Count = count;
		Name = name;
		Mobile = mobile;
		Account = account;
		Branch = branch;
		Balance = balance;
		Year = year;
	}

	public Long getCount() {
		return Count;
	}

	public void setCount(Long count) {
		Count = count;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getMobile() {
		return Mobile;
	}

	public void setMobile(String mobile) {
		Mobile = mobile;
	}

	public String getAccount() {
		return Account;
	}

	public void setAccount(String account) {
		Account = account;
	}

	public String getBranch() {
		return Branch;
	}

	public void setBranch(String branch) {
		Branch = branch;
	}

	public String getBalance() {
		return Balance;
	}

	public void setBalance(String balance) {
		Balance = balance;
	}

	public String getYear() {
		return Year;
	}

	public void setYear(String year) {
		Year = year;
	}

	

	
}
