package com.bit.model.vo;

import org.apache.ibatis.type.Alias;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Alias("org")
public class DashBoardVO {
	private String dashBoardCode;
	private String dashBoardImage;
	private String dashBoardName;
	private String dashBoardType;
	private String dashBoardUrl;
}
