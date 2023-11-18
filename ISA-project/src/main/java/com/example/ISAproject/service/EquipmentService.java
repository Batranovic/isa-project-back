package com.example.ISAproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ISAproject.model.Equipment;
import com.example.ISAproject.repository.EquipmentRepository;

@Service
public class EquipmentService {
	
	@Autowired
	private EquipmentRepository equipmentRepository;
	
	public List<Equipment> findAll(){
		return equipmentRepository.findAll();
	}
	

}
