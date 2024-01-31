package com.example.ISAproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ISAproject.repository.RegisteredUserRepository;

import com.example.ISAproject.model.RegisteredUser;
@Service
public class RegisteredUserService {
	@Autowired
	private RegisteredUserRepository registeredUserRepository;	
	
	
	 public void resetPenalties(List<RegisteredUser> users) {
	        for (RegisteredUser user : users) {
	            user.setPenalPoints(0);
	        }
	        registeredUserRepository.saveAll(users);
	    }
	 
	 public List<RegisteredUser> findAll() {
			return registeredUserRepository.findAll();
		}
}
