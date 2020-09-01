package com.regue.spring.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.regue.spring.model.Company;
import com.regue.spring.model.Customers;

public interface CompanyRepository extends JpaRepository<Company, Integer>{
	
	@Query("SELECT c FROM Company c where c.cif = ?1")
	public Company getCompany$(String cif);
	
	@Modifying
	@Query(value = "INSERT INTO Company "
			+ "( name,cif,email,direction,id_nationality) VALUES (:name,:cif,:email,:direction,:id_nationality)", nativeQuery = true)
	@Transactional
	 void AddCompany$(
			@Param("name")String name,
			@Param("cif")String cif,
			@Param("email")String email,
			@Param("direction")String direction,
			@Param("id_nationality")int id_nationality
			);
	
	@Query("SELECT c FROM Company c where c.email = ?1")
	public Company FindEmailCompany$(String email);
	
	
	

}
