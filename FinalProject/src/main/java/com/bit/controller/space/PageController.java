
package com.bit.controller.space;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.bit.model.service.PageService;
import com.bit.model.vo.PageVO;


@Controller
public class PageController {

	@Autowired
	PageService PageService;
	
	@GetMapping("/pageList")
	public String getPageList(Model model) {
		model.addAttribute("list", PageService.getPageList());
		//return "space/pageList";
		return "common/nav/navHeader"; //navHeader가 나오는데 인클루드할때 값이 나와야함
		
	}
	
	@GetMapping("/spacePage")
	public String getAllList(Model model) {
		model.addAttribute("allList", PageService.getAllList());
		return "page/spacePage";                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 
	}
	
	@GetMapping("/pageSave")
	public String getPageSave(HttpServletRequest req,  Model model) {
		System.out.println("=====================================");
		System.out.println(req.getParameter("pageTitle"));
		System.out.println(req.getParameter("pageConenet"));
		System.out.println("=====================================");
		PageVO pv = new PageVO();
		int result = PageService.pageSave(pv);
		if (result < 1) {
			System.out.println("저장 실패!!!");
		} else {
			System.out.println("저장 성공!!!");
		}
		
		return "common/contents/pageContent";
	}
	
}
