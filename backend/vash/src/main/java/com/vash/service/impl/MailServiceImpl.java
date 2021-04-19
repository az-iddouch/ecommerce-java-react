package com.vash.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.vash.domaine.ReservationVo;
import com.vash.security.aop.LogExecutionTime;
import com.vash.service.IMailService;
import com.vash.utils.MethodUtils;

@Service

public class MailServiceImpl implements IMailService {

	@Autowired
	private JavaMailSender javaMailSender;

	@Override
	@LogExecutionTime
	public void sendEmail(String to, String subject, String content) {
		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setTo(to);
		msg.setFrom("www.vash.com");
		msg.setSubject(subject);
		msg.setText(content);
		javaMailSender.send(msg);
	}

	@Override
	public String createMailContent(ReservationVo reservationVo) {
		return new StringBuilder("Bonjour Mr/Mme/Mlle.").append(reservationVo.getProperty().getUser().getLastName())
				.append("\nVous venez d'avoir une reservation pour votre ")
				.append(reservationVo.getProperty().getTypeProperty().getType())
				.append("[" + reservationVo.getProperty().getCity().getNameCity() + " / "
						+ reservationVo.getProperty().getAddress() + "] , ")
				.append("du " + MethodUtils.parseDateInLocalDate(reservationVo.getDateStart(), "yyyy-MM-dd")
						+ " jusqu'à " + MethodUtils.parseDateInLocalDate(reservationVo.getDateEnd(), "yyyy-MM-dd"))
				.append(" pour " + reservationVo.getNumberPersons() + " personnes")
				.append(" de la part de Mr/Mme/Mlle " + reservationVo.getUser().getLastName() + " "
						+ reservationVo.getUser().getFirstName() + " qui sera joignable sur son email : "
						+ reservationVo.getUser().getEmail() + " ou bien son numero de téléphone : "
						+ reservationVo.getUser().getPhoneNumber1())
				.append("\n\n" + "Cordialement," + "\n VASH").toString();
	}
}
