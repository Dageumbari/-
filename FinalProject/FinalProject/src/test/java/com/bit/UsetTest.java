package com.bit;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.bit.security.SendEmail;

import lombok.extern.java.Log;

@Log
@SpringBootTest
public class UsetTest {
	
	
	
	@Test
	public void DBtest() {
		
		SendEmail user = new SendEmail();
		
		log.info("\n"+ user.getKey());

	}

}