package com.bit.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.bit.model.dto.space.DraftDTO;

@Mapper
public interface SpaceDAO {
	
	//draft- saved
	List<DraftDTO> getSavedDraft();
	
	
}
