package com.regue.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.regue.spring.model.Login;

import com.regue.spring.services.CustomersServices;
import com.regue.spring.services.LoginServices;

@CrossOrigin(origins="http://localhost:4200",maxAge = 3600)
@RestController
@RequestMapping(path = "/session")
public class AppControllerSession {
	
	@Autowired
	@Qualifier("CustomersServices")
	CustomersServices customersServices;
	
	@Autowired
	@Qualifier("LoginServices")
	LoginServices loginServices;
	
	
	

	@PostMapping(path="/loginVerification")
	public Login loginVerification(@RequestBody Login login){
		System.err.println( "Dentro de Login Vereficatrion "+ login.getUser_code());
		String type = login.getType();
		String user_code = login.getUser_code();
		String password = login.getPassword();	
	
	
		
		if (type.equals("dni")) {
			System.err.println("dni");
			
			return loginServices.findLogin(user_code, password);
		
			
			
		}
		if (type.equals("cif")) {
			System.err.println("cif");
			
			return loginServices.findLogin(user_code, password);
			
		}
		
		
		return null;
	}
	
	@PostMapping(path="postAddLogin")
	public Login postAddLogin(@RequestBody Login login) {
		
		String type = login.getType();
		String user_code = login.getUser_code();
		String password = login.getPassword();
		
		
		System.err.println("postAddLogin:  Type: "+type+" User: "+user_code+" Password: "+password);
		loginServices.AddLogin(user_code, password, type);
		
		
		
		return null;
		
	}
	
	
	

}
