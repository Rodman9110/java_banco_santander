package com.regue.spring.controllers;

import static org.hamcrest.CoreMatchers.nullValue;

import java.math.BigInteger;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.regue.spring.model.Bank_Operations;
import com.regue.spring.model.Countries;
import com.regue.spring.model.Customers;
import com.regue.spring.services.Bank_AccountServices;
import com.regue.spring.services.Bank_OperationsServices;


@CrossOrigin(origins="http://localhost:4200",maxAge = 3600)
@RestController
@RequestMapping(path = "/bank_operations")
public class AppControllerBankOperations {
	
	@Autowired
	@Qualifier("Bank_OperationsServices")
	Bank_OperationsServices bank_OperationsServices;
	
	
	private static final DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	
	
	
	
	
	
	@GetMapping(path= {"getTotalBalance/{user_code}"})
	public double getTotalBalance(@PathVariable("user_code") String user_code){
		System.err.println("getTotalBalance");
//		return customersServices.listar();
		double balanceTotal = bank_OperationsServices.getTotalBalance(user_code);
		System.err.println(balanceTotal);
		return bank_OperationsServices.getTotalBalance(user_code);
	}
	
	@GetMapping(path= {"getAccountBalance/{user_code}"})
	public List<Bank_Operations> getAccountBalance(@PathVariable("user_code") String user_code){
		System.err.println("getAccountBalance");
//		return customersServices.listar();
		
		return bank_OperationsServices.getAccountBalance(user_code);
	}
	
	@GetMapping(path= {"getAllBankOperationsUser/{user_code}"})
	public List<Bank_Operations> getAllBankOperationsUser(@PathVariable("user_code") String user_code){
		System.err.println("getAllBankOperationsUser");
//		return customersServices.listar();
		
		return bank_OperationsServices.getAllBankOperationsUser(user_code);
	}
	
	
	
	
	
	
	@GetMapping(path= {"getLastBalance/{n_account}"})
	public double getLastBalance (@PathVariable("n_account") BigInteger n_account){
				System.err.println(n_account);
		return bank_OperationsServices.getLastBalance(n_account);
	}
		
	
	
	
	
	
	@PostMapping(path="AddBank_Operation")
	public Bank_Operations AddBank_Operation(@RequestBody Bank_Operations bank_operations) {
		
	
		
		
		BigInteger n_account = bank_operations.getN_account();
		String concept = bank_operations.getConcept();
		String type = bank_operations.getType();	
		double quantity = bank_operations.getQuantity();
//		double balance = bank_operations.getBalance();
		double quantity_new = 0;
		double balance_last ;
		double balance_proceso;
		double balance_all;
		
		DecimalFormat formato1 = new DecimalFormat("#.00");
		
		System.err.println("AddBank_Operation "+n_account+" "+type+" "+concept+" "+quantity+" ");
		
		
		balance_last = bank_OperationsServices.getLastBalance(n_account);
	
		Date date_operation= new Date();
		
	   		
	    if (type.equals("expense")) {
	    	
	    	quantity = quantity * -1 ;
	    
		}
	    if (balance_last == 0) {
	    	
	    	 System.err.println("AddBank_Operation "+n_account+" "+type+" "+concept+" "+quantity+" "+date_operation+" "+balance_last);
			
		}
	    balance_all = balance_last + quantity;
	    
	    
		    
	    System.err.println("AddBank_Operation "+n_account+" "+type+" "+concept+" "+quantity+" "+date_operation+" "+formato1.format(balance_all));
	    
	    bank_OperationsServices.AddBank_Operation(n_account, concept, type, quantity, balance_all, date_operation);
	    
	    
	  		
		return null;
	}
	
	
	
	
	
	
	
	

}
