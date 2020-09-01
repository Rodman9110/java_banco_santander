package com.regue.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.regue.spring.model.Countries;
import com.regue.spring.repository.CountriesRepository;


@Service("CountriesServices")
public class CountriesServicesImpl implements CountriesServices{

	@Autowired
	CountriesRepository countriesRepository;
	
	@Override
	public List<Countries> listar() {
		// TODO Auto-generated method stub
		return countriesRepository.findAll();
	}

	@Override
	public Countries getCountry(int id_nationality) {
		// TODO Auto-generated method stub
		return countriesRepository.getCountry(id_nationality);
	}

	@Override
	public Countries getCountryForUserCode(String user_code) {
		// TODO Auto-generated method stub
		return countriesRepository.getCountryForUserCode$(user_code);
	}

	@Override
	public Countries getCountryForUserCodeCompany(String user_code) {
		// TODO Auto-generated method stub
		return countriesRepository.getCountryForUserCodeCompany$(user_code);
	}

}
