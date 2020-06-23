package com.bit.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import lombok.RequiredArgsConstructor;


@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {	
	
	private final UserDetailsService customUserDetailsService;
	private final AuthenticationFailureHandler customAuthenticationFailureHandler;
	private final AuthenticationSuccessHandler customAuthenticationSuccessHandler;
	
	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		
		httpSecurity.authorizeRequests()
				.antMatchers("/resources/**").permitAll()
//				.antMatchers("/main/mtest/**").hasRole("MEMBER")
//				.antMatchers("/main/atest/**").hasRole("ADMIN")
			.and()
				.formLogin()
				.loginPage("/login")
//				.loginProcessingUrl("/login") // 사용자의 매개변수가 POST로 전달되는 URL
				.usernameParameter("username") 
				.passwordParameter("password")
				.failureHandler(customAuthenticationFailureHandler)
				.successHandler(customAuthenticationSuccessHandler)
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
					
		auth.userDetailsService(customUserDetailsService).passwordEncoder(passwordEncoder());
		
	}
	
}
