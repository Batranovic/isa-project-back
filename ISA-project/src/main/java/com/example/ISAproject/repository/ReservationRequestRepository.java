package com.example.ISAproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ISAproject.model.ReservationRequest;

public interface ReservationRequestRepository extends JpaRepository<ReservationRequest, Integer>{
	  List<ReservationRequest> findByReservation_id(Integer reservationId);
}
