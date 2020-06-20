package com.bit.controller.space;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.bit.model.service.SpaceService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Controller
public class SpaceController {
	
	@Autowired(required = false)
	SpaceService spaceService;
	
	
	/*
	 * @GetMapping("/sidenav") public String sidebar() { return
	 * "common/nav/sidenav"; }
	 * 
	 * @GetMapping("/nav") public String navigation() { return
	 * "common/nav/sidenavDrawer"; }
	 */
	@GetMapping("/space")
	public String space() {
		return "layout/spaceMain";
	}
	
	@GetMapping("/drafts")
	public String getdraftCardList() {
		return "space/draft/draft";
	}
	
	@GetMapping("/userInfo")
	public String getSpaceUserInfo(Model model, int userNo, String spaceCode) {
		model.addAttribute("userInfo", spaceService.getSpaceUserInfo(userNo, spaceCode));
		
		log.error(spaceService.getSpaceUserInfo(userNo, spaceCode));
		return "space/draft/userInfo";
	}
	
}
