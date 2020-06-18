package com.bit.model.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bit.model.dao.SpaceDAO;
import com.bit.model.dto.space.DraftDTO;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service("SpaceService")
public class SpaceServiceImpl {
	
	@Autowired(required=false)
	SpaceDAO spaceDAO;
	
	
	 List<DraftDTO> getSavedDraft() {
		 List<DraftDTO> draftList = spaceDAO.getSavedDraft();
		 
		 log.error(draftList);
		 
		return draftList;
		
		
	}
}
