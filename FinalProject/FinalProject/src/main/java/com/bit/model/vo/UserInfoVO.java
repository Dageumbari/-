package com.bit.model.vo;

import java.sql.Timestamp;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserInfoVO {
	private int userNo;
	private String email;
	private String pw;
	private String name;
	private String userImage;
	private int alert;
	private String gender;
	private int loginFailCount;
	private Timestamp loginCountDate;
	private int countryCode;
}
