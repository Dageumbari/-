package com.bit.model.dto;

import org.springframework.beans.factory.annotation.Autowired;

import com.bit.model.vo.MemPermitVO;
import com.bit.model.vo.PermissionVO;
import com.bit.model.vo.UserInfoVO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MemberDTO {
	
	//팀 , 멤버권한, 권한 테이블 -> 각 vo파일 삭제하기?
	public String dashBoardCode;
	public String teamCode;
	public String teamName;
	
	@Autowired(required = false)
	private MemPermitVO memPermitVO;
	//public int permissionNo;
	//public String permissionName;
	
	@Autowired(required = false)
	private PermissionVO permissionVO;
	
	//유저테이블
	@Autowired(required = false)
	private UserInfoVO userInfoVO;
	//public int userNo;
	//public String userName;
	//public String userImage;
}
