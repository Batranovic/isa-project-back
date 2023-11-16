package com.example.ISAproject.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ISAproject.dto.RegistrationDTO;
import com.example.ISAproject.dto.UserDto;
import com.example.ISAproject.model.User;
import com.example.ISAproject.service.UserService;

@RestController
@RequestMapping(value = "api/users")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<UserDto> getUser(@PathVariable Integer id) {

		User user = userService.findOne(id);

		if (user == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<UserDto>(new UserDto(user), HttpStatus.OK);
	}
	
	@GetMapping(value = "/all")
	public ResponseEntity<List<UserDto>> getAllUsers() {

		List<User> users = userService.findAll();

		List<UserDto> usersDTO = new ArrayList<>();
		for (User u : users) {
			usersDTO.add(new UserDto(u));
		}

		return new ResponseEntity<>(usersDTO, HttpStatus.OK);
	}
	
	@PostMapping(consumes = "application/json")
	public ResponseEntity<UserDto> saveUser(@RequestBody UserDto userDTO) {

		User user = new User();
		user.setName(userDTO.getName());
		user.setSurname(userDTO.getName());
		user.setEmail(userDTO.getEmail());
		user.setCity(userDTO.getCity());
		user.setCountry(userDTO.getCountry());
		user.setPhoneNumber(userDTO.getPhoneNumber());
		user.setProfession(userDTO.getProfession());
		user.setCompanyInformation(userDTO.getCompanyInformation());
		
		user = userService.save(user);
		return new ResponseEntity<>(new UserDto(user), HttpStatus.CREATED);
	}
	
	@PostMapping(value = "/create", consumes = "application/json")
	public ResponseEntity<RegistrationDTO> createUser(@RequestBody RegistrationDTO registrationDTO) {

	    // Check if passwords match
	    if (!registrationDTO.getPassword().equals(registrationDTO.getConfirmPassword())) {
	        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	    }

	    User user = new User();
	    user.setName(registrationDTO.getName());
	    user.setSurname(registrationDTO.getSurname());
	    user.setEmail(registrationDTO.getEmail());
	    user.setPassword(registrationDTO.getPassword());
	    user.setCity(registrationDTO.getCity());
	    user.setCountry(registrationDTO.getCountry());
	    user.setPhoneNumber(registrationDTO.getPhoneNumber());
	    user.setProfession(registrationDTO.getProfession());
	    user.setCompanyInformation(registrationDTO.getCompanyInformation());

	    user = userService.save(user); 
	    return new ResponseEntity<>(new RegistrationDTO(user), HttpStatus.CREATED);
	}

}
