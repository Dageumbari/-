package com.bit.controller.space;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SpaceController {
	
	@GetMapping("/sidebar")
	public String sidebar() {
		return "common/sidebar";
	}
	
	@PostMapping("/spaceHello")
	public String sayHello(@RequestParam("name") String name, Model model) {
		model.addAttribute("name", name);
		return "hello";
	}
}
