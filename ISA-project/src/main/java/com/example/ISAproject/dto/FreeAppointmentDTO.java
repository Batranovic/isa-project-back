package com.example.ISAproject.dto;

import java.time.LocalDateTime;

import com.example.ISAproject.enums.AppointmentStatus;
import com.example.ISAproject.model.Appointment;
import com.fasterxml.jackson.annotation.JsonFormat;

public class FreeAppointmentDTO {
	private int id;
	private int companyAdminId;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime dateAndTime;
	private int duration;
	private AppointmentStatus status;

	public FreeAppointmentDTO() {
		super();
	}

	public FreeAppointmentDTO(int id, int companyAdminId, LocalDateTime dateAndTime, int duration) {
		super();
		this.id = id;
		this.companyAdminId = companyAdminId;
		this.dateAndTime = dateAndTime;
		this.duration = duration;
	}

	public FreeAppointmentDTO(Appointment appointment) {
		this.id = appointment.getId();
		this.companyAdminId = appointment.getCompanyAdmin().getId();
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

	public AppointmentStatus getStatus() {
		return status;
	}

	public void setStatus(AppointmentStatus status) {
		this.status = status;
	}

}
