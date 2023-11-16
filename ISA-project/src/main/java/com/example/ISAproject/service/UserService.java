package com.example.ISAproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ISAproject.dto.UserDto;
import com.example.ISAproject.model.User;
import com.example.ISAproject.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public User findOne(Integer id) {
		return userRepository.findById(id).orElseGet(null);
	}
	
	public List<User> findAll() {
		return userRepository.findAll();
	}
	
	public User update(UserDto dto) {
		User user = findOne(dto.getId());
		if(user == null) {
			return null;
		}
		user.setName(dto.getName());
		user.setSurname(dto.getSurname());
		user.setCity(dto.getCity());
		user.setCountry(dto.getCountry());
		user.setPhoneNumber(dto.getPhoneNumber());
		user.setProfession(dto.getProfession());
		user.setCompanyInformation(dto.getCompanyInformation());
		userRepository.save(user);
		
		return user;
	}
	
	public User save(User user) {
		return userRepository.save(user);
	}
}
