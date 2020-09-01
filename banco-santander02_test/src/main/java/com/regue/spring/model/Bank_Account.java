package com.regue.spring.model;

import java.math.BigInteger;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Bank_Account {
	
	@Id
	private BigInteger  n_account;
	private String user_code;
	
	
	
	public Bank_Account() {
		
	}



	public Bank_Account(BigInteger n_account, String user_code) {
	
		this.n_account = n_account;
		this.user_code = user_code;
	}



	public BigInteger getN_account() {
		return n_account;
	}



	public void setN_account(BigInteger n_account) {
		this.n_account = n_account;
	}



	public String getUser_code() {
		return user_code;
	}



	public void setUser_code(String user_code) {
		this.user_code = user_code;
	}
	
	

}
