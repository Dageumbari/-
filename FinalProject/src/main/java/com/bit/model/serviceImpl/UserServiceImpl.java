package com.bit.model.serviceImpl;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

import com.bit.model.dao.MainDAO;
import com.bit.model.dto.UserDTO;
import com.bit.model.service.UserService;
import com.bit.security.SendEmail;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;

@Log
@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

	private final MainDAO mainDAO;
	private final PasswordEncoder pwEncoder;
	private final SendEmail sendEmail;

	@Override
	public ModelAndView join(UserDTO userDTO) { // 회원가입 service
		log.info("\n==UserServiceImpl=join : " + userDTO.toString());

		ModelAndView modelAndView = new ModelAndView();

		if (mainDAO.getJoinCheck(userDTO.getEmail()) == null) { // 유저 중복 체크
			log.info("\n==null");
			
			userDTO.getRoles().get(0).setRoleName("MEMBER"); // 바뀔 수 있는 정보 체크.
			userDTO.setKey(sendEmail.getKey()); // 키 생성후 유저 정보에 입력
			userDTO.setPw(pwEncoder.encode(userDTO.getPw())); // 입력받은 유저의 비밀번호 인코딩

			log.info("\n==setUserInfo");
			mainDAO.setUserInfo(userDTO); // 유저 등록

			log.info("\n==email");
			sendEmail.joinEmail(userDTO.getEmail(), userDTO.getName(), userDTO.getKey()); // 가입시 입력한 정보로 이메일 전송

			modelAndView.addObject("email", userDTO.getEmail());
			modelAndView.setViewName("/main/joinResult");

			return modelAndView;

		} else {
			log.info("\n==not null");

			String errorMsg = "존재하는 유저입니다";
			String url = "/main/join";

			modelAndView.addObject("errorMsg", errorMsg);
			modelAndView.setViewName(url);

			return modelAndView;
		}
	}

	@Override
	public ModelAndView adminjoin(UserDTO userDTO, String superAdminEmail) {
		
		ModelAndView modelAndView = new ModelAndView();
		
		if (mainDAO.getJoinCheck(userDTO.getEmail()) == null) { // 유저 중복 체크
			log.info("\n==UserServiceImpl=adminjoin");
						
			userDTO.getRoles().get(0).setRoleName("MEMBER");
			userDTO.getRoles().get(1).setRoleName("ADMIN");
			userDTO.setKey(sendEmail.getKey()); // 키 생성
			userDTO.setPw(pwEncoder.encode(userDTO.getKey())); // 키를 암호로 입력

			log.info("\n==setAdminInfo");
			mainDAO.setAdminInfo(userDTO); 

			log.info("\n==superAdminEmail");
			sendEmail.joinEmail(superAdminEmail, userDTO.getName(), userDTO.getKey()); // admin 이메일로 해당 정보 전송

			modelAndView.addObject("email", superAdminEmail);
			modelAndView.setViewName("/main/joinResult");

			return modelAndView;

		} else {
			log.info("\n==not null");

			String errorMsg = "존재하는 유저입니다";
			String url = "main/adminjoin";

			modelAndView.addObject("errorMsg", errorMsg);
			modelAndView.setViewName(url);

			return modelAndView;
		}
	}

	@Override
	public void forgot(String email) {
		log.info("\n==UserServiceImpl=forgot");
		String name = mainDAO.getJoinCheck(email);
		if (name == null) {

		} else {
			String key = sendEmail.getKey();

			mainDAO.setForgotPassword(pwEncoder.encode(key), email);

			sendEmail.forgotEmail(email, name, key);
		}

	}

}
