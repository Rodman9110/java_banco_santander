package com.regue.spring.services;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.regue.spring.model.Credit_Card;
import com.regue.spring.repository.Credit_CardRepository;

@Service("Credit_CardServices")
public class Credit_CardServicesImpl implements Credit_CardServices{
	
	@Autowired
	Credit_CardRepository credit_CardRepository;

	@Override
	public void AddCredit_Card(BigInteger n_card, BigInteger n_account, String owner, Date date_card, int code) {
		
		credit_CardRepository.AddCredit_Card$(n_card, n_account, owner, date_card, code);
		
	}

	@Override
	public List<Credit_Card> getCreditCardsUser(String user_code) {
		// TODO Auto-generated method stub
		return credit_CardRepository.getCreditCardsUser$(user_code);
	}

	@Override
	public Credit_Card getCreditCard(BigInteger n_card) {
		// TODO Auto-generated method stub
		return credit_CardRepository.getCreditCard$(n_card);
	}

}
