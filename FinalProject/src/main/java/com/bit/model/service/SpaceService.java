package com.bit.model.service;

import java.util.List;

import com.bit.model.dto.space.DraftListDTO;
import com.bit.model.dto.space.SpaceUserInfoDTO;

public interface SpaceService {
	 public SpaceUserInfoDTO getSpaceUserInfo();
	 public List<DraftListDTO> getDraftList();
	 public List<DraftListDTO> getMergedList();
	 public List<DraftListDTO> getArchivedList();

}
