package com.bit.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bit.model.service.MemberService;
import com.bit.model.service.OrgService;
import com.bit.model.service.SpaceDashBoardService;
import com.bit.model.service.TeamService;
import com.bit.model.vo.DashBoardVO;
import com.bit.model.vo.UserInfoVO;

import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j;

@Log
@Controller
@RequestMapping("/dashboard/*")
public class DashBoardMainController {
	//예나 😁😎✨	
	
	@Autowired
	OrgService orgService;
	SpaceDashBoardService spaceDashBoardService;
	TeamService teamService;
	MemberService memberService;
	
	//로그인 후 테스트 필요
	//시큐리티의 현재 유저 정보 가져오기
	public String currentUserNo(Principal principal) {
		log.info("g");
		return principal.getName();
	}

	
	@GetMapping("")
	public String orgNavi(Model model, DashBoardVO Org) {
		//테스트중 (대시보드 메인페이지처럼 사용 중)
		//테스트 완료 후 frament ~ insert 처리 하기~
		List<DashBoardVO> orgList = orgService.getAllOrgList();
		
		model.addAttribute("orgList",orgList);
		
		return "include/dashboardNavi";
	}
	
	@GetMapping("menu")
	public String orgMenu(Model model) {
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
