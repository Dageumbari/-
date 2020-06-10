package com.bit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.bit.model.dao.MainDAO;

@Controller
public class MainController {
	
	@Autowired
	MainDAO mainDAO;
	
	@GetMapping("/test")
	public String test(Model model) {
		return "test";
	}
	
	@GetMapping("/member")
	public String member() {
		return "common/member/login";
	}
	
	
}
