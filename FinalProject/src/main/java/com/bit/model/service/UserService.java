package com.bit.model.service;

import org.springframework.web.servlet.ModelAndView;

import com.bit.model.dto.UserDTO;

public interface UserService {
	
	public ModelAndView join(UserDTO userDTO);
	
	public ModelAndView adminjoin(UserDTO userDTO,String adminEmail);
	
	public void forgot(String email);
	
	public String emailCheck(String email, String key);
}
