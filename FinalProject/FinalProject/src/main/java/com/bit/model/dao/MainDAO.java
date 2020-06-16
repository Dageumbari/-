package com.bit.model.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.bit.model.dto.UserDTO;


@Mapper
public interface MainDAO {

	public UserDTO getUserAllInfo(String email);
	
	public void setUserInfo(UserDTO userDTO);
	
	@Select("select userNo from user_info where user_info.email = #{email}")
	public int getUserNo(String email);
	
}
