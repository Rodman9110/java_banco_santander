package com.regue.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.regue.spring.model.Customers;
import com.regue.spring.repository.CustomersRepository;



@Service("CustomersServices")
public class CustomersServicesImpl implements CustomersServices{
	
	@Autowired
	CustomersRepository customersRepository;

	@Override
	public List<Customers> listar() {
		// TODO Auto-generated method stub
//		return customersRepository.getAllCustomers$();
		return customersRepository.findAll();
	}

	@Override
	public Customers getCustomer(String dni) {
		
		return customersRepository.getCustmer$(dni);
	}

	@Override
	public Customers FindEmailCustomer(String email) {
		// TODO Auto-generated method stub
		return customersRepository.FindEmailCustomer$(email);
	}

	@Override
	public void AddCustomer(String first_name, String last_name, String email, String dni, String direction,
			int id_nationality) {
		// TODO Auto-generated method stub
		customersRepository.AddCustomer$(first_name, last_name, email, dni, direction, id_nationality);
	}

}
