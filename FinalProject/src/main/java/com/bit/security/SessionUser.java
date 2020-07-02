package com.bit.security;

import java.io.Serializable;

import com.bit.model.dto.UserDTO;

import groovy.transform.ToString;
import lombok.Getter;

@Getter
@ToString
public class SessionUser implements Serializable {
	
	private String name;
	private String email;
	private String userImage;

	public SessionUser(UserDTO userDTO) {
		this.name = userDTO.getName();
		this.email = userDTO.getEmail();
		this.userImage = userDTO.getUserImage();
	}
}
