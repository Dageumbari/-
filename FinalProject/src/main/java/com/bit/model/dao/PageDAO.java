package com.bit.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.bit.model.vo.PageVO;

@Mapper
public interface PageDAO {
	List<PageVO> getPageList();
	int pageSave(PageVO pv);
	PageVO getPageDetail(PageVO pv); 
}



