package com.bit.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bit.model.dto.MemberDTO;
import com.bit.model.service.MemberService;
import com.bit.model.service.OrgService;
import com.bit.model.service.SpaceDashBoardService;
import com.bit.model.service.TeamService;
import com.bit.model.vo.DashBoardVO;
import com.bit.model.vo.GroupVO;
import com.bit.model.vo.SpaceVO;
import com.bit.model.vo.TeamVO;

import lombok.extern.java.Log;

@Log
@Controller
@RequestMapping("/dashboard/*")
public class DashBoardMainController {
	//예나 😁😎✨	
	
	@Autowired
	OrgService orgService;
	@Autowired
	SpaceDashBoardService spaceDashBoardService;
	@Autowired
	TeamService teamService;
	@Autowired
	MemberService memberService;
	
	
	//테스트용 페이지
	@GetMapping("/orgNavi")
	public String orgNavi(Model model) {
		
		List<DashBoardVO> orgList = orgService.getAllOrgList();
		model.addAttribute("orgList",orgList);
		log.info("나의 orgList: "+orgList);

		return "/include/dashboardNavi";
	}
	
	@GetMapping("/getUrl")
	public String getPersonalOrgUrl(Model model) {
		
		String personalOrgUrl = orgService.getPersonalOrgUrl();
		model.addAttribute("personalOrgUrl",personalOrgUrl);
		
		return "/main/main";
	}
	
	@PostMapping("/createOrg")
	@ResponseBody
	public void createOrg(String dashBoardName, String dashBoardUrl) {
		
		orgService.createOrg(dashBoardName);
		log.info("조직 만들기 컨트롤러 메소드 실행");
		
	}
	
	//회원가입시 개인 조직 생성
	//회원가입시 실행되게 하는 방법이...?
	public void createPersonalOrg(String dashBoardName) {
		
		orgService.createPersonalOrg();
	}
	
	@GetMapping("/spaces")
	public String spaceDashboard(Model model,DashBoardVO dashBoardVO, GroupVO groupVO) {
		//네비
		List<DashBoardVO> orgList = orgService.getAllOrgList();
		model.addAttribute("orgList",orgList);
		
		dashBoardVO = orgService.getOrgInfo(dashBoardVO.getDashBoardUrl());
		model.addAttribute("orgInfo",dashBoardVO);
		System.out.println("조직 정보: "+dashBoardVO);
		
		String getDashCode = dashBoardVO.getDashBoardCode();
		List<MemberDTO> allMemberList = memberService.getAllMemberList(getDashCode);
		model.addAttribute("allMemberList",allMemberList);
		System.out.println("조직 모든 멤버: "+allMemberList);
		
		//스페이스
		//그룹 리스트
		List<GroupVO> groupList = spaceDashBoardService.getAllGroupList(getDashCode);
		model.addAttribute("groupList",groupList);
		System.out.println("스페이스 그룹  리스트: "+groupList);
		
		//스페이스 리스트
		for(int i=0; i<groupList.size(); i++) {
			GroupVO group = groupList.get(i);
			String groupCode = group.getGroupCode();
			
			List<SpaceVO> spaceList = spaceDashBoardService.getAllSpaceList(groupCode);
			model.addAttribute("spaceList", spaceList);
			System.out.println("스페이스 리스트: "+spaceList);
		}
		
		return "/dashboard/spaces";
	}	
	
	@GetMapping("/teams")
	public String teamDashBoard(Model model, DashBoardVO dashBoardVO, String teamCode ) {
		//네비
		List<DashBoardVO> orgList = orgService.getAllOrgList();
		model.addAttribute("orgList",orgList);
		System.out.println("나의 orgList: "+orgList);
		
		dashBoardVO = orgService.getOrgInfo(dashBoardVO.getDashBoardUrl());
		model.addAttribute("orgInfo",dashBoardVO);
		System.out.println("조직 정보: "+dashBoardVO);
		
		String getDashCode = dashBoardVO.getDashBoardCode();
		List<MemberDTO> allMemberList = memberService.getAllMemberList(getDashCode);
		model.addAttribute("allMemberList",allMemberList);
		System.out.println("조직 모든 멤버: "+allMemberList);
		
		//조직 모든 멤버
		List<MemberDTO> allMembers = memberService.getAllMembers(getDashCode);
		model.addAttribute("allMembers",allMembers);
		
		int allMemberCount = memberService.getAllMemberCnt(getDashCode);
		model.addAttribute("allMemberCount",allMemberCount);
		System.out.println("조직 모든 멤버 카운트: "+allMemberCount);
		
		//팀 리스트
		List<TeamVO> teamList = teamService.getAllTeamList(getDashCode);
		model.addAttribute("teamList",teamList);
		System.out.println("팀 리스트: "+teamList);
		
		//new team
		//List<MemberDTO> memberList = memberService.getTeamMemberList(teamCode);
		//model.addAttribute("memberList",memberList);
		
	
		return "/dashboard/teams2";
	}
	
	/* 
	@RequestMapping(value = "teams/{teamCode}", method = {RequestMethod.POST,RequestMethod.GET})
	public String getTeamCode(Model model, @PathVariable String teamCode) {

		model.addAttribute("getTeamCode", teamCode);
		System.out.println("팀코드...?" + teamCode);

		return "dashboard/teams2";
	}
	*/
	


	/*
	@RequestMapping(value = "/getTeamCode", produces = "application/json")
	@ResponseBody
	public List<Map<String, Object>> getTeamCodeAddList(@RequestParam(value="teamCode") String teamCode, Model model, MemberDTO memberDTO) throws Exception {
		
		System.out.println("code???"+teamCode);
		
		//List<MemberDTO> memberList = memberService.getTeamMemberList(teamCode);
		//model.addAttribute("memberList", memberList);
		
		List<Map<String, Object>> memberMap = memberService.getTeamMemberList(memberDTO);
		model.addAttribute("memberMap",memberMap);
		System.out.println("맵: "+memberMap);
		
		return memberMap;
	}
	*/
	

	@GetMapping("/settings")
	public String settingDashBoard(Model model, DashBoardVO dashBoardVO) {
		//네비
		List<DashBoardVO> orgList = orgService.getAllOrgList();
		model.addAttribute("orgList",orgList);
		System.out.println("나의 orgList: "+orgList);
		
		dashBoardVO = orgService.getOrgInfo(dashBoardVO.getDashBoardUrl());
		model.addAttribute("orgInfo",dashBoardVO);
		System.out.println("조직 정보: "+dashBoardVO);

		String getDashCode = dashBoardVO.getDashBoardCode();
		List<MemberDTO> allMemberList = memberService.getAllMemberList(getDashCode);
		model.addAttribute("allMemberList",allMemberList);
		System.out.println("조직 모든 멤버: "+allMemberList);
		
		
		return "/dashboard/settings";
	}
	
	@GetMapping("/deleteOrg")
	@ResponseBody
	public String deleteOrg(HttpServletRequest httpServletRequest) {
		//String dashBoardUrl = httpServletRequest.getParameter("dashBoardUrl");
		String dashBoardUrl = httpServletRequest.getParameter("dashBoardUrl");
		System.out.println("유알엘?????????"+dashBoardUrl);
		orgService.deleteOrg(dashBoardUrl);
		
		return dashBoardUrl;
	}

	//결제 진행은 별도 컨트롤러에서
	@GetMapping("/billing")
	public String billingDashBoard(Model model, DashBoardVO dashBoardVO) {	
		List<DashBoardVO> orgList = orgService.getAllOrgList();
		model.addAttribute("orgList",orgList);
		System.out.println("나의 orgList: "+orgList);
		
		dashBoardVO = orgService.getOrgInfo(dashBoardVO.getDashBoardUrl());
		model.addAttribute("orgInfo",dashBoardVO);
		System.out.println("조직 정보: "+dashBoardVO);
		
		String getDashCode = dashBoardVO.getDashBoardCode();
		List<MemberDTO> allMemberList = memberService.getAllMemberList(getDashCode);
		model.addAttribute("allMemberList",allMemberList);
		System.out.println("조직 모든 멤버: "+allMemberList);
		
		//
		
		return "/dashboard/billing";
	}
	

}

