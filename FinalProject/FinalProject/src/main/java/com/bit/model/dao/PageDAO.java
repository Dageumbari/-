package com.bit.model.dao;


import org.apache.ibatis.annotations.Mapper;

import com.bit.model.vo.PageVO;

@Mapper
public interface PageDAO {
	//pageNo로 page 조회
	
	public PageVO getPagebyPageNo(int pageNo);
	/*
	 * @Select("select * from page where pageNo=1") PageVO getPageVO(int PageNo);
	 */
	 
}
	

