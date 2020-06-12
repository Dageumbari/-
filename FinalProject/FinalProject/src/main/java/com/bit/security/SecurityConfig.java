package com.bit.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

import lombok.extern.java.Log;

@Log
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {	
	
	@Autowired
	BitUserService bitUserService;
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		log.info("========= 시큐리티  =========");
		
		http.authorizeRequests()
				.antMatchers("/resources/**").permitAll()
				.antMatchers("/mtest").hasRole("MEMBER")
				.antMatchers("/test").hasRole("ADMIN");
		
		http.formLogin()
				.loginPage("/login")
//				.loginProcessingUrl("/login") // 사용자의 매개변수가 POST로 전달되는 URL
//				.failureUrl("/login") // 실패시 리다이렉션 페이지
				.usernameParameter("username") 
				.passwordParameter("password"); 
		http.exceptionHandling().accessDeniedPage("/accessDenied");
		
		
		http.logout()
				.logoutUrl("/logout")
				.invalidateHttpSession(true);
//				.logoutSuccessUrl("/login?logout");
		
		http.userDetailsService(bitUserService);

	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
			
		log.info("========= AuthenticationManagerBuilder =========");
		
		auth.inMemoryAuthentication() // 메모리기반 인증 생성
		.withUser("user@test.com").password("123456").roles("MEMBER") // 사용자
		.and().withUser("ad").password("ad").roles("ADMIN"); // 관리자
		
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
