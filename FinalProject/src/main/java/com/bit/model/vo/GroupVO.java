package com.bit.model.vo;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class GroupVO {
	private String groupCode;
	private String dashBoardCode;
	private String groupName;
	private String groupOrder;
}
