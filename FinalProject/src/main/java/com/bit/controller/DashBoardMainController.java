package com.bit.controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	
	//로그인 후 테스트 필요
	//시큐리티의 현재 유저 정보 가져오기
	public String currentUserNo(Principal principal) {
		log.info("USERNO을 알고 싶어요...");
		return principal.getName();
	}
	
	
	@GetMapping("/orgNavi")
	public String orgNavi(Model model) { //자동으로 파라미터의 setter 메서드가 동작하면서 파라미터를 수집함
		
		List<DashBoardVO> orgList = orgService.getAllOrgList();
		
		model.addAttribute("orgList",orgList);
		System.out.println("나의 orgList: "+orgList);
		
		//return "redirect:include/dashboardNavi";
		return "include/dashboardNavi";
	}
	
	
	@PostMapping("/createOrg")
	@ResponseBody
	public void createOrg(String dashBoardName) {
		//+유저 정보 가져오기
		orgService.createOrg(dashBoardName);
		System.out.println("조직 만들기 컨트롤러 메소드 실행됨: ");
		
		//return "redirect:/dashboard/spaces?dashboardUrl="+dashBoardName;
	}
	
	@GetMapping("spaces")
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
		
		return "dashboard/spaces";
	}
	
	/*
	 * @RequestMapping(value = "teams/{teamCode}", method = {RequestMethod.GET,
	 * RequestMethod.POST}) public void teamMember(HttpServletRequest request,
	 * MemberDTO memberDTO, String teamCode) { memberDTO.setTeamCode(teamCode);
	 * 
	 * List<MemberDTO> memberList = memberService.getTeamMemberList(teamCode);
	 * 
	 * }
	 */
	
	
	@GetMapping("teams")
	public String teamDashBoard(Model model, DashBoardVO dashBoardVO) {
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
		
	
		return "dashboard/teams2";
	}
	
	
	

	@GetMapping("settings")
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
		
		return "dashboard/settings";
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
		
		return "dashboard/billing";
	}
	

}

