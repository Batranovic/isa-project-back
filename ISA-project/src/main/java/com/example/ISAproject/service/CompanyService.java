package com.example.ISAproject.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ISAproject.dto.CompanySearchDto;
import com.example.ISAproject.dto.EquipmentDTO;
import com.example.ISAproject.model.Company;
import com.example.ISAproject.repository.CompanyRepository;
import com.example.ISAproject.model.Equipment;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CompanyService {

	@Autowired
	private CompanyRepository companyRepository;

	public Company findOne(Integer id) {
		return companyRepository.findById(id).orElseGet(null);
	}

	public List<Company> findAll() {
		return companyRepository.findAll();
	}

	public Company save(Company company) {
		return companyRepository.save(company);
	}

	public List<Company> search(CompanySearchDto searchDto) {


		List<Company> companies = companyRepository.findAll();
		List<Company> searchedCompanies = new ArrayList<Company>();
		for (Company company : companies) {
			if (company.getName().contains(searchDto.getName()) && company.getAddress().contains(searchDto.getAddress())
					&& (searchDto.getAverageGradeFrom() == 0 || company.getAverageGrade() >= searchDto.getAverageGradeFrom())
					&& (searchDto.getAverageGradeTo() == 0 || company.getAverageGrade() <= searchDto.getAverageGradeTo())) {
				searchedCompanies.add(company);
			}
		}
		return searchedCompanies;
	}
	public Set<Equipment> getEquipmentsForCompany(int companyId) {
        Company company = companyRepository.findById(companyId).orElse(null);

        if (company == null) {
            return Collections.emptySet();
        }

        return company.getEquipments();
    }
	
}
