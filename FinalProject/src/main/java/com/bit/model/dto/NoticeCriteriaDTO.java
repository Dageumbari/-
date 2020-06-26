package com.bit.model.dto;

import org.apache.ibatis.type.Alias;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Alias("noticeCriteria")
public class NoticeCriteriaDTO {
   private int pageNo;
   private int noticeAmount;
   
   private String type;
   private String keyword;
   
   public NoticeCriteriaDTO() {
      this(1,10);
   }
   
   public NoticeCriteriaDTO(int pageNo, int noticeAmount) {
      super();
      this.pageNo = pageNo;
      this.noticeAmount = noticeAmount;
   }
   
   public String[] getTypeArr() { //검색조건지정
      return type==null? new String[] {} : type.split("");
   }
   
}
