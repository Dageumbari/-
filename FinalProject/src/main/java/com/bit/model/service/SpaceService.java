package com.bit.model.service;

import java.util.List;

import com.bit.model.dto.space.DraftCard;
import com.bit.model.dto.space.SpaceUserInfo;

public interface SpaceService {
	 public SpaceUserInfo getSpaceUserInfo(int userNo, String spaceCode);

}
