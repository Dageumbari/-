package com.bit.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.bit.model.dto.ChartDTO;

@Mapper
public interface ChartDAO {
	public List<ChartDTO> selectLoginDate();
	//여기에 userNo parameter로 넣어주기? 

}
