package com.example.ISAproject.dto;

import java.util.Set;
import java.util.HashSet;

import com.example.ISAproject.enums.ReservationStatus;
import com.example.ISAproject.model.Equipment;
import com.example.ISAproject.model.Reservation;

public class ReservationDTO {
	
    private int id;
    private ReservationStatus status;
    private Set<EquipmentDTO> equipment;
    private AppointmentDTO appointment;
    private UserDto user;
    
   public ReservationDTO() {
	   
   }
    public ReservationDTO(int id, ReservationStatus status, Set<EquipmentDTO> equipment, AppointmentDTO appointment, UserDto user) {
		super();
		this.id = id;
		this.status = status;
		this.equipment = equipment;
		this.appointment = appointment;
		this.user = user;
	}

	public ReservationDTO(Reservation reservation)
    {
        this.id = reservation.getId();
        this.status = reservation.getStatus();
        this.equipment = new HashSet<>();;
        for (Equipment equipment : reservation.getEquipments()) {
            this.equipment.add(new EquipmentDTO(equipment));
        }
        this.appointment = new AppointmentDTO(reservation.getAppointment());
        this.user = new UserDto(reservation.getUser());
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ReservationStatus getStatus() {
		return status;
	}

	public void setStatus(ReservationStatus status) {
		this.status = status;
	}

	public Set<EquipmentDTO> getEquipment() {
		return equipment;
	}

	public void setEquipment(Set<EquipmentDTO> equipment) {
		this.equipment = equipment;
	}

	public AppointmentDTO getAppointment() {
		return appointment;
	}

	public void setAppointment(AppointmentDTO appointment) {
		this.appointment = appointment;
	}
	public UserDto getUser() {
		return user;
	}
	public void setUser(UserDto user) {
		this.user = user;
	}
	
	
}
