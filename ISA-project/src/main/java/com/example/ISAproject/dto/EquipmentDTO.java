package com.example.ISAproject.dto;

import com.example.ISAproject.model.Equipment;

public class EquipmentDTO {
	private int id;
	private String name;
	private String equipmentType;
	private String description;
	private int quantity;
	
	public EquipmentDTO() {
		
	}
	
	public EquipmentDTO(Equipment equipment) {
		id = equipment.getId();
		name = equipment.getName();
		equipmentType = equipment.getType();
		description = equipment.getDescription();
		quantity = equipment.getQuantity();
	}

	public EquipmentDTO(int id, String name, String equipmentType, String description, int quantity) {
		super();
		this.id = id;
		this.name = name;
		this.equipmentType = equipmentType;
		this.description = description;
		this.quantity = quantity;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEquipmentType() {
		return equipmentType;
	}

	public void setEquipmentType(String equipmentType) {
		this.equipmentType = equipmentType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
}
