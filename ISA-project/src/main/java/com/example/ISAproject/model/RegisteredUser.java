package com.example.ISAproject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.example.ISAproject.enums.RegisteredUserCategory;

@Entity
@Table(name = "REGISTERED_USER")
public class RegisteredUser {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "penal_points")
	private int penalPoints;
	
	@OneToOne
	@MapsId
	@JoinColumn(name="user_id")
	private User user;
	
	@Column(name="user_category")
	private RegisteredUserCategory userCategory;

	public RegisteredUser() {
		super();
	}
	
	public RegisteredUser(int id, int penalPoints, User user, RegisteredUserCategory userCategory) {
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
