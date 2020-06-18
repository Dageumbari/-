package com.bit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.bit.model.dao.MainDAO;
import com.bit.model.dto.UserDTO;

import lombok.extern.java.Log;

@Log
@Controller
public class MainController {
	
	@Autowired
	PasswordEncoder pwEncoder;
	
	@Autowired
	MainDAO mainDAO;
	
	@GetMapping("/main")
	public String main() {
		
		return "/main";
	}
	
	@GetMapping("/atest")
	public String test(Model model) {
		
		return "/atest";
	}
	
	@GetMapping("/mtest")
	public String mtest(Model model) {
		
		return "/mtest";
	}
	
	@GetMapping("/login")
	public String login() {
		
		return "/login";
	}
	
	@GetMapping("/logout")
	public String logout() {
		
		return "/logout";
	}
	
	@GetMapping("/join")
	public String join() {
		
		return "/join";
	}
	
	@Transactional
	@PostMapping("/join")
	public String joinPost(@ModelAttribute("userDTO")UserDTO userDTO) {
		
		userDTO.setPw(pwEncoder.encode(userDTO.getPw()));
		
		mainDAO.setUserInfo(userDTO);
		int uNo = mainDAO.getUserNo(userDTO.getEmail());
		mainDAO.setUserRole(userDTO, uNo);
		
		return "/joinResult";
	}
	
	@GetMapping("/accessDenied")
	public String accessDenied() {
		
		return "/main";
	}
}
