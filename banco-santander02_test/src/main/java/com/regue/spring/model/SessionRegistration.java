package com.regue.spring.model;

import java.util.Date;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "SessionRegistration")
public class SessionRegistration {
	
//	@Id
//	private String id;
	private String user_code;
	private String state;
	private Date data_session;
	
	
	public SessionRegistration() {
		// TODO Auto-generated constructor stub
	}


	public SessionRegistration(String user_code, String state, Date data_session) {
		
		this.user_code = user_code;
		this.state = state;
		this.data_session = data_session;
	}


	public String getUser_code() {
		return user_code;
	}


	public void setUser_code(String user_code) {
		this.user_code = user_code;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public Date getData_session() {
		return data_session;
	}


	public void setData_session(Date data_session) {
		this.data_session = data_session;
	}
	
	

}
