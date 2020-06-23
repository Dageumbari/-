package com.bit.security;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Component
@ToString
@Setter
@Getter
@ConfigurationProperties(prefix = "google.recaptcha.key")
public class RecaptchaKey {
	
	private String site;
	private String secret;
	private String url;

}
