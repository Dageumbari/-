package com.bit.model.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bit.model.dao.PageDAO;
import com.bit.model.service.PageService;
import com.bit.model.vo.PageVO;

@Service("PageService")
public class PageServiceImpl implements PageService {

	@Autowired
	PageDAO pageDAO;

	@Override
	public List<PageVO> getPageList() {
		return pageDAO.getPageList();
	}

	@Override
	public int pageSave(PageVO pv) {
		return pageDAO.pageSave(pv);
	}
	
	@Override
	public PageVO getPageDetail(PageVO pv) {
		return pageDAO.getPageDetail(pv);
	}

	/*
	 * @Override public int pagePudate(PageVO pv) { return pageDAO.PageUpdate(pv); }
	 */
}