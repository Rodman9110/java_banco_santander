package com.regue.spring.model;


import javax.persistence.*;

//import org.hibernate.validator.constraints.Currency;

@Entity
//@Table(name = "customers")
@Table

public class Customers {
	
	@Id
    @GeneratedValue
	private int id;
	
	@Column
	private String dni;
	
	@Column
    private String first_name;

    @Column
    private String last_name;
    
    @Column
    private String email;

    @Column
    private int id_nationality;
    
    @Column
    private String direction;
	
	
	public Customers() {
		// TODO Auto-generated constructor stub
	}


	public Customers(int id, String dni, String first_name, String last_name, String email, int id_nationality,
			String direction) {
	
		this.id = id;
		this.dni = dni;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.id_nationality = id_nationality;
		this.direction = direction;
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


	public String getFirst_name() {
		return first_name;
	}


	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}


	public String getLast_name() {
		return last_name;
	}


	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public int getId_nationality() {
		return id_nationality;
	}


	public void setId_nationality(int id_nationality) {
		this.id_nationality = id_nationality;
	}


	public String getDirection() {
		return direction;
	}


	public void setDirection(String direction) {
		this.direction = direction;
	}

	
	
	

}
