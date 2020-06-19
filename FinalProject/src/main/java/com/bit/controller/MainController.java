package com.bit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bit.model.dao.MainDAO;
import com.bit.model.dao.NoticeDAO;
import com.bit.model.dto.UserDTO;
import com.bit.model.service.UserService;

import lombok.AllArgsConstructor;
import lombok.extern.java.Log;

@Log
@RequestMapping("/main")
@Controller
@AllArgsConstructor
public class MainController {

	@Autowired
	MainDAO mainDAO;

	
	@Autowired
	UserService userService;


	@GetMapping("/main")
	public String main() {

		return "/main/main";
	}

	@GetMapping("/atest")
	public String test(Model model) {

		return "/main/atest";
	}

	@GetMapping("/mtest")
	public String mtest(Model model) {

		return "/main/mtest";
	}

	@GetMapping("/login")
	public String login() {
		
		
		return "/main/login";
	}

	@GetMapping("/logout")
	public String logout() {

		return "/logout";
	}

	@GetMapping("/join")
	public String join(@RequestParam(required = false)String email) {
		
		System.out.println(email);
		
		return "/main/join";
	}

	@PostMapping("/join")
	public String joinPost(@ModelAttribute("userDTO") UserDTO userDTO) {

		log.info("join controller");
		String check;
		if (userService.join(userDTO) != null) {
			log.info("존재하는 유저");
			check = "/main/join";
		} else {
			log.info("가입승인");
			check = "/main/joinResult";
		}

		return check;
	}

	@GetMapping("/join/email/{email}/{key}")
	public String joinKey(@PathVariable("email") String email, @PathVariable("key") String key) {
		log.info("joinKey");
		mainDAO.setEmailCheck(email, key); // 이메일 인증 완료

		return "/main/joinResult";
	}

	@GetMapping("/accessDenied")
	public String accessDenied() {

		return "/main/main";
	}
	
	
	
}