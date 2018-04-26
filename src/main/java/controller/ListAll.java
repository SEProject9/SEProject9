package controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import pojo.Enterprise;
import pojo.EnterpriseInfo;
import pojo.Industry;
import pojo.IndustryData;
import pojo.IndustryInfo;
import pojo.TechSerReq;
import pojo.TechSerSup;
import service.EnterpriseInfoService;
import service.EnterpriseService;
import service.IndustryDataService;
import service.IndustryInfoService;
import service.IndustryService;
import service.TechSerReqService;
import service.TechSerSupService;
import util.Page;

@Controller
@RequestMapping("list")
public class ListAll {
	@Autowired
	IndustryService indSer;
	@Autowired
	IndustryInfoService indInfoSer;
	@Autowired
	IndustryDataService indDataSer;
	@Autowired
	TechSerReqService reqSer;
	@Autowired
	TechSerSupService supSer;
	@Autowired
	EnterpriseService entSer;
	@Autowired
	EnterpriseInfoService entInfoSer;

	@RequestMapping({ "entInfo-list", "entInfo-search" })
	public ModelAndView entInfoList(Page page, EnterpriseInfo entInfo) {
		ModelAndView mav = new ModelAndView();
		PageHelper.offsetPage(page.getStart(), 20);
		List<EnterpriseInfo> info = entInfoSer.searchByUser(entInfo);
		int total = (int) new PageInfo<>(info).getTotal();

		page.caculateLast(total);

		List<Industry> list1 = indSer.list();
		mav.addObject("ind_id", entInfo.getInd_id());
		mav.addObject("ind", list1);
		mav.addObject("info", info);
		mav.setViewName("user/entInfo-list");
		return mav;
	}

	@RequestMapping("indInfo-list")
	public ModelAndView indInfoList(Page page) {
		ModelAndView mav = new ModelAndView();
		PageHelper.offsetPage(page.getStart(), 20);
		List<IndustryInfo> info = indInfoSer.list(null, null);
		/*System.out.println("info list:" + info.size());
		for (IndustryInfo i : info) {
			System.out.println(i.toString());
		}*/
		int total = (int) new PageInfo<>(info).getTotal();

		page.caculateLast(total);

		List<Industry> list1 = indSer.list();
		mav.addObject("ind", list1);
		// 放入转发参数
		mav.addObject("info", info);
		// 放入jsp路径
		mav.setViewName("indInfo-list");
		return mav;
	}

	@RequestMapping("indData-list")
	public ModelAndView indDataList(Page page) {
		ModelAndView mav = new ModelAndView();
		PageHelper.offsetPage(page.getStart(), 20);
		List<IndustryData> info = indDataSer.list(null, null);
		int total = (int) new PageInfo<>(info).getTotal();

		page.caculateLast(total);

		List<Industry> list1 = indSer.list();
		// 放入转发参数
		mav.addObject("ind", list1);
		// 放入转发参数
		mav.addObject("info", info);
		// 放入jsp路径
		mav.setViewName("indData-list");
		return mav;
	}

	@RequestMapping("techSer-list")
	public ModelAndView techSerList(Page page, Integer type, Integer state, HttpSession session) {

		ModelAndView mav = new ModelAndView();
		PageHelper.offsetPage(page.getStart(), 20);// 只能针对一张表 不能两表共查
		int total;

		Enterprise ent = (Enterprise) session.getAttribute("user");
		if (null == ent) {
			mav.addObject("msg", "请进行登录");
			mav.setViewName("fore/error");
			return mav;
		}

		Integer ent_id = ent.getEnt_id();
		if (null != type && 2 == type) {
			System.out.println("req");
			List<TechSerReq> req = reqSer.listByEnt(state, ent_id);
			total = (int) new PageInfo<>(req).getTotal();
			mav.addObject("info", req);
		} else {
			List<TechSerSup> sup = supSer.listByEnt(state, ent_id);
			total = (int) new PageInfo<>(sup).getTotal();
			mav.addObject("info", sup);
		}

		page.caculateLast(total);
		// 放入jsp路径
		mav.addObject("state", state);
		mav.addObject("type", type);
		mav.setViewName("user/techSer-list");
		return mav;
	}

	@RequestMapping("techSerReq-list")
	public ModelAndView techSerReqList(Page page) {
		ModelAndView mav = new ModelAndView();
		PageHelper.offsetPage(page.getStart(), 20);
		List<TechSerReq> info = reqSer.searchByUser(null);
		int total = (int) new PageInfo<>(info).getTotal();

		page.caculateLast(total);
		List<Industry> list1 = indSer.list();

		// 放入转发参数
		mav.addObject("ind", list1);
		// 放入转发参数
		mav.addObject("info", info);
		// 放入jsp路径
		mav.setViewName("user/techSerReq-list");
		return mav;
	}

	@RequestMapping("techSerSup-list")
	public ModelAndView techSerSupList(Page page) {
		ModelAndView mav = new ModelAndView();
		PageHelper.offsetPage(page.getStart(), 20);
		List<TechSerSup> info = supSer.searchByUser(null);
		int total = (int) new PageInfo<>(info).getTotal();

		page.caculateLast(total);

		List<Industry> list1 = indSer.list();

		// 放入转发参数
		mav.addObject("ind", list1);
		// 放入转发参数
		mav.addObject("info", info);
		// 放入jsp路径
		mav.setViewName("user/techSerSup-list");
		return mav;
	}

	@RequestMapping("indInfo-search")
	public ModelAndView indInfoSearch(Page page, @RequestParam("ind_id") Integer id,
			@RequestParam("title") String title) {
		ModelAndView mav = new ModelAndView();
		PageHelper.offsetPage(page.getStart(), 20);
		List<IndustryInfo> info = indInfoSer.list(id, title);
		int total = (int) new PageInfo<>(info).getTotal();

		page.caculateLast(total);

		List<Industry> list1 = indSer.list();

		// 放入转发参数
		mav.addObject("ind", list1);
		// 放入转发参数
		mav.addObject("info", info);
		// 放入jsp路径
		mav.setViewName("indInfo-list");
		return mav;
	}

	@RequestMapping("indData-search")
	public ModelAndView indDataSearch(Page page, @RequestParam("ind_id") Integer id,
			@RequestParam("title") String title) {
		ModelAndView mav = new ModelAndView();
		PageHelper.offsetPage(page.getStart(), 20);
		List<IndustryData> info = indDataSer.list(id, title);
		int total = (int) new PageInfo<>(info).getTotal();

		page.caculateLast(total);

		List<Industry> list1 = indSer.list();

		// 放入转发参数
		mav.addObject("ind", list1);
		// 放入转发参数
		mav.addObject("info", info);
		// 放入jsp路径
		mav.setViewName("indData-list");
		return mav;
	}

	@RequestMapping("techSerReq-search")
	public ModelAndView techSerReqSearch(Page page, TechSerReq req) {
		ModelAndView mav = new ModelAndView();
		PageHelper.offsetPage(page.getStart(), 20);
		List<TechSerReq> info = reqSer.searchByUser(req);
		int total = (int) new PageInfo<>(info).getTotal();

		page.caculateLast(total);
		List<Industry> list1 = indSer.list();

		// 放入转发参数
		mav.addObject("ind", list1);
		// 放入转发参数
		mav.addObject("info", info);
		// 放入jsp路径
		mav.setViewName("user/techSerReq-list");
		return mav;
	}

	@RequestMapping("techSerSup-search")
	public ModelAndView techSerSupSearch(Page page, TechSerSup sup) {
		ModelAndView mav = new ModelAndView();
		PageHelper.offsetPage(page.getStart(), 20);
		List<TechSerSup> info = supSer.searchByUser(sup);
		int total = (int) new PageInfo<>(info).getTotal();

		page.caculateLast(total);

		List<Industry> list1 = indSer.list();

		// 放入转发参数
		mav.addObject("ind", list1);
		// 放入转发参数
		mav.addObject("info", info);
		// 放入jsp路径
		mav.setViewName("user/techSerSup-list");
		return mav;
	}

	/*0:游客
	其他值(自身或其他企业信息)*/
	@RequestMapping(value = "entInfo-show/{id}")
	public ModelAndView entInfoShow(@PathVariable Integer id, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		if (null == id || id.equals("") || 0 == id) {
			mav.addObject("msg", "请进行登录");
			mav.setViewName("fore/error");
			return mav;
		}

		EnterpriseInfo entInfo = entInfoSer.show(id);
		if (null == entInfo) {
			mav.addObject("msg", "不存在该企业");
			mav.setViewName("fore/error");
			return mav;
		}
		mav.addObject("info", entInfo);
		// 放入jsp路径
		mav.setViewName("user/entInfo-show");
		return mav;
	}

	@RequestMapping("indInfo-show")
	public ModelAndView indInfoShow(@RequestParam("id") Integer id) {
		ModelAndView mav = new ModelAndView();

		IndustryInfo indInfo = indInfoSer.show(id);
		if (null == indInfo) {
			mav.addObject("msg", "no such record!");
			mav.setViewName("fore/error");
			return mav;
		}
		/*EnterpriseInfo entInfo = entInfoSer.show(req.getEnt_id());
		if (null != entInfo)
			mav.addObject("entInfo", entInfo);*/
		// 放入转发参数
		mav.addObject("info", indInfo);
		// 放入jsp路径
		mav.setViewName("user/indInfo-show");
		return mav;
	}

	@RequestMapping("indData-show")
	public ModelAndView indDataShow(@RequestParam("id") Integer id) {
		ModelAndView mav = new ModelAndView();

		IndustryData indData = indDataSer.show(id);
		if (null == indData) {
			mav.addObject("msg", "no such record!");
			mav.setViewName("fore/error");
			return mav;
		}
		/*EnterpriseInfo entInfo = entInfoSer.show(req.getEnt_id());
		if (null != entInfo)
			mav.addObject("entInfo", entInfo);*/
		// 放入转发参数
		mav.addObject("info", indData);
		// 放入jsp路径
		mav.setViewName("user/indData-show");
		return mav;
	}

	@RequestMapping("techSerReq-show")
	public ModelAndView techSerReqShow(@RequestParam("id") Integer id) {
		ModelAndView mav = new ModelAndView();

		TechSerReq req = reqSer.show(id);
		if (null == req) {
			mav.setViewName("error");
			return mav;
		}
		/*EnterpriseInfo entInfo = entInfoSer.show(req.getEnt_id());
		if (null != entInfo)
			mav.addObject("entInfo", entInfo);*/
		// 放入转发参数
		mav.addObject("info", req);
		// 放入jsp路径
		mav.setViewName("user/techSerReq-show");
		return mav;
	}

	@RequestMapping("techSerSup-show")
	public ModelAndView techSerSupShow(@RequestParam("id") Integer id) {

		ModelAndView mav = new ModelAndView();
		TechSerSup sup = supSer.show(id);
		if (null == sup) {
			mav.setViewName("error");
			return mav;
		}
		/*EnterpriseInfo entInfo = entInfoSer.show(req.getEnt_id());
		if (null != entInfo)
			mav.addObject("entInfo", entInfo);*/
		// 放入转发参数
		mav.addObject("info", sup);
		// 放入jsp路径
		mav.setViewName("user/techSerSup-show");
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
