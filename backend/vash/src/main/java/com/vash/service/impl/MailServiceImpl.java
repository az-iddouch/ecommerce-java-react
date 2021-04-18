package com.vash.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.vash.security.aop.LogExecutionTime;

@Service

public class Mail implements IMailService {

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
}
