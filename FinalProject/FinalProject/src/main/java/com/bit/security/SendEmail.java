package com.bit.security;

import java.util.Random;

import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;

public class SendEmail {

	/*
	 * @Autowired private SqlSessionTemplate sqlSession; private UserDaoInterface
	 * userDao;
	 */
	@Autowired
	private JavaMailSender mailSender;
	
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

	public void email(String email, String userName, String key, HttpServletRequest request) {
		
		/*
		 * userDao = sqlSession.getMapper(UserDaoInterface.class);
		 * userDao.GetKey(user_id, key);
		 */
		
		MimeMessage mail = mailSender.createMimeMessage();

		String htmlStr = "<h2>BitBook 회원인증 메일입니다.</h2><br>" 
				+ "<h3>" + userName + "님</h3>"
				+ "<p>인증하기 버튼을 누르시면 로그인을 하실 수 있습니다 : " 
				+ "<a href='http://localhost:80" // + request.getContextPath()	
				+ "/user/key_alter?email=" + email + "&user_key=" + key + "'>인증하기</a></p>"
				+ "회원가입을 시도하지 않으셨다면 무시해주세요";
		try {
			mail.setSubject("BitBook 회원인증 메일입니다.", "UTF-8");
			mail.setText(htmlStr, "UTF-8", "html");
			mail.addRecipient(RecipientType.TO, new InternetAddress(email));
			mailSender.send(mail);
		} catch (MessagingException e) {
			e.printStackTrace();
		}

	}

}
