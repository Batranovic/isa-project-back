package com.example.ISAproject.dto;

public class CompanySearchDto {
	private String name;
	private String address;
	private double averageGradeFrom;
	private double averageGradeTo;

	public CompanySearchDto() {
		super();
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

	public double getAverageGradeFrom() {
		return averageGradeFrom;
	}

	public void setAverageGradeFrom(double averageGradeFrom) {
		this.averageGradeFrom = averageGradeFrom;
	}

	public double getAverageGradeTo() {
		return averageGradeTo;
	}

	public void setAverageGradeTo(double averageGradeTo) {
		this.averageGradeTo = averageGradeTo;
	}

}
