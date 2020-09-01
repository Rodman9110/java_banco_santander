package com.regue.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.regue.spring.model.Login;
import com.regue.spring.repository.LoginRepository;

@Service("LoginServices")
public class LoginServicesImpl implements LoginServices{
	
	@Autowired
	LoginRepository loginRepository;

	@Override
	public Login findLogin(String user_code, String password) {
		// TODO Auto-generated method stub
		return loginRepository.findLogin$(user_code, password);
	}

	@Override
	public void AddLogin(String user_code, String password, String type) {		
		loginRepository.AddLogin$(user_code, password, type);		
	}
	
	

}
