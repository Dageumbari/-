package com.bit.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import com.bit.model.dao.MainDAO;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;

@Log
@Component
@RequiredArgsConstructor
public class CustomAuthenticationFailureHandler implements AuthenticationFailureHandler {
	
	private final MainDAO maindao;
	
	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		log.info("\n==onAuthenticationFailure");
		
		String errorMsg;
		String email = request.getParameter("username");
		
		if (exception instanceof BadCredentialsException) {			
			log.info("\n==BadCredentialsException");
			
			errorMsg = "아이디와 비밀번호를 다시 확인해주세요.";
			maindao.setLoginFailCount(email);
			request.setAttribute("loginFailCount", maindao.getLoginFailCount(email));
			
		} else if (exception instanceof InternalAuthenticationServiceException) {
			log.info("\n==InternalAuthenticationServiceException");
			
			errorMsg = "아이디와 비밀번호를 다시 확인해주세요.";
			
		} else {
			
			errorMsg = "관리자에게 문의하세요.";
			
		}
				
		request.setAttribute("errorMsg", errorMsg);		
		request.getRequestDispatcher("/login").forward(request, response);
		
	}

}
