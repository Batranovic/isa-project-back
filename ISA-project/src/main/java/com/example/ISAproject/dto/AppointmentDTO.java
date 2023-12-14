package com.example.ISAproject.dto;

import java.time.LocalDateTime;

import com.example.ISAproject.enums.AppointmentStatus;
import com.example.ISAproject.model.Appointment;

public class AppointmentDTO {
	private int id;
    private CompanyAdminDTO companyAdministrator;
	private LocalDateTime startDate;
	private int duration;
    private AppointmentStatus status;
    
    public AppointmentDTO() {
    	
    }
    
	public AppointmentDTO(int id, CompanyAdminDTO companyAdministrator, LocalDateTime startDate, int duration,
			AppointmentStatus status) {
		super();
		this.id = id;
		this.companyAdministrator = companyAdministrator;
		this.startDate = startDate;
		this.duration = duration;
		this.status = status;
	} 
	
	public AppointmentDTO(Appointment appointment)
	{
		this.id = appointment.getId();
		this.companyAdministrator = new CompanyAdminDTO(appointment.getCompanyAdmin());
		this.startDate = appointment.getDateAndTime();
		this.duration = appointment.getDuration();
		this.status = appointment.getStatus();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public CompanyAdminDTO getCompanyAdministrator() {
		return companyAdministrator;
	}

	public void setCompanyAdministrator(CompanyAdminDTO companyAdministrator) {
		this.companyAdministrator = companyAdministrator;
	}

	public LocalDateTime getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
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
