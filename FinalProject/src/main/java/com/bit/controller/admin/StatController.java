package com.bit.controller.admin;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bit.model.dto.ChartDTO;
import com.bit.model.service.ChartService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
@Log4j2
@Controller
@AllArgsConstructor
public class StatController {
	private ChartService chartService;
	
	  @GetMapping("/main/chart/userChart") //@ResponseBody 
	  public void userMonthlyStatus(Model model) {
	  model.addAttribute("list",chartService.getLoginDate());
	  System.out.println("리스트: "+chartService.getLoginDate());
	 
	  }
	 
	
	//이렇게 쓰면 responsebody를 쓸 수 있음
	//@GetMapping("/main/chart/userChart")
	//@ResponseBody
	//public List<ChartDTO> UserMonthlyStatusChart() {
	//	System.out.println("리스트: "+chartService.getLoginDate());
	//	return chartService.getLoginDate();
	
}
	
	

	
	

