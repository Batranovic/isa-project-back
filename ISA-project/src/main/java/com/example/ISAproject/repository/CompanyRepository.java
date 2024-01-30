package com.example.ISAproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.ISAproject.model.Company;
import com.example.ISAproject.model.Role;


public interface CompanyRepository extends JpaRepository<Company, Integer>  {

	List<Company> findByNameContainingIgnoreCaseAndAddressContainingIgnoreCaseAndAverageGradeBetween(String name, String address, double minGrade, double maxGrade);
	
	List<Company> findByNameContainingIgnoreCaseAndAddressContainingIgnoreCase(String name, String address);
}
