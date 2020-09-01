package com.regue.spring.model;

import java.math.BigInteger;
//import java.sql.Date;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Credit_Card {
	
	@Id
	private BigInteger n_card;
	private BigInteger n_account;
	private String owner;
	private Date date_card;
	private int code;
	
	
	
	
	public Credit_Card() {
		// TODO Auto-generated constructor stub
	}




	public Credit_Card(BigInteger n_card, BigInteger n_account, String owner, Date date_card, int code) {
		this.n_card = n_card;
		this.n_account = n_account;
		this.owner = owner;
		this.date_card = date_card;
		this.code = code;
	}




	public BigInteger getN_card() {
		return n_card;
	}




	public void setN_card(BigInteger n_card) {
		this.n_card = n_card;
	}




	public BigInteger getN_account() {
		return n_account;
	}




	public void setN_account(BigInteger n_account) {
		this.n_account = n_account;
	}




	public String getOwner() {
		return owner;
	}




	public void setOwner(String owner) {
		this.owner = owner;
	}




	public Date getDate_card() {
		return date_card;
	}




	public void setDate_card(Date date_card) {
		this.date_card = date_card;
	}




	public int getCode() {
		return code;
	}




	public void setCode(int code) {
		this.code = code;
	}
	
	
	
}
