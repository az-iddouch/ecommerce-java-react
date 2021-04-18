package com.vash.service;

import com.vash.domaine.ReservationVo;

public interface IMailService {

	void sendEmail(String to,String subject,String text);
	String createMailContent(ReservationVo reservationVo);
	
}
