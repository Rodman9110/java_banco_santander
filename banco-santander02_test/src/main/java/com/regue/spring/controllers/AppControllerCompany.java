package com.regue.spring.controllers;

import java.math.BigInteger;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.regue.spring.model.Company;
import com.regue.spring.model.Customers;
import com.regue.spring.services.Bank_AccountServices;
import com.regue.spring.services.Bank_OperationsServices;
import com.regue.spring.services.CompanyServices;
import com.regue.spring.services.Credit_CardServices;
import com.regue.spring.services.LoginServices;

@CrossOrigin(origins="http://localhost:4200",maxAge = 3600)
@RestController
@RequestMapping(path = "/company")
public class AppControllerCompany {
	
	@Autowired
	@Qualifier("CompanyServices")
	CompanyServices companyServices;
	
	@Autowired
	@Qualifier("LoginServices")
	LoginServices loginServices;
	
	@Autowired
	@Qualifier("Bank_AccountServices")
	Bank_AccountServices bank_AccountServices;
	
	
	@Autowired
	@Qualifier("Bank_OperationsServices")
	Bank_OperationsServices bank_OperationsServices;
	
	@Autowired
	@Qualifier("Credit_CardServices")
	Credit_CardServices credit_CardServices;
	
	
	
	
	
	private static final DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	
	@GetMapping(path= {"getCompany/{cif}"})
	public Company getCompany (@PathVariable("cif") String cif){
		System.err.println("getCompany "+cif);
//		return customersServices.listar();
		return companyServices.getCompany(cif);
	}
	
	@PostMapping(path="postAddRegisterCustomer")
	public Boolean postAddRegisterCustomer(@RequestBody Company company) {
		
		 String name = company.getName();
		 String email = company.getEmail();
		 String cif = company.getCif();
		 String direction =company.getDirection();
		 int id_nationality = company.getId_nationality();
	
		
		System.err.println(name+" "+email+" "+cif+" "+direction+" "+id_nationality);
		
//		DATE TARGETA DE CREDITO
		
		
		Calendar cal = Calendar.getInstance();
		Date date_old= new Date();
		cal.add(Calendar.YEAR, 3);
		Date date_card = cal.getTime();
	    System.err.println("------------"+sdf.format(date_old));
	    System.err.println("------------"+sdf.format(date_card));
	    
//	    CODIGO TARGETA DE CREDITO
	    
	    Random rand = new Random();
	     int max = 999;
	     int min = 100;
	    
	     int code = rand.nextInt((max - min) + 1) + min;
	     
		System.err.println(code);
		
//		NUMERO DE CUENTA BANCARIA Y DE TARGETA DE CREDITO
			
		 BigInteger maxLimit = new BigInteger("9999999999999999");
	     BigInteger minLimit = new BigInteger("1000000000000000");
	     BigInteger n_account ;
	     BigInteger n_card;
	    
			 do {
				   BigInteger bigInteger = maxLimit.subtract(minLimit);
				   Random randNum = new Random();
			     int len = maxLimit.bitLength();
			     n_account = new BigInteger(len, randNum);
				   
				} while (n_account.bitLength() != 53);
			 
			 
			 do {
				   BigInteger bigInteger = maxLimit.subtract(minLimit);
				   Random randNum = new Random();
			   int len = maxLimit.bitLength();
			   n_card = new BigInteger(len, randNum);
				   
				} while (n_card.bitLength() != 53);
				      
				      System.err.println("NUMERO DE CUENTA"+n_account +" "+n_account.bitLength());
				      System.err.println("NUMERO DE TARGETA"+n_card +" "+n_card.bitLength());
				
	      
		if (companyServices.getCompany(cif) != null) {
			
			System.err.println(" ya existe el CIF de la compañia "+name+"  de CIF "+cif);
			System.err.println("FALSE");
			return false;
			
		}
		if (companyServices.FindEmailCompany(email) != null) {
			
			System.err.println(" ya existe el email " +email);
			return false;
			 
		}
		
		else {
			System.err.println("ELSE "+name+" "+email+" "+cif+" "+direction+" "+id_nationality);
			
			companyServices.AddCompany(name, email, cif, direction, id_nationality);
			//Crear Numero de cuenta
			
			String user_code = cif;
			bank_AccountServices.AddBank_Account(n_account, user_code);
			String owner = name;
			
			System.err.println("TARGETA DE GREDITO  NUMERO DE TARGETA"+n_card+" NUMERO DE CUENTA "+n_account+" DUEÑO "+owner+"FECHA "+date_card+"CODIGO "+code);
			credit_CardServices.AddCredit_Card(n_card, n_account, name, date_card, code);;
			
			
			String concept ="Open Of Account";
			String type ="income";
			double quantity = 0;
			double balance = 0;
			Date date_operation= new Date();
			
			bank_OperationsServices.AddBank_Operation(n_account, concept, type, quantity, balance, date_operation);
			
			return true;
			
		}
		
		

	}
	
	

}
