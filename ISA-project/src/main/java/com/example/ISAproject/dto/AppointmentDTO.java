package com.example.ISAproject.dto;

import java.time.LocalDateTime;

import com.example.ISAproject.enums.AppointmentStatus;
import com.example.ISAproject.model.Appointment;

public class AppointmentDTO {
	private int id;
    private CompanyAdminDTO companyAdmin;
	private LocalDateTime dateAndTime;
	private int duration;
    private AppointmentStatus status;
    
    public AppointmentDTO() {
    	
    }
    
	public AppointmentDTO(int id, CompanyAdminDTO companyAdmin, LocalDateTime dateAndTime, int duration,
			AppointmentStatus status) {
		super();
		this.id = id;
		this.companyAdmin = companyAdmin;
		this.dateAndTime = dateAndTime;
		this.duration = duration;
		this.status = status;
	} 
	
	public AppointmentDTO(Appointment appointment)
	{
		this.id = appointment.getId();
		this.companyAdmin = new CompanyAdminDTO(appointment.getCompanyAdmin());
		this.dateAndTime = appointment.getDateAndTime();
		this.duration = appointment.getDuration();
		this.status = appointment.getStatus();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public CompanyAdminDTO getCompanyAdmin() {
		return companyAdmin;
	}

	public void setCompanyAdmin(CompanyAdminDTO companyAdmin) {
		this.companyAdmin = companyAdmin;
	}


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
	
	

}
