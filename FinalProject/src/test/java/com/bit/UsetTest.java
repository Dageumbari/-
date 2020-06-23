package com.bit;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.bit.model.dao.MainDAO;


@SpringBootTest
public class UsetTest {
	
	@Autowired
	MainDAO maindao;

	@Test
	public void DBtest() {
		


	}

}