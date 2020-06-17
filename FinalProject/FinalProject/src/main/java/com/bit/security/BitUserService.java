package com.bit.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.bit.model.dao.MainDAO;
import com.bit.model.dto.UserDTO;
import com.bit.model.vo.UserRoleVO;

import lombok.extern.java.Log;

@Log
@Service
public class BitUserService implements UserDetailsService {

	@Autowired
	MainDAO mainDAO;

	private List<GrantedAuthority> makeGrantedAuthorities(List<UserRoleVO> roles) {
		List<GrantedAuthority> list = new ArrayList<>();

		roles.forEach(role -> list.add(new SimpleGrantedAuthority("ROLE_" + role.getRoleName())));
		return list;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		UserDTO userDTO = mainDAO.getUserAllInfo(username);
		
		log.info("\n BitUserService \n");
		
		return new User(userDTO.getEmail(), userDTO.getPw(), makeGrantedAuthorities(userDTO.getRoles()));
	}


}
