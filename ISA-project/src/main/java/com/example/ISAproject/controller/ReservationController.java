package com.example.ISAproject.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.ISAproject.dto.CompanyDto;
import com.example.ISAproject.dto.ReservationDTO;
import com.example.ISAproject.dto.ReservationQrDTO;
import com.example.ISAproject.dto.UserDto;
import com.example.ISAproject.dto.ViewReservationDTO;
import com.example.ISAproject.dto.AppointmentDTO;
import com.example.ISAproject.enums.ReservationStatus;
import com.example.ISAproject.model.Appointment;
import com.example.ISAproject.model.Reservation;
import com.example.ISAproject.model.ReservationRequest;
import com.example.ISAproject.model.User;
import com.example.ISAproject.service.EmailService;
import com.example.ISAproject.service.ReservationService;
import com.example.ISAproject.service.UserService;

@RestController
@RequestMapping(value = "api/reservations")
@CrossOrigin(origins = "http://localhost:4200")
public class ReservationController {

	@Autowired
	private ReservationService reservationService;
	
	private Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private EmailService emailService;
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/create/{appointmentId}/{userId}")
	public ResponseEntity<ReservationDTO> createReservation(
	        @PathVariable Integer appointmentId,
	        @RequestBody List<ReservationRequest> reservationRequests,
	        @PathVariable Integer userId) {

	    List<Integer> equipmentIds = reservationRequests.stream()
	            .map(ReservationRequest::getEquipmentId)
	            .collect(Collectors.toList());

	    Reservation reservation = reservationService.createReservation(appointmentId, reservationRequests, userId);
	    User user = userService.findOne(userId);

	    if (reservation != null) {
	        try {
	            System.out.println("Thread id: " + Thread.currentThread().getId());
	            emailService.sendQRCode(user, reservation);
	        } catch (Exception e) {
	            logger.error("Greška prilikom slanja emaila: " + e.getMessage(), e);
	        }

	        ReservationDTO createdReservationDTO = new ReservationDTO(reservation);
	        return new ResponseEntity<>(createdReservationDTO, HttpStatus.CREATED);
	    } else {
	        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	    }
	}
	
	@GetMapping("/userReservation/{userId}")
	public ResponseEntity<List<ViewReservationDTO>> getReservationsForUser(@PathVariable int userId) {
	    List<ViewReservationDTO> reservationDTOs = reservationService.getReservationsForUser(userId);
	    return ResponseEntity.ok(reservationDTOs);
	}
	
	@PutMapping("/cancel/{reservationId}/{userId}")
	public void cancelReservation(
			@PathVariable Integer reservationId,
	        @PathVariable Integer userId) {
	 reservationService.cancelReservation(reservationId, userId);
	}
	/*
	@GetMapping("/withQr/{userId}")
	public ResponseEntity<List<ReservationQrDTO>> getAllWithQr(@PathVariable int userId) {
		List<Reservation> reservations = reservationService.getAllWithQr(userId);
		List<ReservationQrDTO> reservationsDTO = reservations.stream().map(ReservationQrDTO::new).collect(Collectors.toList());
		return new ResponseEntity<>(reservationsDTO, HttpStatus.OK);
	}
	*/
}
