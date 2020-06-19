package com.bit.controller;



import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import lombok.extern.log4j.Log4j2;

@Log4j2
@SpringBootTest
@AutoConfigureMockMvc
public class NoticeControllerTest {
	
	@Autowired
	public MockMvc mockMvc; //fake mvc~
	//@before해서 webContext는 할 필요x 
	
	@Test
	@DisplayName("Notice List")
	//declare custom display name for the annotated test class or method
 public void testList() throws Exception {
		  log.info (
				  mockMvc.perform(MockMvcRequestBuilders.get("main/notice/list"))
		   .andReturn()
		   .getModelAndView()//모델에 담긴 데이터 확인
		   .getModelMap());
	}
}


