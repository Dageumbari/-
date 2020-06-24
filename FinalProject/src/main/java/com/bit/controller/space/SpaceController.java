package com.bit.controller.space;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.bit.model.service.PageService;
import com.bit.model.service.SpaceService;


@Controller
public class SpaceController {
	
	@Autowired(required=false)
	PageService pageService;
	
	@Autowired(required=false)
	SpaceService spaceService;
	
	@GetMapping("/sidenav")
	public String sidebar() {
		return "common/nav/sidenav";
	}
	
	@GetMapping("/nav")
	public String navigation() {
		return "common/nav/sidenavDrawer";
	}
	
	@GetMapping("/space")
	public String space() {
		return "layout/spaceMain";
	}
	
	@GetMapping("/userInfo")
	public String getSpaceUserInfo(Model model) {
		
		model.addAttribute("userInfo", spaceService.getSpaceUserInfo() );
		
		return "space/draft/userInfo";
	}
}
