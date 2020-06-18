package com.bit.model.service;

import java.util.List;


import com.bit.model.dto.space.SpaceUserInfoDTO;
import com.bit.model.dto.space.DraftCard;

public interface SpaceService {
	 public List<DraftCard> getSavedDraft();
	 public List<SpaceUserInfoDTO> getSpaceUserInfo(int userNo, String spaceCode);
}
