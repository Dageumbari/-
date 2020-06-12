package com.bit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/dashboard/*")
public class DashBoardMainController {
	//예나 😁😎✨	
	
	//public static void main(String[] args) {
		// TODO Auto-generated method stub

	//}

	@GetMapping("")
	public String orgNavi() {
		//테스트중 (대시보드 메인페이지처럼 사용 중)
		//테스트 완료 후 frament ~ insert 처리 하기~
		return "include/dashboardNavi";
	}
	
	@GetMapping("menu")
	public String orgMenu() {
		//테스트중 
		//테스트 완료 후 frament ~ insert 처리 하기~
		
		return "include/dashboardMenu";
	}
	
	
	@GetMapping("spaces")
	public String spaceDashboard() {
		
		return "dashboard/spaces";
	}
	
	@GetMapping("teams")
	public String teamDashBoard() {
		
		return "dashboard/teams";
	}
	
	@GetMapping("settings")
	public String settingDashBoard() {
		
		return "dashboard/settings";
	}
	
	//결제 진행은 별도 컨트롤러에서
	@GetMapping("billing")
	public String billingDashBoard() {
		
		
		return "dashboard/billing";
	}
	
}
