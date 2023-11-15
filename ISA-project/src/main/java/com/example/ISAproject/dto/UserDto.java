package com.example.ISAproject.dto;

import com.example.ISAproject.model.User;

public class UserDto {
	private int id;
	private String name;
	private String surname;
	private String email;
	private String city;
	private String country;
	private String phoneNumber;
	private String profession;
	private String companyInformation;

	public UserDto() {

	}
	
	public UserDto(User user) {
		id = user.getId();
		name = user.getName();
		surname = user.getSurname();
		email = user.getEmail();
		city = user.getCity();
		country = user.getCountry();
		phoneNumber = user.getPhoneNumber();
		profession = user.getProfession();
		companyInformation = user.getCompanyInformation();
	}

	public UserDto(int id, String name, String surname, String email, String city, String country,
			String phoneNumber, String profession, String companyInformation) {
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.city = city;
		this.country = country;
		this.phoneNumber = phoneNumber;
		this.profession = profession;
		this.companyInformation = companyInformation;
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

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public String getCompanyInformation() {
		return companyInformation;
	}

	public void setCompanyInformation(String companyInformation) {
		this.companyInformation = companyInformation;
	}

}
