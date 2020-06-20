package com.bit.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import com.bit.model.dto.UserDTO;
import com.bit.model.vo.UserRoleVO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BitSecurityUser extends User {
	
	private static final String ROLE_PREFIX = "ROLE_";
	
	private UserDTO userDTO;
	
	private static List<GrantedAuthority> makeGrantedAuthorities(List<UserRoleVO> roles){
		List<GrantedAuthority> list = new ArrayList<>();
		
		roles.forEach(
				role -> list.add(
						new SimpleGrantedAuthority(ROLE_PREFIX + role.getRoleName())));
		return list;
	}

	public BitSecurityUser(UserDTO userDTO) {
		
		super(userDTO.getEmail(), userDTO.getPw(), makeGrantedAuthorities(userDTO.getRoles()));
		this.userDTO = userDTO;
	}

}
