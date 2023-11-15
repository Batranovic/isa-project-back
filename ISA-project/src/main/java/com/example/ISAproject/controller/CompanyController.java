package com.example.ISAproject.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ISAproject.dto.CompanyDto;
import com.example.ISAproject.dto.CompanySearchDto;
import com.example.ISAproject.model.Company;
import com.example.ISAproject.service.CompanyService;

@RestController
@RequestMapping(value = "api/companies")
public class CompanyController {

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
	
	@GetMapping(value = "/all")
	public ResponseEntity<List<CompanyDto>> getAllCompanies() {

		List<Company> companies = companyService.findAll();

		List<CompanyDto> companiesDTO = new ArrayList<>();
		for (Company c : companies) {
			companiesDTO.add(new CompanyDto(c));
		}

		return new ResponseEntity<>(companiesDTO, HttpStatus.OK);
	}
	
	@PostMapping(consumes = "application/json")
	public ResponseEntity<CompanyDto> saveUser(@RequestBody CompanyDto companyDto) {

		Company company = new Company();
		company.setName(companyDto.getName());
		company.setAddress(companyDto.getAddress());
		company.setDescription(companyDto.getDescription());
		company.setAverageGrade(companyDto.getAverageGrade());
		
		company = companyService.save(company);
		return new ResponseEntity<>(new CompanyDto(company), HttpStatus.CREATED);
	}
	

	@PostMapping(value="/search", consumes = "application/json")
	public ResponseEntity<List<CompanyDto>> searchCompanies(@RequestBody CompanySearchDto companySearchDto) {

		List<Company> searchedCompanies = companyService.search(companySearchDto);
		List<CompanyDto> dtos = new ArrayList<CompanyDto>();
		for(Company company : searchedCompanies) {
			dtos.add(new CompanyDto(company));
		}
		
		return new ResponseEntity<>(dtos, HttpStatus.CREATED);
	}


}
