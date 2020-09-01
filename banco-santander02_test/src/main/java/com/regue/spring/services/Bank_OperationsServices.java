package com.regue.spring.services;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;

import com.regue.spring.model.Bank_Operations;

public interface Bank_OperationsServices {
	
	void AddBank_Operation( BigInteger n_account,String concept,String type,double quantity,double balance,Date date_operation);
	List<Bank_Operations>getAllBankOperationUser(BigInteger n_account);
	double getLastBalance (BigInteger n_account);
	double getTotalBalance(String user_code);
	List<Bank_Operations> getAccountBalance(String user_code);
	List<Bank_Operations> getAllBankOperationsUser(String user_code);

}
