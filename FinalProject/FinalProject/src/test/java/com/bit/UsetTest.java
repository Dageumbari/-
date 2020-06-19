package com.bit;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.bit.model.dao.MainDAO;
import com.bit.model.dto.UserDTO;
import com.bit.security.SendEmail;

import lombok.extern.java.Log;

@Log
@SpringBootTest
public class UsetTest {
	
	@Autowired
	MainDAO maindao;

	@Test
	public void DBtest() {
		
		
		UserDTO userVal = new UserDTO();
		userVal = maindao.getUserAllInfo("collin1016@naver.com");
		log.info("\n TEST" + userVal);

	}

}