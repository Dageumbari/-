package com.bit.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.bit.model.vo.NoticeVO;


@Mapper
@Repository
public interface NoticeDAO {
	List<NoticeVO> getAllNoticeInfo();
	void insert(NoticeVO notice); //register
	 NoticeVO read(int noticeNo); //get
	 int delete(int noticeNO);   //remove
	 int update(NoticeVO notice); //modify
	
	//@param안하고 그냥 다 불러버릴 것..
}

