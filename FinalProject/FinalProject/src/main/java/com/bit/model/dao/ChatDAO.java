package com.bit.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.bit.model.vo.ChattingVO;

@Mapper
@Repository
public interface ChatDAO {
	public List<ChattingVO> getChatting();
}
