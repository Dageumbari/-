package com.bit.model.vo;


import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Configuration
public class NoticeVO {
	private int noticeNo;
	private String noticeTitle;
	private Date noticeDate;
	private String noticeContent;
	private int adminCode;
	//private String adminId;
	
	@Autowired(required = false)
	AdminInfoVO adminInfoVO;
	
	@Bean
	public NoticeVO getAllNoticeInfo() {
		return new NoticeVO();
	}
}
