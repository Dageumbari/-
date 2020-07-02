package com.bit.model.vo;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class DashBoardVO {
	private String dashBoardCode;
	private String dashBoardImage;
	private String dashBoardName;
	private String dashBoardType;
	private String dashBoardUrl;
	
	@Autowired(required = false)
	private GroupVO groupInfo;
	@Autowired(required = false)
	private TeamVO team;
	@Autowired(required = false)
	private MemPermitVO memPermit;
}


