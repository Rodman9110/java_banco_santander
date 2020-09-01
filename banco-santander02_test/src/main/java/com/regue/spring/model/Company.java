package com.regue.spring.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Company {
	
	@Id
    @GeneratedValue
	private int id;
	private String name;
	private String cif;
	private String email;
	private String direction;
	private int id_nationality;
	
	
	public Company() {
		// TODO Auto-generated constructor stub
	}


	public Company(int id, String name, String cif, String email, String direction, int id_nationality) {
		
		this.id = id;
		this.name = name;
		this.cif = cif;
		this.email = email;
		this.direction = direction;
		this.id_nationality = id_nationality;
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


	public String getCif() {
		return cif;
	}


	public void setCif(String cif) {
		this.cif = cif;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getDirection() {
		return direction;
	}


	public void setDirection(String direction) {
		this.direction = direction;
	}


	public int getId_nationality() {
		return id_nationality;
	}


	public void setId_nationality(int id_nationality) {
		this.id_nationality = id_nationality;
	}
	
	
	
	
	
	

}
