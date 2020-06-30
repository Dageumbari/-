package com.bit.security;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.bit.model.dto.UserDTO;
import com.bit.model.vo.UserRoleVO;

import lombok.extern.java.Log;

@Log
public class OAuthAttributes {

	public static UserDTO of(String registrationId, UserDTO userDTO, Map<String, Object> attributes) {
		log.info("\n==OAuthAttributes : " + attributes);
		
		List<UserRoleVO> roles = new ArrayList<UserRoleVO>();
		roles.add(new UserRoleVO());
		userDTO.setRoles(roles);
		userDTO.getRoles().get(0).setRoleName("MEMBER");
		
		if (registrationId.equals("naver")) {
			return Naver(userDTO, attributes);
		} else if (registrationId.equals("google")) {
			return Google(userDTO, attributes);
		} else {
			return null;
		}
	}

	private static UserDTO Google(UserDTO userDTO, Map<String, Object> attributes) {

		log.info("\n==google ");
		
		userDTO.setEmail((String)attributes.get("email"));
		userDTO.setName((String) attributes.get("name"));
		userDTO.setPw((String) attributes.get("sub"));
		userDTO.setGender("Private");
		userDTO.setKey("google");
		
		return userDTO;
	}

	private static UserDTO Naver(UserDTO userDTO, Map<String, Object> attributes) {
		
		log.info("\n==naver ");
		Map<String, Object> response = (Map<String, Object>) attributes.get("response"); 
		// 네이버는 Map안에 Map으로 정보가 담겨있음.
		
		userDTO.setEmail((String)response.get("email"));
		userDTO.setName((String) response.get("name"));
		userDTO.setPw((String) response.get("id"));
		userDTO.setGender((String) attributes.get("gender"));
		userDTO.setKey("naver");
		
		return userDTO;
	}
}
