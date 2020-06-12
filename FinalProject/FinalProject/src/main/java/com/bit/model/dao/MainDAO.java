package com.bit.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.bit.model.dto.UserDTO;

@Mapper
public interface MainDAO {
	
	public List<UserDTO> getUserInfo(String email);
	
}
