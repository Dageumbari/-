package com.bit.security;

import java.lang.reflect.Member;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import com.bit.model.dto.UserDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BitSecurityUser extends User {

	/*
	 * public BitSecurityUser( String username, String password, Collection<?
	 * extends GrantedAuthority> authorities ){
	 * 
	 * super (username, password, authorities); }
	 */

	private static final String ROLE_PREFIX = "ROLE_";
	private UserDTO userDTO;

	public BitSecurityUser(UserDTO userDTO) {
		
		super(userDTO.getEmail(), userDTO.getPw(), make)
	}

}
