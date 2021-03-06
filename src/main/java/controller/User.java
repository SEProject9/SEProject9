package controller;

import java.util.ArrayList;
import java.util.List;
import net.sf.json.JSONObject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.util.StringUtil;

import pojo.Enterprise;
import pojo.EnterpriseInfo;
import pojo.Industry;
import pojo.TechSerReq;
import pojo.TechSerSup;
import service.EnterpriseInfoService;
import service.EnterpriseService;
import service.IndustryService;
import service.TechSerReqService;
import service.TechSerSupService;
import util.CallBackResult;

/*返回的跟路径在springmvc.xml中设置了为jsp*/
@Controller
@RequestMapping("user")
public class User {

	@Autowired
	EnterpriseService entSer;
	@Autowired
	EnterpriseInfoService entInfoSer;
	@Autowired
	IndustryService indSer;
	@Autowired
	TechSerReqService reqSer;
	@Autowired
	TechSerSupService supSer;

	@RequestMapping("index")
	public String user() {
		return "login";
	}

	@RequestMapping("tourist")
	public String tourist() {
		return "user/index";
	}

	@RequestMapping("signupPage")
	public String signupPage() {
		return "signup";
	}

	@RequestMapping("login")
	public ModelAndView login(HttpSession session) {
		ModelAndView mav = new ModelAndView();
		Enterprise ent = (Enterprise) session.getAttribute("user");
		if (null == ent || null == ent.getEnt_id()) {
			mav.setViewName("login");
			mav.addObject("msg", "false");
			return mav;
		}
		Integer count = (Integer) session.getAttribute("count");
		if (count == null)
			count = 0;
		count++;
		session.setAttribute("count", count);

		Integer ent_id = ent.getEnt_id();
		EnterpriseInfo entInfo = entInfoSer.show(ent_id);
		session.setAttribute("entInfo", entInfo);
		mav.setViewName("user/index");
		return mav;
	}

	@RequestMapping("logout")
	public String logout(HttpSession session) {
		session.removeAttribute("user");
		return "login";
	}

	@RequestMapping("error")
	public String errorPage() {
		return "fore/error";
	}

	/*检查账户以及公司重复
	返回 account:true/false 
	name:true/false*/
	@ResponseBody
	@RequestMapping("checkAcccount")
	public String check(String account, String password, HttpSession session) {
		CallBackResult cb = new CallBackResult();
		Enterprise ent = entSer.login(account, password);
		if (null != ent) {
			cb.setSuccess(true);
			session.setAttribute("user", ent);
		} else
			cb.setSuccess(false);
		return JSONObject.fromObject(cb).toString();
	}

	@ResponseBody
	@RequestMapping("signup")
	public String signup(Enterprise ent) {
		boolean flag = entSer.signupSave(ent);
		if (flag)
			return "success";
		return "false";
	}

	@RequestMapping("entInfo-add/{id}")
	public ModelAndView entInfoAdd(@PathVariable Integer id, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		EnterpriseInfo entInfo = null;
		Enterprise ent = (Enterprise) session.getAttribute("user");
		if (!(null == id) || !(null == ent) || !ent.getEnt_id().equals(id)) {
			entInfo = entInfoSer.show(id);
			JSONObject json = JSONObject.fromObject(entInfo);
			mav.addObject("entInfo", json.toString());
			List<Industry> list = indSer.list();
			mav.addObject("info", list);
			mav.setViewName("user/entInfo-add");
			return mav;
		}
		mav.addObject("msg", "修改错误");
		return mav;
	}

	@RequestMapping("techSerReq-add")
	public ModelAndView techSerReqAdd(@RequestParam(value = "id", required = false) Integer id) {
		ModelAndView mav = new ModelAndView();
		JSONObject json = null;
		if (null != id) {
			json = JSONObject.fromObject(reqSer.show(id));
		} else {
			String objectStr = "{\"add\":\"add\"}";
			json = JSONObject.fromObject(objectStr);
		}
		mav.addObject("techSer", json);
		List<Industry> list = indSer.list();
		mav.addObject("info", list);
		mav.setViewName("user/techSerReq-add");
		return mav;
	}

	@RequestMapping("techSerSup-add")
	public ModelAndView techSerSupAdd(@RequestParam(value = "id", required = false) Integer id) {
		ModelAndView mav = new ModelAndView();
		JSONObject json = null;
		if (null != id) {
			json = JSONObject.fromObject(supSer.show(id));
		} else {
			String objectStr = "{\"add\":\"add\"}";
			json = JSONObject.fromObject(objectStr);
		}
		mav.addObject("techSer", json);
		List<Industry> list = indSer.list();
		mav.addObject("info", list);
		mav.setViewName("user/techSerSup-add");
		return mav;
	}

	@RequestMapping("entInfo-save")
	public ModelAndView entInfoSave(EnterpriseInfo entInfo) {
		ModelAndView mav = new ModelAndView();

		if (!entInfoSer.update(entInfo)) {
			mav.setViewName("fore/error");
			return mav;
		}

		mav.addObject("msg", "operation success!");
		// 放入转发参数
		mav.addObject("info", entInfo);
		// 放入jsp路径
		mav.setViewName("user/entInfo-show");
		return mav;
	}

	@RequestMapping("techSerReq-save")
	public ModelAndView techSerReqSave(TechSerReq req, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		if (null != req.getReq_id()) {
			if (!reqSer.changeInfo(req)) {// 修改
				mav.setViewName("fore/error");
				return mav;
			}
		} else {// 增加
			Enterprise ent = (Enterprise) request.getSession().getAttribute("user");
			req.setEnt_id(ent.getEnt_id());

			req = reqSer.add(req);// 返回的req是传入的:没有id
		}

		if (null == req) {
			mav.addObject("msg", "no req");
			mav.setViewName("fore/error");
		}
		req.setEnt_id(null);
		mav.addObject("msg", "operation success!");
		mav.addObject("info", req);
		mav.setViewName("user/techSerReq-show");
		return mav;
	}

	@RequestMapping("techSerSup-save")
	public ModelAndView techSerSupSave(TechSerSup sup, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		if (null != sup.getSup_id()) {// 修改
			if (!supSer.changeInfo(sup)) {
				mav.addObject("msg", "change info fail");
				mav.setViewName("fore/error");
				return mav;
			}
		} else {// 增加
			Enterprise ent = (Enterprise) request.getSession().getAttribute("user");
			sup.setEnt_id(ent.getEnt_id());
			sup = supSer.add(sup);
		}
		if (null == sup) {
			mav.addObject("msg", "no sup");
			mav.setViewName("fore/error");
		}
		sup.setEnt_id(null);
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
