package com.example.ISAproject.service;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Set;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import com.example.ISAproject.model.Equipment;
import com.example.ISAproject.model.Reservation;
import com.example.ISAproject.model.User;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private Environment env;

    public EmailService(JavaMailSender javaMailSender, Environment env) {
        this.javaMailSender = javaMailSender;
        this.env = env;
    }

    @Async
    public void sendNotificaitionAsync(User user) throws MailException, InterruptedException {
        // Simulacija duže aktivnosti da bi se uočila razlika
        Thread.sleep(1000);
        System.out.println("Slanje emaila...");
        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo(user.getEmail());
        mail.setFrom(env.getProperty("spring.mail.username"));
        mail.setSubject("Registruj se");
        mail.setText("Pozdrav " + user.getName() + ",\n\nhvala što pratiš ISA. http://localhost:4200/activation-link/" + user.getId());
        javaMailSender.send(mail);

        System.out.println("Email poslat!");
    }

    @Async
    public void sendQRCode(User user, Reservation reservation) throws MailException, InterruptedException {
        try {
            String qrCodeData = generateQRCodeData(reservation);

            String qrCodeImagePath = generateAndSaveQRCode(qrCodeData, reservation.getId());

            
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();

            
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
            helper.setTo(user.getEmail());
            helper.setFrom(env.getProperty("spring.mail.username"));
            helper.setSubject("Vasa rezervacija");

            
            String htmlBody = "Pozdrav " + user.getName() + ",<br><br>"
                    + "Uspesno ste rezervisali opremu! Pogledajte QR kod ispod:<br>"
                    + "<img src='cid:qrcode'/><br><br>" // koristi CID za ugradnju slike

                    + "Hvala na rezervaciji!";

            helper.setText(htmlBody, true);

            helper.addInline("qrcode", new FileSystemResource(new File(qrCodeImagePath)));

            // Send the email
            javaMailSender.send(mimeMessage);

            System.out.println("Email poslat!");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    public static String generateQRCodeData(Reservation reservation) {
        StringBuilder qrCodeData = new StringBuilder();
        qrCodeData.append("User:").append(reservation.getUser().getName()).append(" | ");
        qrCodeData.append("Company Admin:").append(reservation.getAppointment().getCompanyAdmin().getUser().getName()).append(" | ");
        qrCodeData.append("Date of appointment: ").append(reservation.getAppointment().getDateAndTime()).append(" | ");
        qrCodeData.append("Company: ").append(reservation.getAppointment().getCompanyAdmin().getCompany().getName()).append(" | ");
        Set<Equipment> equipments = reservation.getEquipments();
        for (Equipment equipment : equipments) {
            qrCodeData.append("Equipment Name: ").append(equipment.getName()).append(" | ");
        }
        return qrCodeData.toString();
    }

    private String generateAndSaveQRCode(String qrCodeData, int reservationId) {
        try {
            // Generate QR code
            QRCodeWriter qrCodeWriter = new QRCodeWriter();
            BitMatrix bitMatrix = qrCodeWriter.encode(qrCodeData, BarcodeFormat.QR_CODE, 300, 300);

            // Create a directory path for storing QR codes
            String directoryPath = "src/main/java/QR_codes/";

            // Create a unique filename using the reservation ID and a timestamp
            String timestamp = String.valueOf(System.currentTimeMillis());
            String qrCodeImageName = "qrcode_" + reservationId + "_" + timestamp + ".png";

            // Create the full path to the QR code image
            String qrCodeImagePath = directoryPath + qrCodeImageName;

            // Save the QR code on the server
            Path path = Paths.get(qrCodeImagePath);
            MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);

            return qrCodeImagePath;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
