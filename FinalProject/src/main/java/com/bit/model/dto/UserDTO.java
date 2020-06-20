package com.bit.model.dto;


import java.sql.Timestamp;
import java.util.List;

import com.bit.model.vo.UserRoleVO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserDTO {
	
	private int userNo;
	private String email;
	private String pw;
	private String name;
	private String userImage;
	private int alert;
	private String gender;
	private int loginFailCount;
	private Timestamp loginCountDate;
	private int countryCode;
	private String Key;
	
	private List<UserRoleVO> roles;
	
}
