package com.bit.model.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.bit.model.vo.PageVO;

@Mapper
public interface PageDAO {
	//pageNo로 page 조회
	
	
	  @Select("select * from page where pageNo=1") 
	  PageVO getPageVO(int PageNo);
	 
	//public PageVO getPagebyPageNo(int pageNo);
	
	
}
