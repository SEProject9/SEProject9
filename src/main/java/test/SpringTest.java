package test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pojo.Diary;
import pojo.IndustryData;
import pojo.IndustryInfo;
import service.DiaryService;
import service.IndustryDataService;
import service.IndustryInfoService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})  
public class SpringTest {

//	@Autowired
//	private DiaryService diaSer;
//	@Autowired
//	private IndustryDataService inddata;
//	@Autowired
//	private IndustryInfoService indinfo;

	@Test
	public void testList() {
		ApplicationContext factory = new ClassPathXmlApplicationContext("classpath:applicationContext.*");
		System.out.println("syso");
//		List<IndustryInfo> list = indinfo.list(null);
//		for (IndustryInfo indData : list)
//			System.out.println(indData.toString());
	}

	/*public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		System.out.println(factory.getId());
		DiaryService dia = (DiaryService) factory.getBean("diaryServiceImpl");
		Diary d = new Diary();
		d.setAdmin_id(1);
		d.setDia_object("1");
		d.setDia_text("2");
		d.setDia_time("2");
		d.setDia_type("3");
		dia.add(d);

	}
*/
}
