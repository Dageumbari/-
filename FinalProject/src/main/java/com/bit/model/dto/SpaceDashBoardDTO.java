package com.bit.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class SpaceDashBoardDTO {

	//groupInfo  테이블
	public String dashBoardCode;
	public String groupCode;
	public String groupName;
	public String groupOrder;
	
	//space 테이블
	public String spaceCode;
	public String spaceName;
	public String spaceImage;
	public String spaceUrl;
	public int spaceOrder;
	public String spaceVisibility;
	
}
