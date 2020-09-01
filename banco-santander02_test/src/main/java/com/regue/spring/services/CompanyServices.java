package com.regue.spring.services;

import com.regue.spring.model.Company;
import com.regue.spring.model.Customers;


public interface CompanyServices {
	
	Company getCompany(String cif);
	
	
	Company FindEmailCompany(String email);
	void AddCompany(String name , String email,String cif,String direction,int id_nationality);

}
