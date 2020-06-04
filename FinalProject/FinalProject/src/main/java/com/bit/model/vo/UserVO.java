package com.bit.model.vo;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserVO {
	private int UserNo;
	private String email;
	private String passward;
	private String name;
	private String userImage;
	private int alert;
	private String gender;
	private int loginFallCount;
	private Date loginCountDate;
	private String country;
}
