package com.bit.controller.space;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SpaceController {
	
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
}
