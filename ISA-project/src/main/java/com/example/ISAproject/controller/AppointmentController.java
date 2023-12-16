package com.example.ISAproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ISAproject.dto.CompanyDto;
import com.example.ISAproject.model.Company;
import com.example.ISAproject.service.CompanyService;

@RestController
@RequestMapping(value = "api/companies")
@CrossOrigin(origins = "http://localhost:4200")
public class AppointmentController {

	@Autowired
	private CompanyService companyService;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<CompanyDto> getCompany(@PathVariable Integer id) {

		Company company = companyService.findOne(id);

		if (company == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(new CompanyDto(company), HttpStatus.OK);
	}
}
