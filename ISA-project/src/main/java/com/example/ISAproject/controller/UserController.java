package com.example.ISAproject.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ISAproject.dto.RegistrationDTO;
import com.example.ISAproject.dto.UserDto;
import com.example.ISAproject.model.User;
import com.example.ISAproject.service.EmailService;
import com.example.ISAproject.service.UserService;

@RestController
@RequestMapping(value = "api/users")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
	
	private Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private EmailService emailService;
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
	public ResponseEntity<UserDto> saveUser(@RequestBody RegistrationDTO registrationDTO) {
		/*
		User user = new User();
		user.setName(registrationDTO.getName());
		user.setSurname(registrationDTO.getName());
		user.setPassword(registrationDTO.getPassword());
		user.setEmail(registrationDTO.getEmail());
		user.setCity(registrationDTO.getCity());
		user.setCountry(registrationDTO.getCountry());
		user.setPhoneNumber(registrationDTO.getPhoneNumber());
		user.setProfession(registrationDTO.getProfession());
		user.setCompanyInformation(registrationDTO.getCompanyInformation());
		*/
		
		userService.save(registrationDTO);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@PutMapping(value = "/{id}",consumes = "application/json")
	public ResponseEntity<UserDto> updateUser(@PathVariable Integer id, @RequestBody UserDto userDTO) {

		if(id != userDTO.getId()) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
		
		User user = userService.update(userDTO);
		if(user == null) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
		UserDto dto = new UserDto(user);
		return new ResponseEntity<>(dto, HttpStatus.CREATED);
	}
	@PostMapping(value = "/create", consumes = "application/json")
	public ResponseEntity<RegistrationDTO> createUser(@RequestBody RegistrationDTO registrationDTO) {

	    // Check if passwords match
	    if (!registrationDTO.getPassword().equals(registrationDTO.getConfirmPassword())) {
	        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	    }
	    
	    if (userService.findByEmail(registrationDTO.getEmail()) != null) {
	        return new ResponseEntity<>(HttpStatus.CONFLICT); 
	    }

	    /*
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
	    user.setIsActive(false);
	     */
	    
	    User user = userService.save(registrationDTO);
		//slanje emaila
		try {
			System.out.println("Thread id: " + Thread.currentThread().getId());
			emailService.sendNotificaitionAsync(user);
		}catch( Exception e ){
			logger.info("Greska prilikom slanja emaila: " + e.getMessage());
		}
		
	    return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	 @PostMapping(value = "/activate/{id}")
	    public ResponseEntity<UserDto> activateUser(@PathVariable Integer id) {
	        userService.activateUser(id);
	        return new ResponseEntity<>(HttpStatus.OK);
	    }

	 @GetMapping("/getByEmail/{email}")
	    public User user(@PathVariable String email) {
	        return this.userService.findByEmail(email);
	    }
}
