package com.example.ISAproject.controller;

import java.util.List;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ISAproject.dto.EquipmentDTO;
import com.example.ISAproject.model.Equipment;
import com.example.ISAproject.service.EquipmentService;

@RestController
@RequestMapping(value = "api/equimpents")
@CrossOrigin(origins = "http://localhost:4200")
public class EquipmentController {

	@Autowired
	private EquipmentService equipmentService;
	
	@GetMapping(value = "/all")
	public ResponseEntity<List<EquipmentDTO>> getAllEquipment(){
		
		List<Equipment> equipments = equipmentService.findAll();
		
		List<EquipmentDTO> equipmentsDTO = new ArrayList<>();
		for(Equipment e : equipments) {
			equipmentsDTO.add(new EquipmentDTO(e));
		}
		
		return new ResponseEntity<>(equipmentsDTO, HttpStatus.OK);
	}
}