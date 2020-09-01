package com.regue.spring.repository;

import java.math.BigInteger;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.regue.spring.model.Bank_Account;


public interface Bank_AccountRepository extends JpaRepository<Bank_Account, Integer>{
	

	@Query("SELECT b FROM Bank_Account b where b.user_code = ?1")
	public List<Bank_Account> getBankAccounts$(String user_code);
	
	@Modifying
	@Query(value = "INSERT INTO Bank_Account (n_account,user_code) VALUES (:n_account,:user_code)", nativeQuery = true)
	@Transactional
	void AddBank_Account$(@Param("n_account") BigInteger n_account, @Param("user_code") String user_code);
	
	

//	@Query("SELECT b FROM Bank_Account b where b.user_code = ?1")
//	BigInteger getLastAccountI$(String user_code);
	
	
}
