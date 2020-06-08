package com.bit.controller.space;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bit.model.service.PageService;

@Controller
public class PageController {

	@Autowired
	PageService PageService;

	@GetMapping("/pageTest")
	public void getPagebyPageNo(@RequestParam(value="pageNo", required=false) int pageNo, Model model) {
		model.addAttribute("pageTest", PageService.getPagebyPageNo(pageNo));
	}
	
	@GetMapping("/test")
	public String getTestEditPage() {
		return "space/test";
	}
	@GetMapping("page")
	public String page() {
		return "page/page";
	}
	}
