package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import service.IndustryDataService;
import service.IndustryInfoService;

@Controller
@RequestMapping("admin")
public class Admin {

	@Autowired
	IndustryInfoService indInfoSer;
	@Autowired
	IndustryDataService indDataSer;

	@RequestMapping("login")
	public String login() {
		return "user/index";
	}

	/*@RequestMapping("ind-data-show")
	public ModelAndView indDataShow(Page page, @RequestParam("dataId") Integer dataId) {
		ModelAndView mav = new ModelAndView();
		IndustryData info = indDataSer.show(dataId);
		int total = (int) new PageInfo<>(info).getTotal();
	
		page.caculateLast(total);
	
		// 放入转发参数
		mav.addObject("info", info);
		// 放入jsp路径
		mav.setViewName("admin/ind-info-show");
		return mav;
	}*/
}
