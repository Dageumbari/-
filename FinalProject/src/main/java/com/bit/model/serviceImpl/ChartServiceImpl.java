package com.bit.model.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bit.model.dao.ChartDAO;
import com.bit.model.dto.ChartDTO;
import com.bit.model.service.ChartService;


@Service
public class ChartServiceImpl implements ChartService {

	@Autowired
	private ChartDAO chartDAO;
	
	@Override
	public List<ChartDTO> getLoginDate() {
		// TODO Auto-generated method stub
		return chartDAO.selectLoginDate();
	}

}
