package com.example.ISAproject.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

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

import com.example.ISAproject.dto.AppointmentDTO;
import com.example.ISAproject.dto.CompanyDto;
import com.example.ISAproject.dto.FreeAppointmentDTO;
import com.example.ISAproject.enums.AppointmentStatus;
import com.example.ISAproject.model.Appointment;
import com.example.ISAproject.model.CompanyAdmin;
import com.example.ISAproject.service.AppointmentService;

@RestController
@RequestMapping(value = "api/appointments")
@CrossOrigin(origins = "http://localhost:4200")
public class AppointmentController {

	@Autowired
	private AppointmentService appointmentService;

	@GetMapping(value = "/getFreeAppointments/{companyId}/{date}")
	public ResponseEntity<List<FreeAppointmentDTO>> getFreeAppointments(@PathVariable int companyId,
			@PathVariable String date) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

		LocalDate localDate = LocalDate.parse(date, formatter);
		List<Appointment> appointements = appointmentService.getAllFreeAppointmentsForDate(companyId, localDate);

		List<FreeAppointmentDTO> appointmentsDTO = appointements.stream().map(FreeAppointmentDTO::new)
				.collect(Collectors.toList());

		return new ResponseEntity<>(appointmentsDTO, HttpStatus.OK);
	}
	
	@PostMapping(value = "/create")
    public ResponseEntity<FreeAppointmentDTO> createAppointment(@RequestBody FreeAppointmentDTO dto) {

        Appointment newAppointment = appointmentService.createAppointment(dto);
        FreeAppointmentDTO dtoCreated = new FreeAppointmentDTO(newAppointment);

        return new ResponseEntity<>(dtoCreated, HttpStatus.CREATED);
    }

}
