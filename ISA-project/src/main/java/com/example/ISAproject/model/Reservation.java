package com.example.ISAproject.model;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.example.ISAproject.enums.ReservationStatus;

@Entity
@Table(name = "RESERVATIONS")
public class Reservation {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "status", nullable = false)
    private ReservationStatus status;

    @ManyToMany
    @JoinTable(name = "reservation_equipment",
	    joinColumns = @JoinColumn(name = "reservation_id", referencedColumnName = "id"),
	    inverseJoinColumns = @JoinColumn(name = "equipment_id", referencedColumnName = "id"))
    private Set<Equipment> equipments = new HashSet<Equipment>();

    @OneToOne
    @JoinColumn(name = "appointment_id")
    private Appointment appointment;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    
    @JoinColumn(name = "qrCode")
    private String qrCode;
    
    @Column(name="price")
    private int price;
    
    public Reservation() { }

	public Reservation(int id, ReservationStatus status, Set<Equipment> equipments, Appointment appointment, User user, int price) {
		super();
		this.id = id;
		this.status = status;
		this.equipments = equipments;
		this.appointment = appointment;
		this.user = user;
		this.price = price;
	}

	public Reservation(int id, ReservationStatus status, Set<Equipment> equipments, Appointment appointment, User user, String qrCode, int price) {
		super();
		this.id = id;
		this.status = status;
		this.equipments = equipments;
		this.appointment = appointment;
		this.user = user;
		this.qrCode = qrCode;
		this.price = price;
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

	public Set<Equipment> getEquipments() {
		return equipments;
	}

	public void setEquipments(Set<Equipment> equipments) {
		this.equipments = equipments;
	}

	public Appointment getAppointment() {
		return appointment;
	}

	public void setAppointment(Appointment appointment) {
		this.appointment = appointment;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getQrCode() {
		return qrCode;
	}

	public void setQrCode(String qrCode) {
		this.qrCode = qrCode;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}



}
