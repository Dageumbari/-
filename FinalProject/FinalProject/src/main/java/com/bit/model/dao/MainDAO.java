package com.bit.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.bit.model.vo.UserInfoVO;

@Mapper
public interface MainDAO {
	
	public List<UserInfoVO> getUserInfo();
	
}
