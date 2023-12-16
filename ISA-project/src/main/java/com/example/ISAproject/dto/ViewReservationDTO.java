package com.example.ISAproject.dto;

import com.example.ISAproject.enums.ReservationStatus;
import com.example.ISAproject.model.Reservation;

public class ViewReservationDTO {
	  private int id;
	    private ReservationStatus status;
	    private AppointmentDTO appointment;
	    
	    public ViewReservationDTO(Reservation reservation)
	    {
	        this.id = reservation.getId();
	        this.status = reservation.getStatus();
	        this.appointment = new AppointmentDTO(reservation.getAppointment());
	    }
	    public ViewReservationDTO() {
			super();
		}
		public ViewReservationDTO(int id, ReservationStatus status, AppointmentDTO appointment) {
			super();
			this.id = id;
			this.status = status;
			this.appointment = appointment;
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
		public AppointmentDTO getAppointment() {
			return appointment;
		}
		public void setAppointment(AppointmentDTO appointment) {
			this.appointment = appointment;
		}
	    
	    
	    
}
