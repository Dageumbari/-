package com.bit.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bit.model.service.NoticeService;
import com.bit.model.vo.NoticeVO;

import lombok.Builder;
import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
@Builder
@RequestMapping("/main/notice/*")
public class NoticeController {
	
	private NoticeService noticeService;

	@GetMapping("/list")
	public void list(Model model) {
		log.info("list");
		model.addAttribute("list", noticeService.getAllNoticeInfo());
	}
	
	@PostMapping("/register") //등록작업POST
	public String register(NoticeVO notice, RedirectAttributes rttr) {
		log.info("register :" + notice);
		noticeService.register(notice);
		rttr.addFlashAttribute("result", notice.getNoticeNo()); //보관된 데이터 한번만 처리
		return "redirect:/notice/list";
	}
	
	@GetMapping("/register") //화면에서 입력받기. 입력페이지를 보여주는 역할~
	public void register() {
		
	}
	
	@GetMapping("/get/{noticeNo}")
	public void get(@ModelAttribute @PathVariable int noticeNo, Model model ) {
		log.info("/get");
		model.addAttribute("notice",noticeService.get(noticeNo));
	}
	
	@PostMapping("/modify")
	public String modify(NoticeVO notice, RedirectAttributes rttr) {
		log.info("modify" + notice);
		
		if (noticeService.modify(notice)) {
			rttr.addFlashAttribute("result", "success");
		}
		return "redirect:/notice/list";
	}
	
	@PostMapping("/remove/{noticeNo}")
	public String remove(@PathVariable("noticeNo") int noticeNo, RedirectAttributes rttr) {
		log.info("remove" + noticeNo);
		if(noticeService.remove(noticeNo)) {
			rttr.addFlashAttribute("result", "success");
		}
		return "redirect:/notice/list"; 
	}
    } 
    