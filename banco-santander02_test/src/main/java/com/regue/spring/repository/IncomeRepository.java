package com.regue.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.regue.spring.model.Income;

public interface IncomeRepository extends JpaRepository<Income, Integer>{

}
