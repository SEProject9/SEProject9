package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import pojo.IndustryInfo;
import service.IndustryInfoService;

@Controller
@RequestMapping("")
public class ListAll {
	@Autowired
	IndustryInfoService indInfoSer;

	@RequestMapping("listIndustryInfo")
	public String listIndustryInfo() {
		List<IndustryInfo> list = indInfoSer.list(null);
		for (IndustryInfo info : list)
			System.out.println(info.toString());
		return "industry-info";
	}

}
