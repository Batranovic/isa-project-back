package com.example.ISAproject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name="RESERVATION_REQUESTS")
public class ReservationRequest {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="equipment_id")
	private Integer equipmentId;
	
	@Column(name= "quantity")
	private Integer quantity;
	
	 @ManyToOne
	 @JoinColumn(name = "reservation_id")
	 private Reservation reservation;

	public ReservationRequest() {
		super();
	}

	public ReservationRequest(int id, Integer equipmentId, Integer quantity, Reservation reservation) {
		super();
		this.id = id;
		this.equipmentId = equipmentId;
		this.quantity = quantity;
		this.reservation = reservation;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Integer getEquipmentId() {
		return equipmentId;
	}

	public void setEquipmentId(Integer equipmentId) {
		this.equipmentId = equipmentId;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}



	public Reservation getReservation() {
		return reservation;
	}



	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}





	
    
	
	 
	 
}
