package com.example.ISAproject.dto;

import com.example.ISAproject.enums.ReservationStatus;
import com.example.ISAproject.model.Reservation;

public class ViewReservationDTO {
	  private int id;
	    private ReservationStatus status;
	    private AppointmentDTO appointment;
	    private int price;
	    private String qrCode;
	    
	    public ViewReservationDTO(Reservation reservation)
	    {
	        this.id = reservation.getId();
	        this.status = reservation.getStatus();
	        this.appointment = new AppointmentDTO(reservation.getAppointment());
	        this.price = reservation.getPrice();
	        this.qrCode = reservation.getQrCode();
	    }
	    public ViewReservationDTO() {
			super();
		}
		public ViewReservationDTO(int id, ReservationStatus status, AppointmentDTO appointment, int price, String qrCode) {
			super();
			this.id = id;
			this.status = status;
			this.appointment = appointment;
			this.price = price;
			this.qrCode = qrCode;
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
		public int getPrice() {
			return price;
		}
		public void setPrice(int price) {
			this.price = price;
		}
		public String getQrCode() {
			return qrCode;
		}
		public void setQrCode(String qrCode) {
			this.qrCode = qrCode;
		}
	    
	    
	    
}
