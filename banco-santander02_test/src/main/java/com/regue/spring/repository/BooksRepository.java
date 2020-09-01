package com.regue.spring.repository;




import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.regue.spring.model.Books;

public interface BooksRepository extends JpaRepository<Books, Integer>{
	
	@Modifying
	@Query(value = "INSERT INTO Books (title,primary_author) VALUES (:title,:primary_author)", nativeQuery = true)
	@Transactional
	void AddBook$(@Param("title") String title, @Param("primary_author") String primary_author);

}
