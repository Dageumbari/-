package com.bit.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bit.model.dto.NoticeCriteriaDTO;
import com.bit.model.dto.NoticePagingDTO;
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
	public void list(NoticeCriteriaDTO noticeCri, Model model) {
		log.info("list:" +noticeCri);
		model.addAttribute("list", noticeService.getAllNoticeInfo(noticeCri));
		
	    int total = noticeService.getTotalNoticeCount(noticeCri);
	    model.addAttribute("pageMaking",new NoticePagingDTO(noticeCri, total));//전체 데이터 갯수처리
	}

	@PostMapping("/register") // 등록작업POST
	public String register(NoticeVO notice, RedirectAttributes rttr) {
		log.info("register :" + notice);

		noticeService.register(notice);
		rttr.addFlashAttribute("result", notice.getNoticeNo()); // 보관된 데이터 한번만 처리
		return "redirect:/notice/list";// "redirect:/notice/list"
	}

	@GetMapping("/register")
	public void register() {
	}

	/*
	 * 수정,삭제 페이지 이동위해 get메소드 수정
	 * 
	 * @GetMapping("/get/{noticeNo}") public void
	 * get(@ModelAttribute @PathVariable("noticeNo") int noticeNo, Model model) {
	 * log.info("/get"); model.addAttribute("notice", noticeService.get(noticeNo));
	 * }
	 */

	@GetMapping({ "/get/{noticeNo}", "/modify" })
	public void get(@PathVariable("noticeNo") int noticeNO, Model model) {
		log.info("/get or modify");
		model.addAttribute("notice", noticeService.get(noticeNO));
	}

	@PostMapping("/modify")
	public String modify(NoticeVO notice, RedirectAttributes rttr) {
		log.info("modify" + notice);

		if (noticeService.modify(notice)) {
			rttr.addFlashAttribute("result", "success");
		}
		return "redirect:/notice/list"; // redirect:/notice/list -> add main/ -> do not working
	}

	@PostMapping("/remove/{noticeNo}")
	public String remove(@PathVariable("noticeNo") int noticeNo, RedirectAttributes rttr) {
		log.info("remove" + noticeNo);
		if (noticeService.remove(noticeNo)) {
			rttr.addFlashAttribute("result", "success");
		}
		return "redirect:/notice/list";
	}
}
