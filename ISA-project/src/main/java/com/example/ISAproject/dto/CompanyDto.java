package com.example.ISAproject.dto;

import com.example.ISAproject.model.Company;

public class CompanyDto {
	private int id;
	private String name;
	private String address;
	private String description;
	private double averageGrade;

	public CompanyDto() {

	}

	public CompanyDto(Company company) {
		id = company.getId();
		name = company.getName();
		address = company.getAddress();
		description = company.getDescription();
		averageGrade = company.getAverageGrade();
	}

	public CompanyDto(int id, String name, String address, String description, double averageGrade) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.description = description;
		this.averageGrade = averageGrade;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getAverageGrade() {
		return averageGrade;
	}

	public void setAverageGrade(double averageGrade) {
		this.averageGrade = averageGrade;
	}

}
