package com.bit.model.service;

import java.util.List;

import com.bit.model.vo.NoticeVO;

public interface NoticeService {
	public List<NoticeVO> getAllNoticeInfo(); 
	//public List<NoticeVO> getAllNoticeInfo(NoticeCriteriaDTO noticeCri); 
	public void register(NoticeVO notice);
	public NoticeVO get(int noticeNO);
	public boolean modify(NoticeVO notice);
	public boolean remove(int noticeNo);
	//public int getTotalNoticeCount(NoticeCriteriaDTO noticeCriteria);
	
}
