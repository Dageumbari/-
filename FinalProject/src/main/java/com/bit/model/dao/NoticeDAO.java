package com.bit.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;


import com.bit.model.dto.NoticeCriteriaDTO;
import com.bit.model.vo.NoticeVO;


@Mapper

public interface NoticeDAO {
   public List<NoticeVO> getAllNoticeInfo();
   public void insert(NoticeVO notice); //register
   public NoticeVO read(int noticeNo); //get
   public int delete(int noticeNO);   //remove
   public int update(NoticeVO notice); //modify
   public List<NoticeVO> getListwithPaging(NoticeCriteriaDTO noticeCriteria);   
   public int getTotalNoticeCount(NoticeCriteriaDTO noticeCriteria); //전체데이터 갯수
}
