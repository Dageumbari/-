package com.bit.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import com.bit.model.vo.UserRoleVO;

@Component
public class MakeGrantedAuthorities {

	public List<GrantedAuthority> getRoles(List<UserRoleVO> roles) {
		return makeGrantedAuthorities(roles);
	}

	private List<GrantedAuthority> makeGrantedAuthorities(List<UserRoleVO> roles) {
		List<GrantedAuthority> grantedAuthority = new ArrayList<>();

		roles.forEach(role -> grantedAuthority.add(new SimpleGrantedAuthority("ROLE_" + role.getRoleName())));
		return grantedAuthority;
	}
}
