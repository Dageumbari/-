package com.bit.model.service;

import org.springframework.web.servlet.ModelAndView;

import com.bit.model.dto.UserDTO;

public interface UserService {
	
	public ModelAndView join(UserDTO userDTO);
	
	public void forgot(String email);
}
