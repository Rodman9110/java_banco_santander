package com.regue.spring.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Books {
	
	@Id
    @GeneratedValue
	private int id;
	private String title;
	private String primary_author;
	
	public Books() {
		// TODO Auto-generated constructor stub
	}

	public Books(int id, String title, String primary_author) {
	
		this.id = id;
		this.title = title;
		this.primary_author = primary_author;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPrimary_author() {
		return primary_author;
	}

	public void setPrimary_author(String primary_author) {
		this.primary_author = primary_author;
	}

	
	
	

}
