package com.bit.controller.space;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

	/*
	 * @Autowired PageDAO pageDAO;
	 */
	/*
	 * @GetMapping("/pageTest") public String getPagebyPageNo(int PageNo) { return
	 * "/space/pageTest"; }
	 */
	@GetMapping("page")
	public String aboutPage() {
		return "page/page";
	}
}
