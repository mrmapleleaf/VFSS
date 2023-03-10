package com.example.VFSS.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;

import com.example.VFSS.entity.User;

@Component
public class LoginFilter implements Filter {
	
	public LoginFilter() {
	}
	
	public void destroy() {
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		String contextPath = ((HttpServletRequest)request).getContextPath();
		String servletPath = ((HttpServletRequest)request).getServletPath();

		if(!servletPath.matches("/css.*") && !servletPath.matches("/img.*") && 
				!servletPath.matches("/js.*") && !servletPath.matches("/toppage")) {
			
			HttpSession session = 	((HttpServletRequest)request).getSession();
			
			User loginUser = (User)session.getAttribute("loginUser");
			if(!servletPath.equals("/login/form") && !servletPath.equals("/login/login") 
					&& !servletPath.equals("/createUser/form") && !servletPath.equals("/createUser/insert")) {
				if(loginUser == null) {
					((HttpServletResponse)response).sendRedirect(contextPath + "/login/form");
					return;
				}
			} else {
				if(loginUser != null) {
					((HttpServletResponse)response).sendRedirect(contextPath + "/toppage");
					return;
				}
			}
		}
		chain.doFilter(request, response);
	}
	
	public void init(FilterConfig filterConfig) throws ServletException {
	}

}
