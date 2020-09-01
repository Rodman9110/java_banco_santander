package com.regue.spring.model;

import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table
public class Bank_Operations {
	
	@Id
    @GeneratedValue
	private int id;
	private BigInteger n_account;
	private String concept;
	private String type;
	private Double quantity;
	private Double balance;
	private Date date_operation;
	
	
	public Bank_Operations() {
		// TODO Auto-generated constructor stub
	}


	public Bank_Operations(int id, BigInteger n_account, String concept, String type, Double quantity, Double balance,
			Date date_operation) {
		
		this.id = id;
		this.n_account = n_account;
		this.concept = concept;
		this.type = type;
		this.quantity = quantity;
		this.balance = balance;
		this.date_operation = date_operation;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public BigInteger getN_account() {
		return n_account;
	}


	public void setN_account(BigInteger n_account) {
		this.n_account = n_account;
	}


	public String getConcept() {
		return concept;
	}


	public void setConcept(String concept) {
		this.concept = concept;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public Double getQuantity() {
		return quantity;
	}


	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}


	public Double getBalance() {
		return balance;
	}


	public void setBalance(Double balance) {
		this.balance = balance;
	}


	public Date getDate_operation() {
		return date_operation;
	}


	public void setDate_operation(Date date_operation) {
		this.date_operation = date_operation;
	}
	
	
	
}
