package com.bit.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.stereotype.Component;

import com.bit.model.dao.MainDAO;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;

@Log
@Component
@RequiredArgsConstructor
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

	private final MainDAO mainDAO;
	private final HttpSession httpSession;
	private final String defaultUrl = "/main";

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		log.info("\n==onAuthenticationSuccess");

		String email = request.getParameter("username");
		mainDAO.setLoginFailCountReset(email);

		loginFailSessionClaer(request);
		sendRedirect(request, response);

		// UserDTO userDTO = mainDAO.getUserAllInfo(email);
		// httpSession.setAttribute("sessionUser", new SessionUser(userDTO));
	}

	private void loginFailSessionClaer(HttpServletRequest request) { // 로그인 실패시 저장된 세션 제거

		if (request.getSession(false) != null) {
			request.getSession(false).removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
		}
		return;
	}

	private void sendRedirect(HttpServletRequest request, HttpServletResponse response) throws IOException {
		RequestCache requestCache = new HttpSessionRequestCache();
		RedirectStrategy redirectStratgy = new DefaultRedirectStrategy();

		SavedRequest savedRequest = requestCache.getRequest(request, response);

		if (savedRequest != null) {
			String targetUrl = savedRequest.getRedirectUrl();
			redirectStratgy.sendRedirect(request, response, targetUrl);
		} else {
			redirectStratgy.sendRedirect(request, response, defaultUrl);
		}
	}

}
