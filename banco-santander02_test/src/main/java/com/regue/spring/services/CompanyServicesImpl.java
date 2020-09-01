package com.regue.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.regue.spring.model.Company;
import com.regue.spring.repository.CompanyRepository;

@Service("CompanyServices")
public class CompanyServicesImpl implements CompanyServices{
	
	@Autowired
	CompanyRepository companyRepository;

	@Override
	public Company getCompany(String cif) {
		// TODO Auto-generated method stub
		return companyRepository.getCompany$(cif);
	}

	@Override
	public Company FindEmailCompany(String email) {
		// TODO Auto-generated method stub
		return companyRepository.FindEmailCompany$(email);
	}

	@Override
	public void AddCompany(String name, String email, String cif, String direction, int id_nationality) {
		// TODO Auto-generated method stub
		companyRepository.AddCompany$(name, cif, email, direction, id_nationality);
		
	}

}
