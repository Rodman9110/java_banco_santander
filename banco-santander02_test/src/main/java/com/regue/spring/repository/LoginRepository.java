package com.regue.spring.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.regue.spring.model.Login;


public interface LoginRepository extends JpaRepository<Login, Integer>{
	
	@Query("SELECT l FROM Login l where l.user_code = ?1 and l.password= ?2")
	public Login findLogin$(String user, String password);
	
	@Query("SELECT l FROM Login l where l.user_code = ?1")
	Login findLoginForUser$(String user);
	
	@Modifying
	@Query(value = "INSERT INTO Login (user_code,password,type) VALUES (:user_code,:password,:type)", nativeQuery = true)
	@Transactional
	void AddLogin$(@Param("user_code") String user_code, @Param("password") String password, @Param("type") String type);

	

}
