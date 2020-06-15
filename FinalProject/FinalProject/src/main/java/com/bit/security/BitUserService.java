package com.bit.security;

import java.util.Arrays;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lombok.extern.java.Log;

@Log
@Service
public class BitUserService implements UserDetailsService{
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User sampleUser = new User(username, "1111", Arrays.asList
							(new SimpleGrantedAuthority("MEMBER")));
		
		log.info(" 유저 확인 " + sampleUser);
		
		return sampleUser;
	}
	
}
