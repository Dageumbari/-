
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

	@Autowired(required = false)
	PageService PageService;

	@GetMapping("/pageList")
	public String getPageList(Model model) {
		model.addAttribute("list", PageService.getPageList());
		model.addAttribute("listDetail", null);
		System.out.println("PAGELIST START");
		//return "space/pageList";
		//return "common/nav/navHeader"; // navHeader가 나오는데 인클루드할때 값이 나와야함
		return "common/contents/pageContent";

	}
	
	@GetMapping("/pageDetail")
	public String getPageDetail(Model model, PageVO pv) {
		System.out.println("==================pageDetailStart=================");
		/*
		 * List =
		 * 
		 * if(ls.isEmpty()){ model.addAttribute("response","NoData"); }else{
		 * model.addAttribute("response",); }
		 */
		model.addAttribute("listDetail", PageService.getPageDetail(pv));
		return "common/contents/pageContent";

	}

	@GetMapping("/pageSave")
	public String getPageSave(HttpServletRequest req, Model model) {
		System.out.println("=====================================");
		System.out.println("1::"+req.getParameter("pageTitle"));
		System.out.println("2::"+req.getParameter("pageContent"));
		PageVO pv = new PageVO();
		pv.setPageTitle(req.getParameter("pageTitle"));
		pv.setPageContent(req.getParameter("pageContent"));
		System.out.println("3::"+pv.getPageTitle());
		System.out.println("4::"+pv.getPageContent());
		System.out.println("=====================================");
		int result = PageService.pageSave(pv);
		if (result < 1) {
			System.out.println("저장 실패!!!");
		} else {
			System.out.println("저장 성공!!!");
		}
		return "redirect:/pageList";
	}
}

	/*
	 * @GetMapping("/pageUpdate") public String getPageUpdate(HttpServletRequest
	 * req, Model model) { PageVO pv = new PageVO(); int result =
	 * PageService.pageUpdate(pv); return "common/contents/pageContent"; }
	 */
	
	/*
	 * @GetMapping("/pageContent") public String pageContent() { return
	 * "common/contents/pageContent"; }
	 */
