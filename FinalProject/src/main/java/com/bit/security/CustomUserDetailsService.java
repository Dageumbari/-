package com.bit.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.bit.model.dao.MainDAO;
import com.bit.model.dto.UserDTO;
import com.bit.model.vo.UserRoleVO;

import lombok.extern.java.Log;

@Log
@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	MainDAO mainDAO;

	private List<GrantedAuthority> makeGrantedAuthorities(List<UserRoleVO> roles) {
		List<GrantedAuthority> list = new ArrayList<>();

		roles.forEach(role -> list.add(new SimpleGrantedAuthority("ROLE_" + role.getRoleName())));
		return list;
	}

	@Override
	public User loadUserByUsername(String username) throws UsernameNotFoundException {// 로그인시 받은 정보로 값 불러오기

		UserDTO userDTO = new UserDTO();
		userDTO = mainDAO.getUserAllInfo(username);

		log.info("\n 유저 정보 확인 \n");
		if (userDTO.getKey().equals("Y")||userDTO.getLoginFailCount()<3) {
			log.info("\n 이메일 인증 완료");

			return new User(userDTO.getEmail(), userDTO.getPw(), makeGrantedAuthorities(userDTO.getRoles()));

		} else {
			log.info("\n 이메일 인증 또는 로그인 실패 횟수 초과");

			return new User(userDTO.getEmail(), userDTO.getPw(), makeGrantedAuthorities(null));
		}
	}

}
