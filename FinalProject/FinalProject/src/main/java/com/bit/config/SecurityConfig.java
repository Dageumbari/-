package com.bit.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

import lombok.extern.java.Log;

@Log
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		log.info("security config -------------------");
		
		http.authorizeRequests()
				.antMatchers("/resources/**").permitAll()
				.antMatchers("/mtest").hasRole("MEMBER");
		http.formLogin()
				.loginPage("/login/form")
				.loginProcessingUrl("/login") // 사용자의 매개변수가 POST로 전달되는 URL
				.failureUrl("/login") // 실패시 리다이렉션 페이지
				.usernameParameter("username") // 
				.passwordParameter("password");
		
		http.logout()
				.logoutUrl("/logout")
				.logoutSuccessUrl("/login?logout");

	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth.inMemoryAuthentication()
		.withUser("user").password("user").roles("MEMBER") // 사용자
		.and().withUser("ad").password("ad").roles("MEMBER", "ADMIN"); // 관리자
	
	}

	@Bean
	public PasswordEncoder passwordEncoder() {

		return new PasswordEncoder() {

			@Override
			public boolean matches(CharSequence rawPassword, String encodedPassword) {
				// TODO Auto-generated method stub
				return rawPassword.equals(encodedPassword);
			}

			@Override
			public String encode(CharSequence rawPassword) {
				// TODO Auto-generated method stub
				return rawPassword.toString();
			}
		};
	}

}
