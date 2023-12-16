package com.example.ISAproject.dto;

import java.time.LocalDateTime;

import com.example.ISAproject.model.Appointment;

public class FreeAppointmentDTO {
	private int companyAdminId;
	private LocalDateTime dateAndTime;
	private int duration;

	public FreeAppointmentDTO() {
		super();
	}

	public FreeAppointmentDTO(int companyAdminId, LocalDateTime dateAndTime, int duration) {
		super();
		this.companyAdminId = companyAdminId;
		this.dateAndTime = dateAndTime;
		this.duration = duration;
	}
	public FreeAppointmentDTO(Appointment appointment)
	{
		this.companyAdminId = appointment.getCompanyAdmin().getId();
		this.dateAndTime = appointment.getDateAndTime();
		this.duration = appointment.getDuration();
	}

	public int getCompanyAdminId() {
		return companyAdminId;
	}

	public void setCompanyAdminId(int companyAdminId) {
		this.companyAdminId = companyAdminId;
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

}
