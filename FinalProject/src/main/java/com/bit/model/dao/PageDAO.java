package com.bit.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.bit.model.vo.PageVO;

@Mapper
public interface PageDAO {
	List<PageVO> getPageList();
	int pageSave(PageVO pv);
	PageVO getPageDetailVo(PageVO pv);
	PageVO getPageDetail(int pageNo);
	//int PageUpdate(PageVO pv);
	
	//int delete(int PageNo);
	/*public PageVO insertPage(PageVO params);
	public PageVO selectPageDetail(int pageNO);
	public int updatePage(PageVO params);
	public int deletePage(int pageNO);
	public List<PageVO> selectPageList();
	public int selectPageTotalCount();*/
}
