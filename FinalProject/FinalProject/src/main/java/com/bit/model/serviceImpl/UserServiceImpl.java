package com.bit.model.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bit.model.dao.MainDAO;
import com.bit.model.dto.UserDTO;
import com.bit.model.service.UserService;
import com.bit.security.SendEmail;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private MainDAO mainDAO;

	@Autowired
	private PasswordEncoder pwEncoder;

	
	@Transactional
	@Override
	public void join(UserDTO userDTO) { // 회원가입 service

		if (mainDAO.getJoinCheck(userDTO.getEmail()) != null) { // 유저 중복 체크
			SendEmail sendEmail = new SendEmail(); // 이메일 발송 객체 생성
			
			userDTO.setKey(sendEmail.getKey()); // 인증받을 키 생성
			userDTO.setPw(pwEncoder.encode(userDTO.getPw())); // 입력받은 유저의 비밀번호 인코딩

			mainDAO.setUserInfo(userDTO); // 유저 등록
			
			sendEmail.email(e_mail, user_id, key, request);
		}

	}

}
