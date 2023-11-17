package com.example.ISAproject.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Table(name = "EQUIPMENTS")
public class Equipment {
	
		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int id;
		
		@Column(name = "name", nullable = false)
	    private String name;
		
		@Column(name = "equipment_type", nullable = false)
	    private String equipmentType;
		
		@Column(name = "description", nullable = false)
	    private String description;
		
		@Column(name = "quantity", nullable = false)
	    private int quantity;

	    public Equipment() { }

	    public Equipment(int id, String name, String type, String description, int quantity) {
	        super();
	        this.id = id;
	        this.name = name;
	        this.equipmentType = type;
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

	    public String getType() {
	        return equipmentType;
	    }

	    public void setType(String type) {
	        this.equipmentType = type;
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
