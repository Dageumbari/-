package com.bit.controller.space;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.bit.model.dto.space.DraftListDTO;
import com.bit.model.service.PageService;
import com.bit.model.service.SpaceService;
import com.bit.model.vo.PageVO;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Controller
public class SpaceController {

	@Autowired(required = false)
	PageService pageService;

	@Autowired(required = false)
	SpaceService spaceService;

	@ModelAttribute
	public void sideNavDrawerFragmentValue(Model model) {
		model.addAttribute("userInfo", spaceService.getSpaceUserInfo());
	}
	

	@GetMapping("/draftList")
	public String getDraftList(Model model) {
		List<DraftListDTO> draftList = spaceService.getDraftList(); //
		log.error(draftList);
		model.addAttribute("draftList", draftList);
		return "common/draft/draftList";
	}

	/*
	 * @GetMapping("/mergedList") public String getMedrgedList(Model model) {
	 * List<DraftListDTO> merged = spaceService.getMergedList();
	 * //log.error(merged); model.addAttribute("merged", merged); return
	 * "space/draft/mergedList"; }
	 * 
	 * @GetMapping("/archivedList") public String getArchivedList(Model model) {
	 * List<DraftListDTO> archived = spaceService.getArchivedList();
	 * log.error(archived); model.addAttribute("archived", archived); return
	 * "space/draft/archivedList"; }
	 */

	/**
	 * 페이지 파트
	 */
	@GetMapping("/pageList")
	public String getPageList(Model model) {
		// model.addAttribute("pageDetail", "NoData");
		model.addAttribute("list", pageService.getPageList());
		System.out.println("PAGELIST START");
		return "common/contents/pageContent"; // navHeader가 나오는데 인클루드할때 값이 나와야함
	}

	@GetMapping("/pageDetail")
	public String getPageDetail(Model model, PageVO pv) {
		System.out.println("==================pageDetailStart=================" + pv);
		pv = pageService.getPageDetail(pv.getPageNo());
		System.out.println("pv====" + pv);
		if (pv == null) {
			System.out.println("NoData");
			model.addAttribute("pageDetail", "NoData");
			model.addAttribute("list", pageService.getPageList());
		} else {
			model.addAttribute("pageDetail", pv);
			model.addAttribute("list", pageService.getPageList());
		}
		return "common/contents/pageContent";
	}

	@GetMapping("/pageSave")
	public String getPageSave(HttpServletRequest req, Model model) {
		System.out.println("=====================================");
		System.out.println("1::" + req.getParameter("pageTitle"));
		System.out.println("2::" + req.getParameter("pageContent"));
		PageVO pv = new PageVO();
		pv.setPageTitle(req.getParameter("pageTitle"));
		pv.setPageContent(req.getParameter("pageContent"));
		System.out.println("3::" + pv.getPageTitle());
		System.out.println("4::" + pv.getPageContent());
		System.out.println("=====================================");
		int result = pageService.pageSave(pv);
		if (result < 1) {
			System.out.println("저장 실패!!!");
		} else {
			System.out.println("저장 성공!!!");
		}
		return "redirect:/pageList";
	}
	@GetMapping("/edits")
	public String editsPage(){
		return "draft/edits";
	}
	@GetMapping("/spacePage")
	public String spacePage() {
		return "page/spacePage";
	}
}
