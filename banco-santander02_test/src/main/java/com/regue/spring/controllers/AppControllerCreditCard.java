package com.regue.spring.controllers;

import java.math.BigInteger;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.regue.spring.model.Bank_Account;
import com.regue.spring.model.Credit_Card;
import com.regue.spring.services.Credit_CardServices;

@CrossOrigin(origins="http://localhost:4200",maxAge = 3600)
@RestController
@RequestMapping(path = "/credit_card")
public class AppControllerCreditCard {
	
	@Autowired
	@Qualifier("Credit_CardServices")
	Credit_CardServices credit_CardServices;
	
	private static final DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	
	@GetMapping(path= {"getCreditCardsUser/{user_code}"})
	public List<Credit_Card> getCreditCardsUser (@PathVariable("user_code") String user_code){
		System.err.println("getCreditCardsUser");
//		return customersServices.listar();
		return credit_CardServices.getCreditCardsUser(user_code);
	}
	@GetMapping(path= {"getCreditCard/{n_card}"})
	public Credit_Card getCreditCard (@PathVariable("n_card") BigInteger n_card){
		System.err.println("getCreditCard");
//		return customersServices.listar();
		return credit_CardServices.getCreditCard(n_card);
	}

}
