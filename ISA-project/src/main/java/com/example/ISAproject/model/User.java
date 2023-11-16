package com.example.ISAproject.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Email;


@Entity
@Table(name = "USERS")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "name", nullable = false)
	@NotEmpty
	private String name;
	
	@Column(name = "surname", nullable = false)
	@NotEmpty
	private String surname;
	
	@Column(name = "email", nullable = false, unique = true)
	@Email(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")
	private String email;
	
	@Column(name = "password", nullable = false)
	@NotEmpty
	private String password;
	
	@Column(name = "city", nullable = false)
	@NotEmpty
	private String city;
	
	@Column(name = "country", nullable = false)
	@NotEmpty
	private String country;
	
	@Column(name = "phone_number", nullable = false)
	@NotEmpty
	private String phoneNumber;
	
	@Column(name = "profession", nullable = false)
	@NotEmpty
	private String profession;
	
	@Column(name = "company_information", nullable = false)
	@NotEmpty
	private String companyInformation;

	public User() {
		super();
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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
