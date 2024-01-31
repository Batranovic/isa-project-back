package com.example.ISAproject.dto;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.example.ISAproject.enums.ReservationStatus;
import com.example.ISAproject.model.Equipment;
import com.example.ISAproject.model.Reservation;
import com.example.ISAproject.service.EmailService;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;

public class ReservationQrDTO {

	private int id;
    private ReservationStatus status;
    private UserDto user;
    private String qrCode;
	public ReservationQrDTO(int id, ReservationStatus status, UserDto user, String qrCode) {
		super();
		this.id = id;
		this.status = status;
		this.user = user;
		this.qrCode = qrCode;
	}
    
    public ReservationQrDTO(Reservation reservation) {
    	super();
    	this.id = reservation.getId();
    	this.status = reservation.getStatus();
    	this.user = new UserDto(reservation.getUser());
    	this.qrCode = reservation.getQrCode();
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

	public UserDto getUser() {
		return user;
	}

	public void setUser(UserDto user) {
		this.user = user;
	}

	public String getQrCode() {
		return qrCode;
	}

	public void setQrCode(String qrCode) {
		this.qrCode = qrCode;
	}
 
    
    
}
