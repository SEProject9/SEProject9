package mapper;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pojo.TechSerSup;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class TechSerSupMapperTest {

	@Autowired
	TechSerSupMapper supMapper;

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testListByState() {
		TechSerSup sup = new TechSerSup();
		sup.setEnt_id(1);
		List<TechSerSup> list = supMapper.listByState(1);
		for (TechSerSup suplist : list)
			System.out.println(suplist.toString());
	}

}
