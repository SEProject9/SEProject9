package filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pojo.Enterprise;

/**
 * Servlet Filter implementation class TouristAndCodeFilter
 */
@WebFilter("/*")
public class TouristAndCodeFilter implements Filter {
	private static List<String> list = new ArrayList<String>();

	/**
	 * Default constructor. 
	 */
	public TouristAndCodeFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("destory");
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse rep = (HttpServletResponse) response;
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		Enterprise ent = (Enterprise) req.getSession().getAttribute("user");
		/*System.out.println("req.getRequestURI():" + req.getRequestURI());
		System.out.println("req.getContextPath():" + req.getContextPath());//在前台进行设置
		System.out.println("req.getHeader:" +req.getHeader("Referer"));*/
		if (req.getRequestURI().contains("add") && null == ent) {
			req.setAttribute("msg", "<a href='/sys_edu/user/index'>login</a>");
			req.getRequestDispatcher("/WEB-INF/jsp/fore/error.jsp").forward(request, response);
		}
		for (String s : list) {
			if (req.getRequestURI().contains(s) && null == ent) {
				System.out.println("youkegun");
				/*String url=req.getRequestURI().replaceAll(s, "list");
				req.getRequestDispatcher("kk"+url).forward(request, response);*/
				/*this.destroy(); 浏览还是会刷新 停留当前页 当没有之前数据*/
				// req.notify();
				rep.sendRedirect(req.getRequestURI().replaceAll(s, "list"));
			}
		}
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {

		list.add("search");
	}

}
