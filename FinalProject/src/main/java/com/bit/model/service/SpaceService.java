package com.bit.model.service;

import java.util.List;

import com.bit.model.dto.SpaceDTO;

public interface SpaceService {
	 public List<SpaceDTO> getSpaceUserInfo(int userNo, String spaceCode);

}
