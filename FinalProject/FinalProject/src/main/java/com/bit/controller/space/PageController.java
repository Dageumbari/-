
package com.bit.controller.space;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.bit.model.service.PageService;


@Controller
public class PageController {

	@Autowired
	PageService PageService;
	
	@GetMapping("/pageList")
	public String getPageList(Model model) {
		model.addAttribute("list", PageService.getPageList());
		return "space/pageList";
	}
<<<<<<< HEAD
	
	@GetMapping("spacePage")
=======
	@GetMapping("page")
>>>>>>> 400a384649b00a5f12770eb2eef8aaa06c812b79
	public String page() {
		return "page/spacePage";
	}
}
