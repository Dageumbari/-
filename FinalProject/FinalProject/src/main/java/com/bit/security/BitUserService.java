package com.bit.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.bit.model.dao.MainDAO;
import com.bit.model.dto.UserDTO;

@Service
public class BitUserService implements UserDetailsService {

	@Autowired
	MainDAO mainDAO;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		UserDTO userDTO = mainDAO.getUserAllInfo(username);
		
		if (userDTO != null) {

			return new BitSecurityUser(userDTO);
		}
		
		return null;
	}

}
