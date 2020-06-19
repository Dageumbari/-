package com.bit.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bit.model.dto.MemberDTO;
import com.bit.model.service.MemberService;
import com.bit.model.service.OrgService;
import com.bit.model.service.SpaceDashBoardService;
import com.bit.model.service.TeamService;
import com.bit.model.vo.DashBoardVO;

import lombok.extern.java.Log;

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
		log.info("USERNO을 알고 싶어요...");
		return principal.getName();
	}
	
	@RequestMapping("")
	public String orgNavi(Model model) {
		//테스트중 (대시보드 메인페이지처럼 사용 중)
		//테스트 완료 후 fragment ~ insert 처리 하기~
		List<DashBoardVO> orgList = orgService.getAllOrgList();
		model.addAttribute("orgList",orgList);
		System.out.println("나의 orgList: "+orgList);
		
		return "include/dashboardNavi";
	}
	
	@GetMapping("menu")
	public String orgMenu(Model model) {
		//테스트중 
		//테스트 완료 후 frament ~ insert 처리 하기~
		
		//admin, owner일때
		//spaces, teams, settings, billings 모든 메뉴 보이기
		
		//reader, writer 일때
		//space 메뉴만 보이기
		
		
		return "include/dashboardMenu";
	}


	@GetMapping("spaces")
	public String spaceDashboard(Model model) {
		List<DashBoardVO> orgList = orgService.getAllOrgList();
		model.addAttribute("orgList",orgList);
		System.out.println("나의 orgList: "+orgList);
	 
		
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
