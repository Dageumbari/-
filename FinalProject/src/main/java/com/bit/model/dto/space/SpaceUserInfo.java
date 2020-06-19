package com.bit.model.dto.space;

import org.apache.ibatis.type.Alias;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Alias("spaceUserInfo")
public class SpaceUserInfo {
 	private String spaceCode;
	private String spaceName;
	private String spaceUrl;
	private String name;
	private int userNo;
	private String userImage;
	
}
