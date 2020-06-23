package com.bit.model.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bit.model.dao.OrgDAO;
import com.bit.model.service.OrgService;
import com.bit.model.vo.DashBoardVO;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class OrgServiceImpl implements OrgService {
	
	@Autowired
	OrgDAO orgDAO;
	
	public OrgServiceImpl() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public List<DashBoardVO> getAllOrgList() {
		return orgDAO.getAllOrgList();
	}

	@Override
	public DashBoardVO getOrgInfo(String dashBoardCode) {
		// TODO Auto-generated method stub
		return orgDAO.getOrgInfo(dashBoardCode);
	}

	@Override
	public DashBoardVO orgNameModify(DashBoardVO dashBoardVO) {
		// TODO Auto-generated method stub
		return orgDAO.orgNameModify(dashBoardVO);
	}

	@Override
	public DashBoardVO orgURLModify(DashBoardVO dashBoardVO) {
		// TODO Auto-generated method stub
		return orgDAO.orgURLModify(dashBoardVO);
	}
}
