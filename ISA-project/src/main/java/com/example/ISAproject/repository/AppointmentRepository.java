package com.example.ISAproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ISAproject.model.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {
}
