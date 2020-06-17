package com.bit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.bit.model.dao.MainDAO;
import com.bit.model.dto.UserDTO;
import com.bit.model.service.UserService;

import lombok.extern.java.Log;

@Log
@Controller
public class MainController {
	
	@Autowired
	PasswordEncoder pwEncoder;
	
	@Autowired
	MainDAO mainDAO;
	
	@Autowired
	UserService userService;
	
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
	
	@PostMapping("/join")
	public String joinPost(@ModelAttribute("userDTO")UserDTO userDTO) {
		
		log.info("join controller");
		userService.join(userDTO);
		
		return "/joinResult";
	}
	
	@GetMapping("/accessDenied")
	public String accessDenied() {
		
		return "/main";
	}
}
