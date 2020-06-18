package com.bit.model.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class SpaceVO {
	private String spaceCode;
	private String groupCode;
	private String spaceName;
	private String spaceImage;
	private String spaceUrl;
	private int spaceOrder;
	private String spaceVisibility;
	private String teamCode;
}
