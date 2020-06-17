package com.bit.security;

import java.util.Random;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class SendEmail {

	@Autowired
	private JavaMailSender javaMailSender;
	
	public String getKey() {
		return keyGeneration();
	}
	
	private String keyGeneration() { // 난수 키값 생성
		Random random = new Random();
		StringBuffer stringBuffer = new StringBuffer();
		int num = 0;
		int size = 10;

		do {
			num = random.nextInt(75) + 48;
			if ((num >= 48 && num <= 57) || (num >= 65 && num <= 90) || (num >= 97 && num <= 122)) {
				stringBuffer.append((char) num);
			} else {
				continue;
			}

		} while (stringBuffer.length() < size);

		return stringBuffer.toString();
	}

	public void email(String email, String userName, String key)  {
		
		
		
		
		String htmlStr = "<h2>BitBook 회원인증 메일입니다.</h2><br>" 
				+ "<h3>" + userName + "님</h3>"
				+ "<p>인증하기 버튼을 누르시면 로그인을 하실 수 있습니다 : " 
				+ "<a href='http://localhost:80" // + request.getContextPath()	
				+ "/user/key_alter?email=" + email + "&user_key=" + key + "'>인증하기</a></p>"
				+ "회원가입을 시도하지 않으셨다면 무시해주세요";
		
		
		try {
			MimeMessage message = javaMailSender.createMimeMessage();
			MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8");
			
			messageHelper.setTo(email);
			messageHelper.setFrom("Bitbook");
			messageHelper.setSubject("BitBook 회원인증 메일입니다.");
			messageHelper.setText(htmlStr);
			
			javaMailSender.send(message);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
