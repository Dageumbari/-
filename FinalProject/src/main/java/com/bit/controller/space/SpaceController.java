package com.bit.controller.space;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bit.model.dto.space.DraftListDTO;
import com.bit.model.service.PageService;
import com.bit.model.service.SpaceService;
import com.bit.model.vo.PageVO;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Controller
//@RequestMapping("/space")
public class SpaceController {

	/*
	 * @InitBinder public void initBinder(WebDataBinder binder) {
	 * binder.registerCustomEditor(Timestamp.class, new CustomDateEditor(new
	 * SimpleDateFormat("yyyy-MM-dd HH:mm:SS"), true)); }
	 */

	@Autowired(required = false)
	PageService pageService;

	@Autowired(required = false)
	SpaceService spaceService;

	@Autowired
	HttpSession httpsession;

	@ModelAttribute
	public void sideNavFragmentValue(Model model) {
		model.addAttribute("userInfo", spaceService.getSpaceUserInfo());
	}

	// 드래프트 리스트 호출 //@ModelAttribute

	@GetMapping("/draftList")
	public String getDraftList(Model model) {
		List<DraftListDTO> draftList = spaceService.getDraftList();

		log.error(draftList);
		model.addAttribute("draftList", draftList);

		return "draft/draftList";
	}

	@GetMapping("/mergedList")
	public String getMedrgedList(Model model) {
		List<DraftListDTO> mergedList = spaceService.getMergedList();
		log.error(mergedList);
		model.addAttribute("mergedList", mergedList);
		return "draft/mergedList";
	}

	@GetMapping("/archivedList")
	public String getArchivedList(Model model) {
		List<DraftListDTO> archivedList = spaceService.getArchivedList();
		log.error(archivedList);
		model.addAttribute("archivedList", archivedList);
		return "draft/archivedList";
	}

	/**
	 * 페이지 파트
	 */
	@GetMapping("/pageList")
	public String getPageList(Model model) {
		// model.addAttribute("pageDetail", "NoData");
		List<PageVO> pageVOs = pageService.getPageList();
		model.addAttribute("list", pageVOs);

		PageVO pv = pageVOs.get(pageVOs.size() - 1);

		model.addAttribute("lastPageNo", pv.getPageNo());
		System.out.println("PAGELIST START " + pv.getPageNo());
		return "common/contents/pageContent"; // navHeader가 나오는데 인클루드할때 값이 나와야함
	}

	@GetMapping("/pageDetail")
	public String getPageDetail(Model model, PageVO pv) {
		System.out.println("=======getPageDetail START=====");
		pv = pageService.getPageDetail(pv.getPageNo());
		// model.addAttribute("pageDetail", pv);

		if (pv == null) {
			System.out.println("NoData");
			model.addAttribute("pageDetail", "NoData");
			model.addAttribute("list", pageService.getPageList());
		} else {
			model.addAttribute("pageDetail", pv);
			model.addAttribute("list", pageService.getPageList());
		}
		System.out.println("=======getPageDetail END=====");
		return "common/contents/pageContent";
	}

	/*
	 * @GetMapping("/pageUpdate") public String getPageUpdate(HttpServletRequest
	 * req, Model model) { model.addAttribute("1::" +
	 * req.getParameter("pageTitle")); model.addAttribute("2::" +
	 * req.getParameter("pageContent")); PageVO pv = new PageVO();
	 * pv.setPageTitle(req.getParameter("pageTitle"));
	 * pv.setPageTitle(req.getParameter("pageContent"));
	 * System.out.println("게시글 수정 성공!!");
	 * 
	 * return "redirect:/pageList"; }
	 */

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

	/*
	 * @GetMapping("/delete") public String delete(@RequestParam("pageNo") int
	 * pageNo, Model model) { System.out.println("삭제!!!");
	 * pageService.deletePage(pageNo); return "redirect: /pageList"; }
	 */
}