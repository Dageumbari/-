package com.bit.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.security.crypto.password.PasswordEncoder;
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
import com.bit.security.SessionUser;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;

@Log
@Controller
@RequiredArgsConstructor
public class MainController {

	private final MainDAO mainDAO;
	private final UserService userService;
	private final RecaptchaService recaptchaService;
	private final PasswordEncoder passwordEncoder;
	private final HttpSession httpSession;

	@GetMapping("/main")
	public String main() {

		return "/main/main";
	}

	@GetMapping("/password")
	public String password() {

		return "/main/password";
	}

	@PostMapping("/password")
	public String postPassword(String password) {
		log.info("\n==password");

		SessionUser sessionUser = (SessionUser) httpSession.getAttribute("sessionUser");
		String email = sessionUser.getEmail();
		mainDAO.setForgotPassword(passwordEncoder.encode(password), email);

		// 로그아웃 실행할것.
		return "redirect:/login";
	}

	@GetMapping("/rename")
	public String rename() {

		return "/main/rename";
	}

	@PostMapping("/rename")
	public String postRename(String name) {
		log.info("\n==rename");

		SessionUser sessionUser = (SessionUser) httpSession.getAttribute("sessionUser");
		String email = sessionUser.getEmail();
		mainDAO.setName(name, email);

		return "/main/rename";
	}

	@GetMapping("/inquiry")
	public String inquiry() {

		return "/main/inquiry";
	}

	@PostMapping("/inquiry")
	public String postInquiry() {
		log.info("\n==inquiry");

		return "/main/inquiry";
	}

	@GetMapping("/forgot")
	public String forgot() {

		return "/main/forgot";
	}

	@PostMapping("/forgot")
	public String forgotEamil(String email) {

		userService.forgot(email);

		return "/main/main";
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

	@GetMapping("/join")
	public String join() {

		return "/main/join";
	}

	@PostMapping("/join")
	public ModelAndView postJoin(@ModelAttribute("userDTO") UserDTO userDTO) {
		log.info("\n==join controller");

		return userService.join(userDTO);
	}

	@GetMapping("/join/admin")
	public String adminJoin() {

		return "/main/joinAdmin";
	}

	@PostMapping("/join/admin")
	public ModelAndView adminJoinPost(UserDTO userDTO) {
		log.info("\n==aminjoin controller");

		String superAdminEmail = userDTO.getEmail(); // "collin7202@gmail.com";

		return userService.adminjoin(userDTO, superAdminEmail);
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
	public @ResponseBody String validRecaptcha(HttpServletRequest request) {

		log.info("\n/valid-recaptcha : " + request.getParameter("g-recaptcha-response"));

		String result;
		String response = request.getParameter("g-recaptcha-response");

		log.info("\nCHECK1 : " + response + "\nrecaptchaService:" + recaptchaService.toString());
		boolean isRecaptcha = recaptchaService.verifyRecaptcha(response);

		log.info("\nCHECK2 : " + isRecaptcha);
		if (isRecaptcha) {
			result = "success";
		} else {
			result = "false";
		}

		log.info("\nCHECK3 : " + result);
		return result;
	}

}
