package com.example.ISAproject.dto;

import com.example.ISAproject.enums.RegisteredUserCategory;
import com.example.ISAproject.model.RegisteredUser;
import com.example.ISAproject.model.User;

public class RegisteredUserDTO {
	private int id;
	private int penalPoints;
	private User user;
	private RegisteredUserCategory userCategory;
	
	
	public RegisteredUserDTO() {
	}
	
	public RegisteredUserDTO(RegisteredUser regUser) {
		id = regUser.getId();
		penalPoints = regUser.getPenalPoints();
		user = regUser.getUser();
		userCategory = regUser.getUserCategory();
	}
	
	public RegisteredUserDTO(int id, int penalPoints, User user, RegisteredUserCategory userCategory) {
		super();
		this.id = id;
		this.penalPoints = penalPoints;
		this.user = user;
		this.userCategory = userCategory;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getPenalPoints() {
		return penalPoints;
	}
	
	public void setPenalPoints(int penalPoints) {
		this.penalPoints = penalPoints;
	}
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
	public RegisteredUserCategory getUserCategory() {
		return userCategory;
	}
	
	public void setUserCategory(RegisteredUserCategory userCategory) {
		this.userCategory = userCategory;
	}
	
	
}
