package com.example.ISAproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ISAproject.model.Equipment;

public interface EquipmentRepository extends JpaRepository<Equipment, Integer> {
	List<Equipment> findAllByIdIn(List<Integer> equipmentIds);
}
