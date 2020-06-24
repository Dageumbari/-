package com.bit.model.dto;

import org.apache.ibatis.type.Alias;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Alias("spaceDTO")
public class SpaceDTO {
	private String spaceCode;
	private String spaceName;
	private String spaceUrl;
	private String spaceImage;
	private int spaceOrder;
	private String spaceVisibility;
	private int userNo;
	private String name;
	private String userImage;
}
