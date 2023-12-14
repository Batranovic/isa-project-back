package com.example.ISAproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ISAproject.model.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {

}
