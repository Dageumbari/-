package com.bit.security;

import javax.servlet.http.HttpSession;

import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Component;

import com.bit.model.dao.MainDAO;
import com.bit.model.dto.UserDTO;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;

@Log
@RequiredArgsConstructor
@Component
public class CustomOAuth2UserService implements OAuth2UserService<OAuth2UserRequest, OAuth2User> {
	
	private final MainDAO mainDAO;
	private final HttpSession httpSession;
	private final MakeGrantedAuthorities makeGrantedAuthorities;
	
	@Override
	public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
		log.info("\n==CustomOAuth2UserService ");

		OAuth2UserService<OAuth2UserRequest, OAuth2User> oAuth2UserService = new DefaultOAuth2UserService();
		OAuth2User oAuth2User = oAuth2UserService.loadUser(userRequest);
		log.info("\n==oAuth2User : " + oAuth2User.getAttributes() +"\n" +oAuth2User.toString());

		String registrationId = userRequest.getClientRegistration()
				.getRegistrationId(); // 어떤 소셜 로그인인지 체크
		log.info("\n==registrationId : " + registrationId);

		String userNameAttributeName = userRequest.getClientRegistration()
				.getProviderDetails().getUserInfoEndpoint().getUserNameAttributeName();
		// 구글 : sub, 네이버 : response
		log.info("\n==userNameAttributeName : " + userNameAttributeName);
		
		UserDTO userDTO = new UserDTO();
		userDTO  = OAuthAttributes.of(registrationId, userDTO, oAuth2User.getAttributes()); // OAuth2User의 값을 받아줌
		log.info("\n==loadUser : " + userDTO);
		
		if (mainDAO.getJoinCheck(userDTO.getEmail()) == null) {
			
			mainDAO.setUserInfo(userDTO);
			httpSession.setAttribute("sessionUser", new SessionUser(userDTO));
			
			return new DefaultOAuth2User(makeGrantedAuthorities.getRoles(userDTO.getRoles()),
					oAuth2User.getAttributes(), userNameAttributeName);

		} else {
			
			mainDAO.getUserAllInfo(userDTO.getEmail());
			httpSession.setAttribute("sessionUser", new SessionUser(userDTO));
			
			return new DefaultOAuth2User(makeGrantedAuthorities.getRoles(userDTO.getRoles()),
					oAuth2User.getAttributes(), userNameAttributeName);
		}
		
	}

}
