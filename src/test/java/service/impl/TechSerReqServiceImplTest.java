package service.impl;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pojo.TechSerReq;
import service.TechSerReqService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class TechSerReqServiceImplTest {

	@Autowired
	private TechSerReqService req;

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testAdd() {
		TechSerReq reqP = new TechSerReq();
		reqP.setEnt_id(1);
		reqP.setReq_title("c语言工程师需求");
		System.out.println(req.add(reqP));
	}

	@Test
	public void testSearchByUser() {
		TechSerReq reqP = new TechSerReq();
		List<TechSerReq> list = req.searchByUser(reqP);
		for (TechSerReq tec : list)
			System.out.println(tec.getReq_title());
	}

	@Test
	public void testShow() {
		TechSerReq reqP = req.show(1);
		System.out.println(reqP.getReq_title());

	}

}
