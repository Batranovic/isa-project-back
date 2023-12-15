package com.example.ISAproject.service;

import java.util.Set;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ISAproject.dto.AppointmentDTO;
import com.example.ISAproject.dto.EquipmentDTO;
import com.example.ISAproject.dto.RegistrationDTO;
import com.example.ISAproject.dto.ReservationDTO;
import com.example.ISAproject.enums.AppointmentStatus;
import com.example.ISAproject.enums.ReservationStatus;
import com.example.ISAproject.model.Reservation;
import com.example.ISAproject.model.User;
import com.example.ISAproject.model.Equipment;
import com.example.ISAproject.model.Appointment;
import com.example.ISAproject.repository.AppointmentRepository;
import com.example.ISAproject.repository.EquipmentRepository;
import com.example.ISAproject.repository.ReservationRepository;
import com.example.ISAproject.repository.UserRepository;
@Service
public class ReservationService {

	
	@Autowired
	private ReservationRepository reservationRepository;
	
	@Autowired
	private AppointmentRepository appointmentRepository;
	
	@Autowired
	private EquipmentRepository equipmentRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	public Reservation createReservation( int appointmentId, int equipmentId, int userId) {
		
		Appointment appointment = appointmentRepository.findById(appointmentId).orElse(null);
		if (appointment.getStatus() == AppointmentStatus.OCCUPIED){
			return null;
		}
		appointment.setStatus(AppointmentStatus.OCCUPIED);
		appointmentRepository.save(appointment);
		Equipment equipment = equipmentRepository.findById(equipmentId).orElse(null);
		
		if(appointment == null) {
			return null;
		}
		if(equipment == null) {
			return null;
		}
		
		Reservation reservation = new Reservation();
		
		reservation.setStatus(ReservationStatus.PENDING);
		reservation.setAppointment(appointment);
		
		
		 Set<Equipment> equipments = new HashSet<>();
		    equipments.add(equipment);
		    reservation.setEquipments(equipments);
		    
		 User user = userRepository.findById(userId).orElse(null);
		 reservation.setUser(user);
		return this.reservationRepository.save(reservation);
		
		
	}
	
}
