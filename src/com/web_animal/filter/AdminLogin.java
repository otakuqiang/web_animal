package com.web_animal.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class AdminLogin
 */
@WebFilter("/manage/*")
public class AdminLogin implements Filter {

    /**
     * Default constructor. 
     */
    public AdminLogin() {
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
		
		//设置字符集
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=utf-8");
		
		
		HttpSession session  = req.getSession();
	
		//获取session后，通过getAttribute方法获取，并通过String类型强转
		
		String flag = (String)session.getAttribute("isAdminLogin");
		

		//字符串类型
		String request_uri = req.getRequestURI();
		String ctxPath = req.getContextPath();
		
		String uri = request_uri.substring(ctxPath.length());
		
		//System.out.println(request_uir+"##"+ctxPath+"##"+uri);
		
		if (uri.contains("admin_")) {
			if (flag!=null && flag.contentEquals("1")) {
				chain.doFilter(req, resp);
			}else{
				PrintWriter out = resp.getWriter();
				
				out.write("<script>");
				out.write("alert('请先登录,再访问后台管理系统！');");
				out.write("location.href='/web_animal/manage/login.jsp';");
				out.write("</script>");
				
				out.close();
				return;
			}
		}else{

			//不通过则直接return
			// pass the request along the filter chain
			chain.doFilter(req, resp);	//通过则执行这条语句
		}
		
		return ;
	}

	
	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
