package com.bit.model.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bit.model.dao.TeamDAO;
import com.bit.model.service.TeamService;

@Service
public class TeamServiceImpl implements TeamService {

	@Autowired
	TeamDAO teamDAO;
}
