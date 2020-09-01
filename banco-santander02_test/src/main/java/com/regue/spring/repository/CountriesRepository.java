package com.regue.spring.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import com.regue.spring.model.Countries;


@Repository
public interface CountriesRepository extends JpaRepository<Countries, Integer>{
	

	@Query("SELECT c FROM Countries c WHERE c.id = ?1")
	Countries getCountry (int  id_nationality);
	
	@Query("SELECT co FROM Countries co INNER JOIN Customers cu ON co.id = cu.id_nationality  WHERE cu.dni = ?1")
	Countries getCountryForUserCode$(String user_code);
	
	@Query("SELECT co FROM Countries co INNER JOIN Company c ON co.id = c.id_nationality  WHERE c.cif = ?1")
	Countries getCountryForUserCodeCompany$(String user_code);


}
