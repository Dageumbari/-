
package com.bit;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.bit.model.dao.PageDAO;
<<<<<<< HEAD

=======
>>>>>>> 57641a5a7cac90665a03f2b4f761bf577b6228f1

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


