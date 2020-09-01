package com.regue.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.regue.spring.model.Income;
import com.regue.spring.repository.IncomeRepository;

@Service("IncomeServices")
public class IncomeServicesImpl implements IncomeServices {
	
	@Autowired
	IncomeRepository incomeRepository;

	@Override
	public List<Income> listar() {
		
		return incomeRepository.findAll();
	}
	
	

}
