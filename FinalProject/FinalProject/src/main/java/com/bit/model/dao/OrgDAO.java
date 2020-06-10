package com.bit.model.dao;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.bit.model.vo.DashBoardVO;

@Mapper
public interface OrgDAO {

	public List<DashBoardVO> getAllOrgList();
}
