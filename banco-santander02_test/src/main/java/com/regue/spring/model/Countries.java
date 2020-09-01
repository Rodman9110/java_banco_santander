package com.regue.spring.model;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table

public class Countries {
	
	
	
	@Id
    @GeneratedValue
	private int id;
	private String name;
	private String code;
	
	public Countries() {
		// TODO Auto-generated constructor stub
	}

	public Countries(int id, String name, String code) {
		
		this.id = id;
		this.name = name;
		this.code = code;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	

}
