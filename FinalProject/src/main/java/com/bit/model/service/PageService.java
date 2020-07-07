package com.bit.model.service;

import java.util.List;

import com.bit.model.vo.PageVO;

public interface PageService {
	public List<PageVO> getPageList(); //페이지 리스트
	public int pageSave(PageVO pv); //페이지 저장
	public PageVO getPageDetailVo(PageVO pv);
	public PageVO getPageDetail(int pageNo); //페이지 상세보기
	/* public int getPageUpdate(PageVO pv); */
	//public int pagePudate(PageVO pv);
	public int deletePage(int pageNo); 
	void draftSave();
}
