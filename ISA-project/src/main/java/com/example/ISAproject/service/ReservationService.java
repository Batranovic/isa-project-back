package com.example.ISAproject.service;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.HashSet;
import java.util.List;
import java.time.LocalDateTime;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.ISAproject.dto.AppointmentDTO;
import com.example.ISAproject.dto.EquipmentDTO;
import com.example.ISAproject.dto.RegistrationDTO;
import com.example.ISAproject.dto.ReservationDTO;
import com.example.ISAproject.dto.ViewReservationDTO;
import com.example.ISAproject.dto.UserDto;
import com.example.ISAproject.enums.AppointmentStatus;
import com.example.ISAproject.enums.ReservationStatus;
import com.example.ISAproject.model.Reservation;
import com.example.ISAproject.model.User;
import com.example.ISAproject.model.Equipment;
import com.example.ISAproject.model.RegisteredUser;
import com.example.ISAproject.model.Appointment;
import com.example.ISAproject.repository.AppointmentRepository;
import com.example.ISAproject.repository.EquipmentRepository;
import com.example.ISAproject.repository.RegisteredUserRepository;
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
	
	@Autowired
	private RegisteredUserRepository registeredUserRepository;	
	
	public Reservation findOne(Integer id) {
		return reservationRepository.findById(id).orElseGet(null);
	}
	
	public Reservation createReservation(int appointmentId, List<Integer> equipmentIds, int userId) {
		 Reservation existingReservation = reservationRepository.findByUser_idAndAppointment_id(userId, appointmentId);
		   
		    if (existingReservation != null) {
		        return null;
		    }
		 List<Equipment> equipments = equipmentRepository.findAllById(equipmentIds);
		    
		 if (equipments.isEmpty()) {
		        return null;
		 }
		    
	    for (Equipment equipment : equipments) {
	        if (equipment.getQuantity() == equipment.getReservedQuantity()) {
	            return null;
	        }else {
		        equipment.setReservedQuantity(equipment.getReservedQuantity() + 1);
		        equipmentRepository.save(equipment);
	        }
	    }

	    Appointment appointment = appointmentRepository.findById(appointmentId).orElse(null);
	    if (appointment == null || appointment.getStatus() == AppointmentStatus.OCCUPIED) {
	        return null;
	    }

	    appointment.setStatus(AppointmentStatus.OCCUPIED);
	    appointmentRepository.save(appointment);

	    Reservation reservation = new Reservation();
	    reservation.setStatus(ReservationStatus.PENDING);
	    reservation.setAppointment(appointment);
	    reservation.setEquipments(new HashSet<>(equipments));

	    User user = userRepository.findById(userId).orElse(null);
	    if (user == null) {
	        return null;
	    }

	    reservation.setUser(user);

	    return reservationRepository.save(reservation);
	}
	
	public List<ViewReservationDTO> getReservationsForUser(int userId) {
	    List<Reservation> reservations = reservationRepository.findByUser_id(userId);
	    List<ViewReservationDTO> viewReservations = new ArrayList<>();

	    for (Reservation reservation : reservations) {
	    	ViewReservationDTO viewReservation = new ViewReservationDTO();
	        viewReservation.setId(reservation.getId());
	        viewReservation.setStatus(reservation.getStatus());

	        AppointmentDTO appointmentDTO = new AppointmentDTO(reservation.getAppointment());
	        viewReservation.setAppointment(appointmentDTO);
	        viewReservations.add(viewReservation);
	    }

	    return viewReservations;
	}
	
	@Transactional
	public void cancelReservation(int reservationId,int userId) {
		RegisteredUser registeredUser = registeredUserRepository.getById(userId);
		Reservation reservation = findOne(reservationId);
		
		if(reservation == null || registeredUser == null  ) {
			return;
		}
		
        LocalDateTime currentDateTime = LocalDateTime.now();
        LocalDateTime reservationDateTime = reservation.getAppointment().getDateAndTime();

        if (currentDateTime.isAfter(reservationDateTime.minusHours(24))) {
        	registeredUser.setPenalPoints(registeredUser.getPenalPoints() - 2);
        }else {
           registeredUser.setPenalPoints(registeredUser.getPenalPoints() - 1);
        }
        
        for (Equipment equipment : reservation.getEquipments()) {
	        equipment.setReservedQuantity(equipment.getReservedQuantity() - 1);
	        equipmentRepository.save(equipment);
	    }
        
        reservation.getAppointment().setStatus(AppointmentStatus.FREE);
        reservation.setStatus(ReservationStatus.CANCELED);
        reservationRepository.save(reservation);
        registeredUserRepository.save(registeredUser);
		
	}



	
}
