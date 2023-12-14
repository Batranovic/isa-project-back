package com.example.ISAproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.ISAproject.dto.CompanyDto;
import com.example.ISAproject.dto.ReservationDTO;
import com.example.ISAproject.dto.UserDto;
import com.example.ISAproject.dto.AppointmentDTO;
import com.example.ISAproject.enums.ReservationStatus;
import com.example.ISAproject.model.Reservation;
import com.example.ISAproject.service.ReservationService;
import com.example.ISAproject.service.UserService;

@RestController
@RequestMapping(value = "api/reservations")
@CrossOrigin(origins = "http://localhost:4200")
public class ReservationController {

	@Autowired
	private ReservationService reservationService;
	
	@PostMapping("/create/{appointmnetId}/{equipmentId}/{userId}")
    public ResponseEntity<ReservationDTO> createReservation(
            @PathVariable Integer appointmnetId,
            @PathVariable Integer equipmentId,
            @PathVariable Integer userId) {

        Reservation reservation = reservationService.createReservation(appointmnetId, equipmentId, userId);

        if (reservation != null) {
            ReservationDTO createdReservationDTO = new ReservationDTO(reservation);
            return new ResponseEntity<>(createdReservationDTO, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
	/*
	@PostMapping("/create/{appointmnetId}")
	public ResponseEntity<ReservationDTO> createReservation(
	        @PathVariable Integer appointmnetId,
	        @RequestParam List<Integer> equipmentIds) {

	    Reservation reservation = reservationService.createReservation(appointmnetId, equipmentIds);

	    if (reservation != null) {
	        ReservationDTO createdReservationDTO = new ReservationDTO(reservation);
	        return new ResponseEntity<>(createdReservationDTO, HttpStatus.CREATED);
	    } else {
	        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	    }
	}*/

}
