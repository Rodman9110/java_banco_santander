package com.regue.spring.services;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;

import com.regue.spring.model.Credit_Card;


public interface Credit_CardServices {
	
	void AddCredit_Card(BigInteger n_card,BigInteger n_account, String owner,Date date_card,int code);
	List<Credit_Card> getCreditCardsUser ( String user_code);
	Credit_Card getCreditCard(BigInteger n_card);

}
