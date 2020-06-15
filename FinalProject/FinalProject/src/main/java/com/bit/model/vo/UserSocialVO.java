package com.bit.model.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserSocialVO {
	private int userSocialNo;
	private int userNo;
	private String userToken;
	private String userTokenName;
}
