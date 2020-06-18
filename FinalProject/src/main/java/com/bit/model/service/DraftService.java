package com.bit.model.service;

import java.util.List;

<<<<<<< HEAD:FinalProject/FinalProject/src/main/java/com/bit/model/service/SpaceService.java

import com.bit.model.dto.space.SpaceUserInfoDTO;
import com.bit.model.dto.space.DraftCard;

public interface SpaceService {
	 public List<DraftCard> getSavedDraft();
	 public List<SpaceUserInfoDTO> getSpaceUserInfo(int userNo, String spaceCode);
=======
import com.bit.model.dto.space.DraftDTO;

public interface DraftService {
	public List<DraftDTO> getDraftList();
}
