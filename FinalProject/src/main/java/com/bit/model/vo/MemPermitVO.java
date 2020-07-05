package com.bit.model.vo;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MemPermitVO {
	private String teamCode;
	private int userNo;
	private int permissionNo;

	@Autowired(required = false)
	private UserInfoVO userInfo;
	
}
