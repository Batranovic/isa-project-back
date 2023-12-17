package com.example.ISAproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ISAproject.model.CompanyAdmin;

public interface CompanyAdminRepository extends JpaRepository<CompanyAdmin, Integer>{
	List<CompanyAdmin> findByCompanyId(int compId);
}
