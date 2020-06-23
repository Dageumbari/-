package com.bit.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bit.model.dto.MemberDTO;
import com.bit.model.service.MemberService;
import com.bit.model.service.OrgService;
import com.bit.model.service.SpaceDashBoardService;
import com.bit.model.service.TeamService;
import com.bit.model.vo.DashBoardVO;

import lombok.AllArgsConstructor;
import lombok.extern.java.Log;

@Log
@Controller
@RequestMapping("dashboard/*")
@AllArgsConstructor //controller가 Service에 대해 의존적. 생성자를 만들고 자동으로 주입하도록 하는 어노테이션
public class DashBoardMainController {
	//예나 😁😎✨	
	
	//파라미터 @RequestParam : 파라미터로 사용된 변수 이름과 전달되는 파라미터 이름이 다른 경우
	//@RequestParam("name") String name
	
	@Autowired
	OrgService orgService;
	@Autowired
	SpaceDashBoardService spaceDashBoardService;
	@Autowired
	TeamService teamService;
	@Autowired
	MemberService memberService;
	
	//로그인 후 테스트 필요
	//시큐리티의 현재 유저 정보 가져오기
	public String currentUserNo(Principal principal) {
		log.info("USERNO을 알고 싶어요...");
		return principal.getName();
	}
	
	@GetMapping("")
	public String orgNavi(Model model,String dashBoardUrl) { //자동으로 파라미터의 setter 메서드가 동작하면서 파라미터를 수집함
		
		List<DashBoardVO> orgList = orgService.getAllOrgList();
		model.addAttribute("orgList",orgList);
		System.out.println("나의 orgList: "+orgList);
		
		DashBoardVO dashBoardVO = new DashBoardVO();
		dashBoardVO.setDashBoardCode(dashBoardVO.getDashBoardCode());
		dashBoardVO.setDashBoardUrl(dashBoardUrl);
		System.out.println("대시유알엘: "+dashBoardUrl);
		
		return "include/dashboardNavi";
	}
	
	
	@GetMapping("menu")
	public String orgMenu(Model model, @RequestParam(value = "dashBoardCode") String dashBoardCode) {

		DashBoardVO orgInfo = orgService.getOrgInfo(dashBoardCode);
		model.addAttribute("orgInfo",orgInfo);
		System.out.println("조직 정보: "+orgInfo);
		
		//테스트중 

		//admin, owner일때
		//spaces, teams, settings, billings 모든 메뉴 보이기
		
		
		//reader, writer 일때
		//space 메뉴만 보이기
		
		return "include/dashboardMenu";
	}

	@RequestMapping(value = "{dashBoardUrl}/spaces", method = RequestMethod.GET)
	//@GetMapping("spaces")
	public String spaceDashboard(Model model, @PathVariable String dashBoardUrl) {
		//조직 리스트 불러오기
		List<DashBoardVO> orgList = orgService.getAllOrgList();
		model.addAttribute("orgList",orgList);
		System.out.println("나의 orgList: "+orgList);

		DashBoardVO dashBoardVO = new DashBoardVO();
		dashBoardVO.setDashBoardCode(dashBoardVO.getDashBoardCode());
		dashBoardVO.setDashBoardUrl(dashBoardUrl);
		System.out.println("대시유알엘: "+dashBoardUrl);
		
		DashBoardVO orgInfo = orgService.getOrgInfo(dashBoardVO.getDashBoardCode());
		model.addAttribute("orgInfo", orgInfo);
		System.out.println("조직 정보: "+orgInfo);
		
		return "dashboard/spaces";
	}
	
	@GetMapping("teams")
	public String teamDashBoard(Model model, DashBoardVO dashBoardVO) {
		List<DashBoardVO> orgList = orgService.getAllOrgList();
		model.addAttribute("orgList",orgList);
		System.out.println("나의 orgList: "+orgList);
		
		dashBoardVO = orgService.getOrgInfo(dashBoardVO.getDashBoardCode());
		model.addAttribute("orgInfo",dashBoardVO);
		System.out.println("조직 정보: "+dashBoardVO);
		
		return "dashboard/teams";
	}
	
	@GetMapping("settings")
	public String settingDashBoard(Model model) {
		List<DashBoardVO> orgList = orgService.getAllOrgList();
		model.addAttribute("orgList",orgList);
		System.out.println("나의 orgList: "+orgList);
		

		
		return "dashboard/settings";
	}
	
	//결제 진행은 별도 컨트롤러에서
	@GetMapping("billing")
	public String billingDashBoard(Model model) {
		List<DashBoardVO> orgList = orgService.getAllOrgList();
		model.addAttribute("orgList",orgList);
		System.out.println("나의 orgList: "+orgList);
		
		return "dashboard/billing";
	}
	
}
