package com.example.ISAproject.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ISAproject.dto.CompanySearchDto;
import com.example.ISAproject.dto.EquipmentDTO;
import com.example.ISAproject.enums.AppointmentStatus;
import com.example.ISAproject.model.Appointment;
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
		if(searchDto.getAverageGradeFrom() == 0) {
			return companyRepository.findByNameContainingAndAddressContaining(searchDto.getName(), searchDto.getAddress());
		}
		return companyRepository.findByNameContainingAndAddressContainingAndAverageGradeBetween(searchDto.getName(), searchDto.getAddress(), searchDto.getAverageGradeFrom(), searchDto.getAverageGradeTo());
		
	}
	public Set<Equipment> getEquipmentsForCompany(int companyId) {
        Company company = companyRepository.findById(companyId).orElse(null);

        if (company == null) {
            return Collections.emptySet();
        }

        return company.getEquipments();
    }
	
	public Set<Appointment> getAppointmentsForCompany(int companyId) {
	    Company company = companyRepository.findById(companyId).orElse(null);

	    if (company == null) {
	        return Collections.emptySet();
	    }

	    // Filter appointments by status (in this case, "free")
	    Set<Appointment> freeAppointments = new HashSet<>();
	    for (Appointment appointment : company.getAppointments()) {
	        if (appointment.getStatus() == AppointmentStatus.FREE) {
	            freeAppointments.add(appointment);
	        }
	    }

	    return freeAppointments;
	}
	
}
