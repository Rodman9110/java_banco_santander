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

import com.regue.spring.model.Credit_Card;

public interface Credit_CardRepository extends JpaRepository<Credit_Card, Integer>{
	
	@Modifying
	@Query(value = "INSERT INTO Credit_Card (n_card,n_account,owner,date_card,code) VALUES (:n_card,:n_account,:owner,:date_card,:code)", nativeQuery = true)
	@Transactional
	void AddCredit_Card$(
			@Param("n_card") BigInteger n_card,
			@Param("n_account") BigInteger n_account,
			@Param("owner") String owner,
			@Param("date_card") Date date_card,
			@Param("code") int code
			);
	
	@Query("SELECT cc FROM Credit_Card cc INNER JOIN Bank_Account ba ON cc.n_account = ba.n_account Where ba.user_code = ?1 ")
	List<Credit_Card> getCreditCardsUser$(String user_code);
	
	@Query("SELECT cc FROM Credit_Card cc Where cc.n_card = ?1 ")
	Credit_Card getCreditCard$(BigInteger n_card);

}
