package com.bit.model.service;

import java.util.List;

import com.bit.model.vo.PageVO;

public interface PageService {
	public List<PageVO> getPageList();
	public int pageSave(PageVO pv);
	public PageVO getPageDetail(PageVO pv);
	//public int pageUpdate(PageVO pv);

}
