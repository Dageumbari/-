package com.bit.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bit.model.dao.MainDAO;
import com.bit.model.dto.UserDTO;
import com.bit.model.service.UserService;
import com.bit.security.RecaptchaService;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;

@Log
@Controller
@RequiredArgsConstructor
public class MainController {

	private final MainDAO mainDAO;
	private final UserService userService;
	private final RecaptchaService recaptchaService;

	@GetMapping("/main")
	public String main() {

		return "/main/main";
	}

	@GetMapping("/atest")
	public String test() {

		return "/main/atest";
	}

	@GetMapping("/mtest")
	public String mtest() {

		return "/main/mtest";
	}

	@GetMapping("/login")
	public String login() {
		log.info("============================= get =========================");

		return "/main/login";
	}

	@PostMapping("/login")
	public String loginPost() {
		log.info("============================= post =========================");

		return "/main/login";
	}

	@GetMapping("/logout")
	public String logout() {

		return "/main/logout";
	}

	@GetMapping("/join")
	public String join() {

		return "/main/join";
	}

	@PostMapping("/join")
	public ModelAndView joinPost(@ModelAttribute("userDTO") UserDTO userDTO) {
		log.info("join controller");

		return userService.join(userDTO);
	}

	@GetMapping("/join/email/{email}/{key}")
	public String joinKey(@PathVariable("email") String email, @PathVariable("key") String key) {
		log.info("joinKey");
		mainDAO.setEmailCheck(email, key); // 이메일 인증 완료

		return "/main/main";
	}

	@GetMapping("/accessDenied")
	public String accessDenied() {

		return "/main/main";
	}
	
	@PostMapping("/valid-recaptcha")
    public @ResponseBody String validRecaptcha(HttpServletRequest request){
		
		log.info("\n/valid-recaptcha : " +  request.getParameter("g-recaptcha-response"));
		
    	String result = null;
    	String response = request.getParameter("g-recaptcha-response");
    	
    	log.info("\nCHECK1 : " + response + "\nrecaptchaService:" + recaptchaService.toString());
    	boolean isRecaptcha = recaptchaService.verifyRecaptcha(response);
    	
    	
    	log.info("\nCHECK2 : " + isRecaptcha);
    	if(isRecaptcha) {
    		result = "success";
    	}else {
    		result = "false";
    	}  	
    	
    	log.info("\nCHECK3 : " + result);
    	return result;
    }

}
