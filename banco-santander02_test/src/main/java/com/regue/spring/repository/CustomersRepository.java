package com.regue.spring.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.regue.spring.model.Customers;


public interface CustomersRepository extends JpaRepository<Customers, Integer>{
	
	@Query("SELECT c FROM Customers c where c.dni = ?1")
	public Customers getCustmer$(String dni);
	
	@Query("SELECT c FROM Customers c where c.email = ?1")
	public Customers FindEmailCustomer$(String email);
	
	@Modifying
	@Query(value = "INSERT INTO Customers "
			+ "( first_name,last_name,email,dni,direction,id_nationality) VALUES (:first_name,:last_name,:email,:dni,:direction,:id_nationality)", nativeQuery = true)
	@Transactional
	 void AddCustomer$(
			@Param("first_name")String first_name,
			@Param("last_name")String last_name,
			@Param("email")String email,
			@Param("dni")String dni,
			@Param("direction")String direction,
			@Param("id_nationality")int id_nationality
			);
	

}
