package com.example.ISAproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.ISAproject.dto.RegistrationDTO;
import com.example.ISAproject.dto.UserDto;
import com.example.ISAproject.model.User;
import com.example.ISAproject.repository.UserRepository;

import com.example.ISAproject.model.Role;


@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private RoleService roleService;
	
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
		user.setPassword(dto.getPassword());
		user.setCity(dto.getCity());
		user.setCountry(dto.getCountry());
		user.setPhoneNumber(dto.getPhoneNumber());
		user.setProfession(dto.getProfession());
		user.setCompanyInformation(dto.getCompanyInformation());
		userRepository.save(user);
		
		return user;
	}
	
	public User save(RegistrationDTO registrationDto) {
		User u = new User();
		u.setEmail(registrationDto.getEmail());
		
		// pre nego sto postavimo lozinku u atribut hesiramo je kako bi se u bazi nalazila hesirana lozinka
		// treba voditi racuna da se koristi isi password encoder bean koji je postavljen u AUthenticationManager-u kako bi koristili isti algoritam
		u.setPassword(passwordEncoder.encode(registrationDto.getPassword()));
		u.setName(registrationDto.getName());
		u.setSurname(registrationDto.getSurname());
		u.setIsActive(false);
		u.setEmail(registrationDto.getEmail());
		u.setCity(registrationDto.getCity());
		u.setCountry(registrationDto.getCountry());
		u.setPhoneNumber(registrationDto.getPhoneNumber());
		u.setProfession(registrationDto.getProfession());
		u.setCompanyInformation(registrationDto.getCompanyInformation());
		List<Role> roles = roleService.findByName("ROLE_USER");
		u.setRoles(roles);
		
		return this.userRepository.save(u);
	}
	
	
	public User updateIsActive(int id) {
		User user = findOne(id);
		user.setIsActive(true);
		return user;
	}
	
	public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
	
	public User activateUser(int id) {
		User user = userRepository.findById(id).orElseGet(null);
		user.setIsActive(true);
		return this.userRepository.save(user);
	}

		
	

	
	
}
