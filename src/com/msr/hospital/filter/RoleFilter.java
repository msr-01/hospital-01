package com.msr.hospital.filter;

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

import com.msr.hospital.bean.UserInfos;

/**
 * Servlet Filter implementation class RoleFilter
 */
@WebFilter(filterName = "/RoleFilter", urlPatterns = "/*")
public class RoleFilter implements Filter {

    /**
     * Default constructor. 
     */
    public RoleFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse resp = (HttpServletResponse)response;
		
		
		System.out.println("doFilter");
		
		UserInfos userInfos = (UserInfos)req.getSession().getAttribute("userInfos");
		if(userInfos!=null) {
			chain.doFilter(request, response);
			return;
		}
		
		String path = req.getRequestURI();
		System.out.println(path);
		
		List<String> passList = new ArrayList<String>();
		passList.add("login.jsp");
		passList.add("image");
		passList.add("css");
		passList.add("images");
		passList.add("img");
		passList.add("UserInfosServlet");
		
		

		for (String pass : passList) {
			if (path.indexOf(pass) != -1) {
				chain.doFilter(request, response);
				return;
			}
		}
		
		
		
		
		System.out.println("未登录转到登录页面");
		resp.sendRedirect("/hospital-01/html/login.jsp");
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
