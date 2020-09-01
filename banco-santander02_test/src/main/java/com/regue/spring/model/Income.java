package com.regue.spring.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table
public class Income {
	
	@Id
    @GeneratedValue
	private int id;
	private String dni;
	private String concept;
	private int quantity;
	private int balance;
	private Date date_income;
	
	public Income() {
		// TODO Auto-generated constructor stub
	}

	public Income(int id, String dni, String concept, int quantity, int balance, Date date_income) {
		
		this.id = id;
		this.dni = dni;
		this.concept = concept;
		this.quantity = quantity;
		this.balance = balance;
		this.date_income = date_income;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getConcept() {
		return concept;
	}

	public void setConcept(String concept) {
		this.concept = concept;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public Date getDate_income() {
		return date_income;
	}

	public void setDate_income(Date date_income) {
		this.date_income = date_income;
	}
	
	
	
	
	
	
	
}
