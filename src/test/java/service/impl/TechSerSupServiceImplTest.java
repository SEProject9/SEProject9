package service.impl;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pojo.TechSerSup;
import service.TechSerSupService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class TechSerSupServiceImplTest {

	@Autowired
	private TechSerSupService sup;

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testAdd() {

		TechSerSup supP = new TechSerSup();
		supP.setSup_title("asd");
		sup.add(supP);

	}

	@Test
	public void testSearchByUser() {
		TechSerSup supP = new TechSerSup();
		supP.setState(1);
		List<TechSerSup> list = sup.searchByUser(supP);
		for (TechSerSup tec : list)
			System.out.println(tec.getSup_title());

	}

	@Test
	public void testShow() {
		fail("Not yet implemented");
	}

}
