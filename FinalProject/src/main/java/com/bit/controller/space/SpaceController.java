package com.bit.controller.space;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.bit.model.service.PageService;


@Controller
public class SpaceController {
	
	@Autowired(required=false)
	PageService pageService;
	
	@GetMapping("/sidenav")
	public String sidebar() {
		return "common/nav/sidenav";
	}
	
	@GetMapping("/nav")
	public String navigation() {
		return "common/nav/sidenavDrawer";
	}
	
	@GetMapping("/space")
	public String space(Model model) {
		model.addAttribute("list", pageService.getPageList());
		return "common/contents/pageContent";
	}
	
	@GetMapping("/space")
	public String getDraftList() {
		return "space/draft/draft";
	}
}
