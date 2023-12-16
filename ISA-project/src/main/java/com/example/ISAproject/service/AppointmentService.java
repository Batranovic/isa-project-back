package com.example.ISAproject.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ISAproject.model.Appointment;
import com.example.ISAproject.model.User;
import com.example.ISAproject.repository.AppointmentRepository;
import com.example.ISAproject.repository.UserRepository;
import com.example.ISAproject.util.DateUtil;

@Service
public class AppointmentService {
	@Autowired
	private AppointmentRepository appointmentRepository;
	@Autowired
	private UserRepository userRepository;
	public List<Appointment> getAllFreeAppointmentsForDate(LocalDate date) {
		LocalTime companyStartTime = LocalTime.of(8, 0);	
		LocalTime companyEndTime = LocalTime.of(16, 0);	
		
		LocalDateTime iterTime = LocalDateTime.of(date, companyStartTime);
		LocalDateTime iterEndTime = LocalDateTime.of(date, companyEndTime);
		List<User> admins = getAllCompanieAdministrators();
		List<Appointment> apps = new ArrayList<Appointment>();
		while(iterTime.isBefore(iterEndTime)) {
			
			for(User user : admins) {
				if(isAdministratorFreeForDateRange(user.getId(), iterTime, iterTime.plusMinutes(60))) {
					
					break;
				}
			}
			
			iterTime = iterTime.plusMinutes(60);
		}
		return null;
	}
	
	private List<User> getAllCompanieAdministrators(){
		List<User> users = userRepository.findAll();
		List<User> admins = new ArrayList<User>();
		for(User user : users) {
			if(user.getRoles().get(0).getName().equals("")) {
				admins.add(user);
			}
		}
		return admins;
	}
	
	private boolean isAdministratorFreeForDateRange(int administratorId, LocalDateTime start, LocalDateTime end) {
		List<Appointment> appointments = appointmentRepository.findByAdminId(administratorId);
		List<Appointment> filterAppointment = new ArrayList<Appointment>();
		for(Appointment appointment : appointments) {
			if(DateUtil.dateIntertwine(start, end, appointment.getDateAndTime(), appointment.getDateAndTime().plusMinutes(60))) {
				return false;
			}
		}
		return true;
	}
	
	
	
}
