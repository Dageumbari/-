package com.bit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.bit.model.dao.MainDAO;

import lombok.extern.java.Log;

@Log
@Controller
public class MainController {
	
	@Autowired
	MainDAO mainDAO;
	
	@GetMapping("/")
	public String main(Model model) {
		
		return "main";
	}
	
	@GetMapping("/test")
	public String test(Model model) {
		model.addAttribute("user_info", mainDAO.getUserInfo());
		
		return "test";
	}
	
	@GetMapping("/member")
	public String member() {
		return "login";
	}
	
	
}
