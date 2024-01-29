package com.example.ISAproject.dto;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.example.ISAproject.enums.ReservationStatus;
import com.example.ISAproject.model.Reservation;
import com.example.ISAproject.service.EmailService;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;

public class ReservationQrDTO extends ReservationDTO{

	private String qrCode;
	
	

	public ReservationQrDTO() {
		super();
	}

	public byte[] generateQrCode(String content) throws WriterException, IOException {
		int width = 300;
		int height = 300;
		
		Map<EncodeHintType, Object> hints = new HashMap<>();
		hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
		
		BitMatrix bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, width, height, hints);
		
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		MatrixToImageWriter.writeToStream(bitMatrix, "PNG", outputStream);
			
		return outputStream.toByteArray();
	}
	
	public ReservationQrDTO(int id, ReservationStatus status, Set<EquipmentDTO> equipment, AppointmentDTO appointment,
			UserDto user) {
		super(id, status, equipment, appointment, user);
	}

	public ReservationQrDTO(Reservation reservation) {
		super(reservation);
		qrCode = EmailService.generateQRCodeData(reservation);
	}

	public String getQrCode() {
		return qrCode;
	}

	public void setQrCode(String qrCode) {
		this.qrCode = qrCode;
	}
	
	
	
	
	
}
