
package com.bit;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.bit.model.dao.PageDAO;


@SpringBootTest
public class PersistenceTest {
	@Autowired
	private PageDAO pageDAO;
	@Test
	public void pageDAOTest() {	
		
		//System.err.println(pageDAO.getPageVO(1));
		
		System.err.println(pageDAO.getPageList());		
	}

}


