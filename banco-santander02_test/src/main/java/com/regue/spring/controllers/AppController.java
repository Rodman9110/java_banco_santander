package com.regue.spring.controllers;

import java.math.BigInteger;
//import java.sql.Date;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.regue.spring.model.Countries;
import com.regue.spring.model.Customers;
import com.regue.spring.model.Income;
import com.regue.spring.repository.BooksRepository;
import com.regue.spring.repository.CountriesRepository;
import com.regue.spring.services.CountriesServices;
import com.regue.spring.services.CustomersServices;
import com.regue.spring.services.IncomeServices;





@CrossOrigin(origins="http://localhost:4200",maxAge = 3600)
@RestController
@RequestMapping(path = "/api")
public class AppController {
	
	@Autowired
	@Qualifier("CustomersServices")
	CustomersServices customersServices;
	
	@Autowired
	@Qualifier("IncomeServices")
	IncomeServices incomeServices;
	
	@Autowired
	@Qualifier("CountriesServices")
	CountriesServices countriesServices;
	
	@Autowired
	CountriesRepository countriesRepository;
	
	@Autowired
	BooksRepository booksRepository;
	
	private static final DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

	
	@GetMapping(path= {"countries"})
	public List<Countries> getAllCountries (){
		System.err.println("countries");
		
//		 DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		 
//		 DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//	     Calendar cal = Calendar.getInstance();
//	     System.err.println(dateFormat.format(cal.getTime()));
//	     System.err.println(cal);
//	     
//	     //--------------------------------------------------------------
//	     
//	     Date date = new Date();
//	     System.err.println("------------"+sdf.format(date));
	     
	     
//		Calendar cal = Calendar.getInstance();
//		Date date_old= new Date();
//		cal.add(Calendar.YEAR, 4);
//		Date date_card = cal.getTime();
//	    System.err.println("------------"+sdf.format(date_old));
//	    System.err.println("------------"+sdf.format(date_card));
//		
		
//		return customersServices.listar();
		return countriesServices.listar();
	}
	
	
	@GetMapping(path= {"countries/{id_nationality}"})
	public Countries getCountry (@PathVariable("id_nationality") int  id_nationality){
		System.err.println("eee");
		
		return countriesServices.getCountry(id_nationality);
	}

	@GetMapping(path= {"getCountryForUserCode/{user_code}"})
	public Countries getCountryForUserCode (@PathVariable("user_code") String  user_code){
	
		
		return countriesServices.getCountryForUserCode(user_code);
	}
	@GetMapping(path= {"getCountryForUserCodeCompany/{user_code}"})
	public Countries getCountryForUserCodeCompany (@PathVariable("user_code") String  user_code){
	
		
		return countriesServices.getCountryForUserCodeCompany(user_code);
	}
	
	
	@GetMapping(path= {"getAllCustomers"})
	public List<Customers> getAllCustomers (){
		System.err.println("");
//		return customersServices.listar();
		return customersServices.listar();
	}
	
	@GetMapping(path= {"getAllIncome"})
	public List<Income> getAllIncome (){
		System.err.println("getAllIncome");
//		return customersServices.listar();
		return incomeServices.listar();
	}

}
