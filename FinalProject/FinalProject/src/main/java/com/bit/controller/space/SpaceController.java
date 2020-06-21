package com.bit.controller.space;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.bit.model.service.PageService;
import com.bit.model.vo.PageVO;


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
		//return "layout/spaceMain";
		return "common/contents/pageContent";
	}
	
	public String getDraftList() {
		return "space/draft/draft";
	}
}
