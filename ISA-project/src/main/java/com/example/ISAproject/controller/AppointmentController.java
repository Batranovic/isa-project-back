package com.example.ISAproject.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ISAproject.dto.FreeAppointmentDTO;
import com.example.ISAproject.model.Appointment;
import com.example.ISAproject.service.AppointmentService;

@RestController
@RequestMapping(value = "api/appointments")
@CrossOrigin(origins = "http://localhost:4200")
public class AppointmentController {

	@Autowired
	private AppointmentService appointmentService;

	@GetMapping(value = "/getFreeAppointments/{date}")
	public ResponseEntity<List<FreeAppointmentDTO>> getFreeAppointments(@PathVariable LocalDate date) {
		List<Appointment> appointements = appointmentService.getAllFreeAppointmentsForDate(date);

		List<FreeAppointmentDTO> appointmentsDTO = appointements.stream().map(FreeAppointmentDTO::new)
				.collect(Collectors.toList());

		return new ResponseEntity<>(appointmentsDTO, HttpStatus.OK);
	}

}
