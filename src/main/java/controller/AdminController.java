package controller;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import service.AdminService;

@Controller
@RequestMapping("")
public class AdminController {
	@Autowired
	AdminService adminService;

	@RequestMapping("login")
	public ModelAndView login() {
		return null;
	}
	@Test
	public void test(){
		System.out.println(adminService);
	}

}
