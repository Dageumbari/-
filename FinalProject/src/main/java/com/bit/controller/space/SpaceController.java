package com.bit.controller.space;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.bit.model.dto.space.DraftListDTO;
import com.bit.model.dto.space.SpaceUserInfoDTO;
import com.bit.model.service.PageService;
import com.bit.model.service.SpaceService;

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
		SpaceUserInfoDTO userInfo = spaceService.getSpaceUserInfo();
		
		//log.error(userInfo);
		model.addAttribute("userInfo", userInfo);
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
