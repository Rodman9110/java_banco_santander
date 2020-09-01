package com.regue.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.regue.spring.model.Bank_Account;
import com.regue.spring.services.Bank_AccountServices;



@CrossOrigin(origins="http://localhost:4200",maxAge = 3600)
@RestController
@RequestMapping(path = "/bank_account")
public class AppControllerBankAccount {
	
	
	@Autowired
	@Qualifier("Bank_AccountServices")
	Bank_AccountServices bank_AccountServices;
	
	
	@GetMapping(path= {"getBankAccounts/{dni}"})
	public List<Bank_Account> getBankAccounts (@PathVariable("dni") String user){
		System.err.println("getBankAccounts");
//		return customersServices.listar();
		return bank_AccountServices.getBankAccounts(user);
	}

}
