package com.bit.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import lombok.RequiredArgsConstructor;

@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {	
	
	private final UserDetailsService userDetailsService;
	private final AuthenticationFailureHandler authenticationFailureHandler;
	private final AuthenticationSuccessHandler authenticationSuccessHandler;
	private final OAuth2UserService<OAuth2UserRequest, OAuth2User> oAuth2UserService;
	
	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		
		httpSecurity.authorizeRequests()
				.antMatchers("/resources/**").permitAll()
				.antMatchers("/password").hasRole("MEMBER")
//				.antMatchers("/main/atest/**").hasRole("ADMIN")
			.and()
				.formLogin()
				.loginPage("/login") // 로그인 페이지
					.usernameParameter("username") 
					.passwordParameter("password")
					.successHandler(authenticationSuccessHandler)
					.failureHandler(authenticationFailureHandler)
			.and()
				.oauth2Login()
				.loginPage("/login")
						.userInfoEndpoint().userService(oAuth2UserService)
			.and()
			.and()
				.exceptionHandling().accessDeniedPage("/accessDenied")
			.and()
				.logout()
					.logoutUrl("/logout")
					.logoutSuccessUrl("/main")
			.and()
				.rememberMe().key("book");		
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {

		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
					
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
		
	}
	
}
