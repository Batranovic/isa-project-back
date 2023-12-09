package com.example.ISAproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.example.ISAproject.dto.RegistrationDTO;
import com.example.ISAproject.model.User;


@Service
public class EmailService {

	@Autowired
	private JavaMailSender javaMailSender;
	
	@Autowired
	private Environment env;
	
	
	@Async
	public void sendNotificaitionAsync(RegistrationDTO registrationDto) throws MailException, InterruptedException {
	//Simulacija duze aktivnosti da bi se uocila razlika
		Thread.sleep(10000);
		System.out.println("Slanje emaila...");
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(registrationDto.getEmail());
		mail.setFrom(env.getProperty("spring.mail.username"));
		mail.setSubject("Primer slanja emaila pomoću asinhronog Spring taska");
		mail.setText("Pozdrav " + registrationDto.getName() + ",\n\nhvala što pratiš ISA. http://localhost:4200/activation-link/"+registrationDto.getId());
		javaMailSender.send(mail);
		

		System.out.println("Email poslat!");
		
	}

}
