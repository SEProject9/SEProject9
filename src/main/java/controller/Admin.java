package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import pojo.IndustryData;
import pojo.IndustryInfo;
import service.IndustryDataService;
import service.IndustryInfoService;
import util.Page;

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

	@RequestMapping("ent-list")
	public ModelAndView entList(Page page) {
		ModelAndView mav = new ModelAndView();
		PageHelper.offsetPage(page.getStart(), 5);
		List<IndustryInfo> info = indInfoSer.list(null);
		int total = (int) new PageInfo<>(info).getTotal();

		System.out.println(page.getStart());

		page.caculateLast(total);

		// 放入转发参数
		mav.addObject("info", info);
		// 放入jsp路径
		mav.setViewName("ind-info-list");
		return mav;
	}

	@RequestMapping("ind-info-list")
	public ModelAndView indInfoList(Page page) {
		ModelAndView mav = new ModelAndView();
		PageHelper.offsetPage(page.getStart(), 8);
		List<IndustryInfo> info = indInfoSer.list(null);
		/*System.out.println("info list:" + info.size());
		for (IndustryInfo i : info) {
			System.out.println(i.toString());
		}*/
		int total = (int) new PageInfo<>(info).getTotal();

		System.out.println("info:" + page.getStart());

		page.caculateLast(total);

		// 放入转发参数
		mav.addObject("info", info);
		// 放入jsp路径
		mav.setViewName("ind-info-list");
		return mav;
	}

	@RequestMapping("ind-data-list")
	public ModelAndView indDataList(Page page) {
		ModelAndView mav = new ModelAndView();
		PageHelper.offsetPage(page.getStart(), 8);
		List<IndustryData> info = indDataSer.list(null);
		int total = (int) new PageInfo<>(info).getTotal();

		page.caculateLast(total);

		// 放入转发参数
		mav.addObject("info", info);
		// 放入jsp路径
		mav.setViewName("ind-info-list");
		return mav;
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
