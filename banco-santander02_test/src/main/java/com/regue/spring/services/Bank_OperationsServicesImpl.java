package com.regue.spring.services;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.regue.spring.model.Bank_Operations;
import com.regue.spring.repository.Bank_OperationsRepository;

@Service("Bank_OperationsServices")
public class Bank_OperationsServicesImpl implements Bank_OperationsServices{
	
	@Autowired
	Bank_OperationsRepository bank_OperationsRepository;

	@Override
	public void AddBank_Operation(BigInteger n_account, String concept, String type, double quantity, double balance,
			Date date_operation) {
		
		bank_OperationsRepository.AddBank_Operation$(n_account, concept, type, quantity, balance, date_operation);
		
	}

	@Override
	public List<Bank_Operations> getAllBankOperationUser(BigInteger n_account) {
		// TODO Auto-generated method stub
		return bank_OperationsRepository.getAllBankOperationUser$(n_account);
	}

	@Override
	public double getLastBalance(BigInteger n_account) {
		
		return bank_OperationsRepository.getLastBalance$(n_account);
	}

	@Override
	public double getTotalBalance(String user_code) {
		// TODO Auto-generated method stub
		return bank_OperationsRepository.getTotalBalance$(user_code);
	}

	@Override
	public List<Bank_Operations> getAccountBalance(String user_code) {
		// TODO Auto-generated method stub
		return bank_OperationsRepository.getAccountBalance$(user_code);
	}

	@Override
	public List<Bank_Operations> getAllBankOperationsUser (String user_code) {
		// TODO Auto-generated method stub
		return bank_OperationsRepository.getAllBankOperationsUser$(user_code);
	}

}
