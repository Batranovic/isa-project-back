package com.example.ISAproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.ISAproject.model.Company;
import com.example.ISAproject.model.Equipment;
import java.util.Set;

public interface CompanyRepository extends JpaRepository<Company, Integer>  {
	Set<Equipment> findByid(int companyId);
}
