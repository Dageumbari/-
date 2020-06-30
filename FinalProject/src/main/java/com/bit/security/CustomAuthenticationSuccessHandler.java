package com.bit.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.bit.model.dao.MainDAO;
import com.bit.model.dto.UserDTO;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;

@Log
@Component
@RequiredArgsConstructor
public class CustomAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {
	
	private final MainDAO mainDAO;
	private final HttpSession httpSession;

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		log.info("\n==onAuthenticationSuccess");
		
		String email = request.getParameter("username");
		mainDAO.setLoginFailCountReset(email);
		UserDTO userDTO = mainDAO.getUserAllInfo(email);
		httpSession.setAttribute("sessionUser", new SessionUser(userDTO));
		
		super.onAuthenticationSuccess(request, response, authentication);
	
	}
	
	
}
