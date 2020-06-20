package com.bit.model.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.bit.model.dao.ChatDAO;
import com.bit.model.service.ChatService;  
import com.bit.model.vo.ChattingVO;

public class ChatServiceImpl implements ChatService {
	@Autowired
	ChatDAO chatDAO;
	@Override
	public List<ChattingVO> getChatting() {
		// TODO Auto-generated method stub
		return chatDAO.getChatting();
	}
}
