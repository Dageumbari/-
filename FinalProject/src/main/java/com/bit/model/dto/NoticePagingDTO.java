
  package com.bit.model.dto;
  
  import lombok.Getter; import lombok.Setter; import lombok.ToString;
  
  @Getter
  
  @Setter
  
  @ToString public class NoticePagingDTO { private int noticeStartPage; private
  int noticeEndPage; private boolean prev,next;
  
  private int noticetotal; private NoticeCriteriaDTO noticeCri; public
  NoticePagingDTO(NoticeCriteriaDTO noticeCri, int noticetotal) { super();
  
  this.noticeEndPage = (int)(Math.ceil(noticeCri.getPageNo()/10.0))*10;
  this.noticeStartPage = this.noticeEndPage-9; int realNoticeEnd
  =(int)(Math.ceil((noticetotal*1.0)/noticeCri.getNoticeAmount()));
  
  if (realNoticeEnd < this.noticeEndPage) { this.noticeEndPage=realNoticeEnd; }
  
  this.prev = this.noticeStartPage>1; this.next = this.noticeEndPage <
  realNoticeEnd;
  
  this.noticetotal = noticetotal; this.noticeCri = noticeCri; } }
 