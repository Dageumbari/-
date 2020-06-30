package com.bit.model.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.bit.model.dto.UserDTO;


@Mapper
public interface MainDAO {

	public UserDTO getUserAllInfo(String email); // login에서 입력받은 회원 정보 가져오기
	
	public String getJoinCheck(String email); // 유저 아이디 중복 체크
	
	public void setUserInfo(UserDTO userDTO); // join에서 들어온 정보로 회원 가입
	
	public void setAdminInfo(UserDTO userDTO); // admin 정보 입력
	
	public void setEmailCheck(String email, String key); // 회원가입한 유저 이메일 인증
	
	public void setLoginFailCount(String email); // 로그인 실패시 유저 실패카운트 증가
	
	@Select("select loginFailCount from user_info where email = #{email}")
	public int getLoginFailCount(String email); // 실패카운트 
	
	@Update("update user_info set user_info.loginFailCount = 0 where user_info.email = #{email}")
	public void setLoginFailCountReset(String email);
	
	@Update("update user_info set user_info.pw = #{encodeKey} where user_info.email = #{email}")
	public void setForgotPassword(String encodeKey, String email);
	
	@Update("update user_info set user_info.name = #{name} where user_info.email = #{email}")
	public void setName(String name, String email);
	
}
