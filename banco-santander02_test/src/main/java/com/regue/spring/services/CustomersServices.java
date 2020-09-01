package com.regue.spring.services;

import java.util.List;


import com.regue.spring.model.Customers;

public interface CustomersServices {
	
	List<Customers>listar();
	
	Customers getCustomer(String dni);
	Customers FindEmailCustomer(String email);
	void AddCustomer(String first_name,String last_name, String email,String dni,String direction,int id_nationality);

}
