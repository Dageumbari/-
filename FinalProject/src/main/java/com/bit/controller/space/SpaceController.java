package com.bit.controller.space;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

<<<<<<< HEAD
import com.bit.model.service.SpaceService;

=======
import lombok.extern.log4j.Log4j;
>>>>>>> parent of 4894f7a... draftList
import lombok.extern.log4j.Log4j2;


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
	public String getDraftList() {
		return "space/draft/draft";
	}
	
	@GetMapping("/userInfo")
	public String getSpaceUserInfo(Model model, int userNo, String spaceCode) {
		model.addAttribute("userInfo", spaceService.getSpaceUserInfo(userNo, spaceCode));
		
		return "space/draft/userInfo";
	}
	
}
