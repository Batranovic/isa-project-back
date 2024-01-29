package com.example.ISAproject.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ISAproject.dto.FreeAppointmentDTO;
import com.example.ISAproject.enums.AppointmentStatus;
import com.example.ISAproject.enums.ReservationStatus;
import com.example.ISAproject.model.Appointment;
import com.example.ISAproject.model.Company;
import com.example.ISAproject.model.CompanyAdmin;
import com.example.ISAproject.model.Equipment;
import com.example.ISAproject.model.Reservation;
import com.example.ISAproject.model.User;
import com.example.ISAproject.repository.AppointmentRepository;
import com.example.ISAproject.repository.CompanyAdminRepository;
import com.example.ISAproject.repository.ReservationRepository;
import com.example.ISAproject.util.DateUtil;

@Service
public class AppointmentService {
	@Autowired
	private AppointmentRepository appointmentRepository;
	@Autowired
	private CompanyAdminRepository companyAdminRepository;
	@Autowired
	private ReservationRepository reservationRepository;
	
	
	public List<Appointment> getAllFreeAppointmentsForDate(int companyId, LocalDate date) {
		LocalTime companyStartTime = LocalTime.of(8, 0);	
		LocalTime companyEndTime = LocalTime.of(16, 0);	
		
		LocalDateTime iterTime = LocalDateTime.of(date, companyStartTime);
		LocalDateTime iterEndTime = LocalDateTime.of(date, companyEndTime);
		List<CompanyAdmin> admins = companyAdminRepository.findByCompanyId(companyId);
		List<Appointment> apps = new ArrayList<Appointment>();
		while(iterTime.isBefore(iterEndTime)) {
			
			for(CompanyAdmin companyAdmin : admins) {
				if(isAdministratorFreeForDateRange(companyAdmin.getId(), iterTime, iterTime.plusMinutes(60))) {
					Appointment appointment = new Appointment(-1, companyAdmin, iterTime, 60, AppointmentStatus.FREE);
					apps.add(appointment);
					break;
				}
			}
			
			iterTime = iterTime.plusMinutes(60);
		}
		return apps;
	}
	

	private boolean isAdministratorFreeForDateRange(int administratorId, LocalDateTime start, LocalDateTime end) {
		List<Appointment> appointments = appointmentRepository.findByCompanyAdminId(administratorId);
		for(Appointment appointment : appointments) {
			if(DateUtil.dateIntertwine(start, end, appointment.getDateAndTime(), appointment.getDateAndTime().plusMinutes(60))) {
				return false;
			}
		}
		return true;
	}
	
	public Appointment createAppointment(FreeAppointmentDTO dto) {
		
		CompanyAdmin companyAdmin = companyAdminRepository.findById(dto.getCompanyAdminId()).orElse(null);
		if(companyAdmin == null) {
			return null;
		}

        Appointment newAppointment = new Appointment();
        newAppointment.setCompanyAdmin(companyAdmin);
        newAppointment.setDateAndTime(dto.getDateAndTime());
        newAppointment.setDuration(dto.getDuration());
        newAppointment.setStatus(dto.getStatus());

        return appointmentRepository.save(newAppointment);
    }
	
	
	public List<Appointment> getAllReserved(int userId) {
		List<Appointment> appointments = new ArrayList<Appointment>();
	
		for(var r : reservationRepository.findAll()) {
			if(r.getStatus() == ReservationStatus.PENDING && r.getUser().getId() == userId) {
				appointments.add(r.getAppointment());
			}
		}
		
		return appointments;
	}
	
}
