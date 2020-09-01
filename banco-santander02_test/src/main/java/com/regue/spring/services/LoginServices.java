package com.regue.spring.services;

import com.regue.spring.model.Login;
;

public interface LoginServices {
	
	Login findLogin(String user_code, String password);
	void AddLogin(String user_code,String password,String type);

}
