package com.example.ISAproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ISAproject.model.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {
	 List<Reservation> findByUser_id(int userId);
	 Reservation findByUser_idAndAppointment_id(int userId, int appointmentId);
	 
}
