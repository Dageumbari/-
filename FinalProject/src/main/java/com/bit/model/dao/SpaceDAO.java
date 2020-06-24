package com.bit.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.bit.model.dto.space.DraftListDTO;
import com.bit.model.dto.space.SpaceUserInfoDTO;

@Mapper
public interface SpaceDAO {

	// 스페이스 유저 정보
	public SpaceUserInfoDTO getSpaceUserInfo();

	// draftsList
	public List<DraftListDTO> getDraftList();

	public List<DraftListDTO> getMergedList();

	public List<DraftListDTO> getArchivedList();
}