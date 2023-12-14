package com.example.ISAproject.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.util.ArrayList;


import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="company")
public class Company {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "name", nullable = false)
	private String name;
	
	@Column(name = "address", nullable = false)
	private String address;
	
	@Column(name = "description", nullable = false)
	private String description;
	
	@Column(name = "average_grade", nullable = false)
	private double averageGrade;
	
	@OneToMany
	@JoinTable(name = "company_equipment",
	    joinColumns = @JoinColumn(name = "company_id", referencedColumnName = "id"),
	    inverseJoinColumns = @JoinColumn(name = "equipment_id", referencedColumnName = "id"))
    private Set<Equipment> equipments = new HashSet<Equipment>();
    
	@OneToMany
	@JoinTable(name = "company_appointment",
	    joinColumns = @JoinColumn(name = "company_id", referencedColumnName = "id"),
	    inverseJoinColumns = @JoinColumn(name = "appointment_id", referencedColumnName = "id"))
	private Set<Appointment> appointments = new HashSet<Appointment>();

	
	public Company() {
		super();
	}


	public Company(int id, String name, String address, String description, double averageGrade,
			Set<Equipment> equipments, Set<Appointment> appointments) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.description = description;
		this.averageGrade = averageGrade;
		this.equipments = equipments;
		this.appointments = appointments;
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


	public Set<Equipment> getEquipments() {
		return equipments;
	}


	public void setEquipments(Set<Equipment> equipments) {
		this.equipments = equipments;
	}


	public Set<Appointment> getAppointments() {
		return appointments;
	}


	public void setAppointments(Set<Appointment> appointments) {
		this.appointments = appointments;
	}



	
}
