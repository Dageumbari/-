/*
 * package com.bit.model.serviceImpl;
 * 
 * import java.util.List;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.stereotype.Service;
 * 
 * import com.bit.model.dao.NoticeDAO; import
 * com.bit.model.dto.NoticeCriteriaDTO; import
 * com.bit.model.service.NoticeService; import com.bit.model.vo.NoticeVO;
 * 
 * import lombok.Builder; import lombok.extern.log4j.Log4j2;
 * 
 * @Log4j2
 * 
 * @Service
 * 
 * @Builder public class NoticeServiceImpl implements NoticeService {
 * 
 * @Autowired(required = false) private NoticeDAO noticeDAO;
 * 
 * @Override public List<NoticeVO> getAllNoticeInfo(NoticeCriteriaDTO noticeCri)
 * { // TODO Auto-generated method stub
 * log.info("Get notice PageList w/ criteria:" + noticeCri); return
 * noticeDAO.getListwithPaging(noticeCri); }
 * 
 * @Override public void register(NoticeVO notice) { // TODO Auto-generated
 * method stub log.info("공지작성 :" + notice); noticeDAO.insert(notice);
 * 
 * }
 * 
 * public NoticeVO get(int noticeNO) { // TODO Auto-generated method stub
 * log.info("공지조회 : "+noticeNO); return noticeDAO.read(noticeNO); }
 * 
 * @Override public boolean modify(NoticeVO notice) { // TODO Auto-generated
 * method stub log.info("공지수정 :"+notice); return noticeDAO.update(notice)==1; }
 * 
 * @Override public boolean remove(int noticeNo) { // TODO Auto-generated method
 * stub log.info("공지삭제: "+noticeNo); return noticeDAO.delete(noticeNo)==1; }
 * 
 * @Override public int getTotalNoticeCount(NoticeCriteriaDTO noticeCriteria) {
 * // TODO Auto-generated method stub return
 * noticeDAO.getTotalNoticeCount(noticeCriteria); } }
 */

package com.bit.model.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bit.model.dao.NoticeDAO;
import com.bit.model.service.NoticeService;
import com.bit.model.vo.NoticeVO;

import lombok.Builder;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
@Builder
public class NoticeServiceImpl implements NoticeService {

   @Autowired(required = false)
   private NoticeDAO noticeDAO;

   @Override
   public List<NoticeVO> getAllNoticeInfo() {
      // TODO Auto-generated method stub
      return noticeDAO.getAllNoticeInfo();
   }

   @Override
   public void register(NoticeVO notice) {
      // TODO Auto-generated method stub
      log.info("공지작성 :" + notice);
      noticeDAO.insert(notice);
      
   }
   
   public NoticeVO get(int noticeNO) {
      // TODO Auto-generated method stub
      log.info("공지조회 : "+noticeNO);
      return noticeDAO.read(noticeNO);
   }

   @Override
   public boolean modify(NoticeVO notice) {
      // TODO Auto-generated method stub
      log.info("공지수정 :"+notice);
      return noticeDAO.update(notice)==1;
   } 

   @Override
   public boolean remove(int noticeNo) {
      // TODO Auto-generated method stub
      log.info("공지삭제: "+noticeNo);
      return noticeDAO.delete(noticeNo)==1;
   }
}