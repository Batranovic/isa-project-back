package com.example.ISAproject.dto;

import com.example.ISAproject.model.Appointment;
import com.example.ISAproject.model.CompanyAdmin;

public class CompanyAdminDTO {
	private int id;
	private UserDto user;
	private CompanyDto company;
	
	public CompanyAdminDTO() {
		
	}

	public CompanyAdminDTO(int id, UserDto user, CompanyDto company) {
		super();
		this.id = id;
		this.user = user;
		this.company = company;
	}
	
	public CompanyAdminDTO(CompanyAdmin companyAdmin) {
	    if (companyAdmin != null) {
	        this.id = companyAdmin.getId();
	        this.user = new UserDto(companyAdmin.getUser());
	        this.company = new CompanyDto(companyAdmin.getCompany());
	    } else {
	    	System.out.println("Warning: companyAdmin is null. Default values or appropriate handling needed.");
	        
	    }
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public UserDto getUser() {
		return user;
	}

	public void setUser(UserDto user) {
		this.user = user;
	}

	public CompanyDto getCompany() {
		return company;
	}

	public void setCompany(CompanyDto company) {
		this.company = company;
	}
	
	

}
