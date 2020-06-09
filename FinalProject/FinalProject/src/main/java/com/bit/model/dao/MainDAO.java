package com.bit.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.bit.model.vo.UserInfoVO;

@Mapper
public interface MainDAO {
	
	@Select("select * from user_info")
	public List<UserInfoVO> getUserInfo();
	
}
