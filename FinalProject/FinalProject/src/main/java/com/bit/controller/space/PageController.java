package com.bit.controller.space;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bit.model.service.PageService;

import lombok.extern.java.Log;

@Log
@Controller
public class PageController {

	@Autowired
	PageService PageService;
	/*
	 * @GetMapping("/pageTest") public String pageList(Model model) {
	 * model.addAttribute("pageTest", PageService.getPagebyPageNo(pageNo)); return
	 * "/space/pageTest"; }
	 */
	
	@GetMapping("/spaceTest")
	public String getTestEditPage() {
		return "space/test";
	}
	@GetMapping("page")
	public String page() {
		return "page/page";
	}
	}
