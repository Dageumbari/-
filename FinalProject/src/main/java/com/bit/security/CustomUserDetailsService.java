package com.bit.security;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.bit.model.dao.MainDAO;
import com.bit.model.dto.UserDTO;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;

@Log
@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

	private final MainDAO mainDAO;
	private final MakeGrantedAuthorities makeGrantedAuthorities;
	
	@Override
	public User loadUserByUsername(String username) throws UsernameNotFoundException {// 로그인시 받은 정보로 값 불러오기
		log.info("\n==유저 정보 확인");

		UserDTO userDTO = new UserDTO();
		userDTO = mainDAO.getUserAllInfo(username);

		if (userDTO.getKey().equals("Y")) {
			log.info("\n==이메일 인증 완료");
			
			return new User(userDTO.getEmail(), userDTO.getPw(), makeGrantedAuthorities.getRoles(userDTO.getRoles()));

		} else {
			log.info("\n==이메일 인증 또는 로그인 실패 횟수 초과");
			
			return null;
		}
	}

}
