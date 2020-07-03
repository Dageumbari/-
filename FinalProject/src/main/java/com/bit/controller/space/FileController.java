package com.bit.controller.space;

import org.springframework.web.bind.annotation.RequestMapping;

public class FileController {

	@RequestMapping("")
	private String fileCreateMain() {
		
		return "fileCreate";
	}
	@RequestMapping("")
	private String fileModifyMain() {
		
		return "fileModify";
	}
}
