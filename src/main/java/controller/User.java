package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import pojo.Industry;
import pojo.TechSerReq;
import pojo.TechSerSup;
import service.IndustryService;
import service.TechSerReqService;
import service.TechSerSupService;

@Controller
@RequestMapping("user")
public class User {

	@Autowired
	IndustryService indSer;
	@Autowired
	TechSerReqService reqSer;
	@Autowired
	TechSerSupService supSer;

	@RequestMapping("techSerReq-add")
	public ModelAndView techSerReqAdd() {
		ModelAndView mav = new ModelAndView();
		List<Industry> list = indSer.list();

		// 放入转发参数
		mav.addObject("info", list);
		// 放入jsp路径
		mav.setViewName("user/techSerReq-add");
		return mav;
	}

	@RequestMapping("techSerSup-add")
	public ModelAndView techSerSupAdd() {
		ModelAndView mav = new ModelAndView();
		List<Industry> list = indSer.list();

		// 放入转发参数
		mav.addObject("info", list);
		// 放入jsp路径
		mav.setViewName("user/techSerSup-add");
		return mav;
	}

	@RequestMapping("techSerReq-save")
	public ModelAndView techSerReqSave(TechSerReq req) {
		ModelAndView mav = new ModelAndView();
		req = reqSer.add(req);
		if (null == req)
			mav.setViewName("fore/error");

		mav.addObject("msg", "add success!");
		// 放入转发参数
		mav.addObject("info", req);
		// 放入jsp路径
		mav.setViewName("user/techSerReq-show");
		return mav;
	}

	@RequestMapping("techSerSup-save")
	public ModelAndView techSerSupSave(TechSerSup sup) {
		ModelAndView mav = new ModelAndView();
		sup = supSer.add(sup);
		if (null == sup)
			mav.setViewName("fore/error");

		mav.addObject("msg", "add success!");
		// 放入转发参数
		mav.addObject("info", sup);
		// 放入jsp路径
		mav.setViewName("user/techSerSup-show");
		return mav;
	}

}
