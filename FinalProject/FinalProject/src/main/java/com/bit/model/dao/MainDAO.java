package com.bit.model.dao;

import org.apache.ibatis.annotations.Mapper;
import com.bit.model.dto.UserDTO;


@Mapper
public interface MainDAO {

	public UserDTO getUserAllInfo(String email); // login에서 입력받은 회원 정보 가져오기
	
	public String getJoinCheck(String email); // 유저 아이디 중복 체크
	
	public void setUserInfo(UserDTO userDTO); // join에서 들어온 정보로 회원 가입
	
	public void setEmailCheck(String email, String key); // 회원가입한 유저 이메일 인증
	
}
