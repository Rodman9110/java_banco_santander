package com.regue.spring.services;

import java.math.BigInteger;
import java.util.List;

import com.regue.spring.model.Bank_Account;



public interface Bank_AccountServices {
	
	List<Bank_Account> getBankAccounts(String user);
	Bank_Account AddBank_Account(BigInteger n_account,String user_code);
	
	

}
