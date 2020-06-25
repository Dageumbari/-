package com.bit.controller.space;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.bit.model.dto.space.DraftListDTO;
import com.bit.model.dto.space.SpaceUserInfoDTO;
import com.bit.model.service.PageService;
import com.bit.model.service.SpaceService;
import com.bit.model.vo.PageVO;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Controller
public class SpaceController {
	
	@Autowired
	PageService pageService;
	
	@Autowired(required=false)
	SpaceService spaceService;
	
	@GetMapping("/space")
	public String space(Model model) {
		//HttpServletRequest req, PageVO pv
		//여주
		SpaceUserInfoDTO userInfo = spaceService.getSpaceUserInfo();
		//여주  END

		//연수 페이지 리스트
		model.addAttribute("list", pageService.getPageList());
		System.out.println("PAGELIST START");
		//연수 페이지 리스트 END
		
		//연수 pageDetail
		/*System.out.println("==================pageDetailStart=================" + pv);
		pv = pageService.getPageDetail(pv.getPageNo());
		System.out.println("pv====" + pv);
		if (pv == null) {
			System.out.println("NoData");
			model.addAttribute("pageDetail", "NoData");
		} else {
			System.out.println("222222222222");
			model.addAttribute("pageDetail", pv);
		}*/
		
		
		//연수 pageSave
		/*System.out.println("=====================================");
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
		}*/
		//연수 END
		
		//여주
		//log.error(userInfo);
		model.addAttribute("userInfo", userInfo);
		//여주 END
		return "layout/spaceMain";
	}

	@GetMapping("/draftList")
	public String getDraftList(Model model) {
		List<DraftListDTO> draftList = spaceService.getDraftList();
		//log.error(draftList);
		model.addAttribute("draftList", draftList);
		return "layout/spaceMain";
	}

	
	@GetMapping("/mergedList")
	public String getMedrgedList(Model model) {
		List<DraftListDTO> merged = spaceService.getMergedList();
		//log.error(merged);
		model.addAttribute("merged", merged);
		return "space/draft/mergedList";
	}
	
	@GetMapping("/archivedList")
	public String getArchivedList(Model model) {
		List<DraftListDTO> archived = spaceService.getArchivedList();
		log.error(archived);
		model.addAttribute("archived", archived);
		return "space/draft/archivedList";
	}
}
