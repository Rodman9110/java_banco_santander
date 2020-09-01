package com.regue.spring.services;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;

import com.regue.spring.model.Countries;


public interface CountriesServices {
	
	List<Countries>listar();
	Countries getCountry ( int  id_nationality);
	Countries getCountryForUserCode (String  user_code);
	Countries getCountryForUserCodeCompany(String user_code);

}
