package com.bit.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.bit.model.dto.space.SpaceUserInfoDTO;

@Mapper
public interface SpaceDAO {

	// 드래프트 리스트 불러오기

	public List<SpaceUserInfoDTO> getSpaceUserInfo();

}