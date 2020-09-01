package com.regue.spring.repository;

import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;

import com.regue.spring.model.SessionRegistration;

public interface SessionRegistrationRepository  extends MongoRepository<SessionRegistration, String>{
	
//	@Modifying
//	@Query(value = "INSERT INTO SessionRegistration (id,user_code,state,data_session) VALUES (:id,:user_code,:state,:data_session)", nativeQuery = true)
//	@Transactional
//	void AddSessionRegistrationOpen$(@Param("id") String id,@Param("user_code") String user_code, @Param("state") String state, @Param("data_session") Date data_session);

}
