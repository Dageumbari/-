package com.bit.model.vo;

import java.io.Serializable;
import java.sql.Timestamp;

import org.apache.ibatis.type.Alias;
import org.springframework.context.annotation.Bean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;



@Getter
@Setter
@ToString
@Alias("chatting")
public class ChattingVO implements Serializable {
	private static final long serialVersionUID = 1L; //suid defalut로 명시~
public ChattingVO getChatting() {
	return new ChattingVO();
	} //bean annotation x 
	private String userNo;
	private String email;
	private String userImage;
    private int chatNo;
    private Timestamp msgSendTime;
    private Timestamp msgGotTime;
    private String chatContent;
    private int adminCode;
    private String adminId;
    private String adminPW;
}



