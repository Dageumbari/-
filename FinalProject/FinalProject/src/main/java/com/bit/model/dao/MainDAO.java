package com.bit.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.bit.model.vo.UserVO;

@Mapper
public interface MainDAO {
	
	public List<UserVO> getUserInfo();
	
}
