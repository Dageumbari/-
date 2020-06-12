package com.bit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.bit.model.dao.MainDAO;

import lombok.extern.java.Log;

@Log
@Controller
public class MainController {
	
	@Autowired
	MainDAO mainDAO;
	
	@GetMapping("/main")
	public String main() {
		mainDAO.getUserInfo("1q2w3e4r@naver.com");
		return "main";
	}
	
	@GetMapping("/test")
	public String test(Model model) {
		
		return "test";
	}
	
	@GetMapping("/mtest")
	public String mtest(Model model) {
		
		return "mtest";
	}
	
	@GetMapping("/login")
	public String login() {
		
		return "login";
	}
	
	@GetMapping("/logout")
	public String logout() {
		
		return "logout";
	}
	
	@GetMapping("/accessDenied")
	public String accessDenied() {
		
		return "main";
	}
}
