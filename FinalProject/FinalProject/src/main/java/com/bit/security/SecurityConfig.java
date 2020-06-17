package com.bit.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import lombok.extern.java.Log;

@Log
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {	
	
	@Autowired
	BitUserService bitUserService;
	
	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		
		httpSecurity.authorizeRequests()
				.antMatchers("/resources/**").permitAll()
				.antMatchers("/mtest/**").hasRole("MEMBER")
				.antMatchers("/atest/**").hasRole("ADMIN")
			.and()
				.formLogin()
				.loginPage("/login")
//				.loginProcessingUrl("/login") // 사용자의 매개변수가 POST로 전달되는 URL
//				.failureUrl("/login") // 실패시 리다이렉션 페이지
				.usernameParameter("username") 
				.passwordParameter("password")
			.and()
				.exceptionHandling().accessDeniedPage("/accessDenied")
			.and()
				.logout()
				.logoutUrl("/logout")
				.invalidateHttpSession(true)
//				.logoutSuccessUrl("/login?logout");
			.and()
				.rememberMe().key("book");		
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {

		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
					
		auth.userDetailsService(bitUserService).passwordEncoder(passwordEncoder());
		
	}
	
}
