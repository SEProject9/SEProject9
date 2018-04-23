package controller;

import java.util.List;
import net.sf.json.JSONObject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import pojo.Industry;
import pojo.TechSerReq;
import pojo.TechSerSup;
import service.IndustryService;
import service.TechSerReqService;
import service.TechSerSupService;

/*返回的跟路径在springmvc.xml中设置了为jsp*/
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
	public ModelAndView techSerReqAdd(@RequestParam(value = "id", required = false) Integer id) {
		ModelAndView mav = new ModelAndView();
		if (null != id) {
			JSONObject json = JSONObject.fromObject(reqSer.show(id));
			mav.addObject("techSer", json.toString());
		}
		List<Industry> list = indSer.list();
		System.out.println("reqlist:" + list.size());
		mav.addObject("info", list);
		mav.setViewName("user/techSerReq-add");
		return mav;
	}

	@RequestMapping("techSerSup-add")
	public ModelAndView techSerSupAdd(@RequestParam(value = "id", required = false) Integer id) {
		ModelAndView mav = new ModelAndView();
		if (null != id) {
			JSONObject json = JSONObject.fromObject(supSer.show(id));
			mav.addObject("techSer", json);
		}
		List<Industry> list = indSer.list();
		System.out.println("reqlist:" + list.size());
		mav.addObject("info", list);
		mav.setViewName("user/techSerSup-add");
		return mav;
	}

	@RequestMapping("techSerReq-save")
	public ModelAndView techSerReqSave(TechSerReq req) {
		ModelAndView mav = new ModelAndView();
		if (null != req.getReq_id()) {
			if (!reqSer.changeInfo(req)) {
				mav.setViewName("fore/error");
				return mav;
			}
		} else
			req = reqSer.add(req);

		if (null == req)
			mav.setViewName("fore/error");

		mav.addObject("msg", "operation success!");
		// 放入转发参数
		mav.addObject("info", req);
		// 放入jsp路径
		mav.setViewName("user/techSerReq-show");
		return mav;
	}

	@RequestMapping("techSerSup-save")
	public ModelAndView techSerSupSave(TechSerSup sup) {
		ModelAndView mav = new ModelAndView();
		if (null != sup.getSup_id()) {
			if (!supSer.changeInfo(sup)) {
				mav.addObject("msg", "change info fail");
				mav.setViewName("fore/error");
				return mav;
			}
		} else
			sup = supSer.add(sup);
		if (null == sup) {
			mav.addObject("msg", "no sup");
			mav.setViewName("fore/error");
		}

		mav.addObject("msg", "operation success!");
		// 放入转发参数
		mav.addObject("info", sup);
		// 放入jsp路径
		mav.setViewName("user/techSerSup-show");
		return mav;
	}

	@RequestMapping("techSer-del")
	public String techSerDel(@RequestParam(value = "type", required = false) String type,
			@RequestParam(value = "id", required = false) Integer id, HttpServletRequest request) {
		/*/sys_edu/user/techSer-del
		http://localhost:8080/sys_edu/user/techSer-del
		http://localhost:8080/sys_edu/list/techSerSup-show?id=1
		System.out.println(request.getRequestURI());
		System.out.println(request.getRequestURL());
		System.out.println(request.getHeader("Referer"));*/
		System.out.println("type:" + type);
		boolean flag = false;
		request.setAttribute("msg", "删除成功了");
		if (null == type || null == id || id.equals("")) {
			request.setAttribute("msg", "删除失败了");
			return "fore/error";
		}
		if (type.equals("sup"))
			flag = supSer.delete(id);

		else if (type.equals("req"))
			flag = reqSer.delete(id);
		if (flag) {
			request.setAttribute("msg", "删除成功!");
			return "fore/success";
		} else
			request.setAttribute("msg", "删除失败");
		return "fore/error";

	}

}
