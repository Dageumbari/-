package com.bit.model.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bit.model.dao.MainDAO;
import com.bit.model.dto.UserDTO;
import com.bit.model.service.UserService;
import com.bit.security.SendEmail;

import lombok.extern.java.Log;

@Log
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private MainDAO mainDAO;

	@Autowired
	private PasswordEncoder pwEncoder;
	
	@Autowired
	SendEmail sendEmail;
	
	@Transactional
	@Override
	public String join(UserDTO userDTO) { // 회원가입 service
		String joinCheck = mainDAO.getJoinCheck(userDTO.getEmail());
		log.info("\n ==== joinCheck ======= \n");

		if (joinCheck == null) { // 유저 중복 체크
			log.info("\n ==== null ======= \n");

			userDTO.setKey(sendEmail.getKey()); // 키 생성후 유저 정보에 입력
			userDTO.setPw(pwEncoder.encode(userDTO.getPw())); // 입력받은 유저의 비밀번호 인코딩

			mainDAO.setUserInfo(userDTO); // 유저 등록
			log.info("\n ==== setUserInfo ======= \n");

			sendEmail.email(userDTO.getEmail(), userDTO.getName(), userDTO.getKey()); // 가입시 입력한 정보로 이메일 전송
			log.info("\n ==== email ======= \n");
			
			return null;
		} else {
			log.info("\n ==== not null ======= \n");
			
			
			return "notNull";
		}

	}

}
