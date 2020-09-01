package com.regue.spring.services;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.regue.spring.model.Bank_Account;
import com.regue.spring.model.Bank_Operations;
import com.regue.spring.repository.Bank_AccountRepository;

@Service("Bank_AccountServices")
public class Bank_AccountServicesImpl implements Bank_AccountServices{
	
	@Autowired
	Bank_AccountRepository bank_AccountRepository;

	@Override
	public List<Bank_Account> getBankAccounts(String user) {
		
		return bank_AccountRepository.getBankAccounts$(user);
	}

	@Override
	public Bank_Account AddBank_Account(BigInteger n_account, String user) {
		// TODO Auto-generated method stub
		System.err.println("ERROR USER "+ n_account+" "+user);
		bank_AccountRepository.AddBank_Account$(n_account, user);
		
		return null;
	}

	

}
