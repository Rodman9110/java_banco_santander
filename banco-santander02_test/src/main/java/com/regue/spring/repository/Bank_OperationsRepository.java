package com.regue.spring.repository;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;

import com.regue.spring.model.Bank_Operations;

public interface Bank_OperationsRepository extends JpaRepository<Bank_Operations, Integer>{
	
	@Modifying
	@Query(value = "INSERT INTO Bank_Operations (n_account,concept,type,quantity,balance,date_operation) VALUES (:n_account,:concept,:type,:quantity,:balance,:date_operation)", nativeQuery = true)
	@Transactional
	void AddBank_Operation$(
			@Param("n_account") BigInteger n_account,
			@Param("concept") String concept,
			@Param("type") String type,
			@Param("quantity") double quantity,
			@Param("balance") double balance,
			@Param("date_operation") Date date_operation			
			);
	
	
	@Query("SELECT b FROM Bank_Operations b where b.n_account = ?1")
	public List<Bank_Operations> getAllBankOperationUser$(BigInteger n_account);
	
	@Query("SELECT b.balance FROM Bank_Operations b where b.n_account = ?1  AND b.date_operation=(SELECT MAX(date_operation) FROM Bank_Operations b where b.n_account = ?1)")
	double getLastBalance$(BigInteger n_account);
	
	@Query("SELECT SUM(bo.balance) as balance FROM Bank_Operations bo INNER JOIN Bank_Account ba ON bo.n_account = ba.n_account WHERE  ba.user_code = ?1 AND bo.date_operation=(SELECT MAX(bo2.date_operation) FROM Bank_Operations bo2 INNER JOIN Bank_Account ba2 ON bo2.n_account = ba2.n_account WHERE  ba2.user_code = ?1)")
	double getTotalBalance$(String user_code);
	
	@Query("SELECT bo FROM Bank_Operations bo INNER JOIN Bank_Account ba ON bo.n_account = ba.n_account WHERE  ba.user_code = ?1 AND bo.date_operation = (SELECT MAX(bo2.date_operation) FROM Bank_Operations bo2 INNER JOIN Bank_Account ba2 ON bo2.n_account = ba2.n_account WHERE  ba2.user_code = ?1) ")
	List<Bank_Operations> getAccountBalance$(String user_code);
	
	@Query("SELECT bo FROM Bank_Operations bo INNER JOIN Bank_Account ba ON bo.n_account = ba.n_account WHERE  ba.user_code = ?1 ORDER BY bo.date_operation DESC")
	List<Bank_Operations> getAllBankOperationsUser$(String user_code);
	

}
