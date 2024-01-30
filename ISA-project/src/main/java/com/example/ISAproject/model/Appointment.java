package com.example.ISAproject.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.NotEmpty;

import com.example.ISAproject.enums.AppointmentStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;


@Entity
@Table(name="APPOINTMENTS")
public class Appointment {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
    @JoinColumn(name = "admin_id")
    private CompanyAdmin companyAdmin;
		
	@Column(name = "start_date", nullable = false)
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime dateAndTime;
	
	@Column(name = "duration", nullable = false)
	private int duration;
	
	@Column(name = "status", nullable = false)
    private AppointmentStatus status;

	@Version
	private Integer version;
	
	public Appointment() {
		super();
	}

	public Appointment(int id, CompanyAdmin companyAdmin, LocalDateTime dateAndTime, int duration,
			AppointmentStatus status) {
		super();
		this.id = id;
		this.companyAdmin = companyAdmin;
		this.dateAndTime = dateAndTime;
		this.duration = duration;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public CompanyAdmin getCompanyAdmin() {
		return companyAdmin;
	}

	public void setCompanyAdmin(CompanyAdmin companyAdmin) {
		this.companyAdmin = companyAdmin;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public LocalDateTime getDateAndTime() {
		return dateAndTime;
	}

	public void setDateAndTime(LocalDateTime dateAndTime) {
		this.dateAndTime = dateAndTime;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public AppointmentStatus getStatus() {
		return status;
	}

	public void setStatus(AppointmentStatus status) {
		this.status = status;
	}   
	
	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}
 
}
