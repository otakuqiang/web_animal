package com.web_animal.sevlet.user;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web_animal.entity.web_animal_user;
import com.web_animal.service.web_animal_userDao;

/**
 * Servlet implementation class DoUserSelect
 */

@WebServlet("/manage/admin_douserselect")

public class DoUserSelect extends HttpServlet {
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 设置字符集
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		//获取
		int cpage = 1;//当前页
		
		int count = 5;//每页展示条数
		
		
		//获取用户指定的页面
		String  cp = request.getParameter("cp");
		
		//接收用户搜索的关键字
		String user_keyword = request.getParameter("user_keyword");
		
		
		
		if(null!=cp){
			
			cpage = Integer.parseInt(cp);
			
		}
		
		int arr[] = web_animal_userDao.totalPage(count,user_keyword);
		
		//获取所有用户记录
		ArrayList<web_animal_user> userlist = web_animal_userDao.selectAll(cpage,count,user_keyword);
		
		//放到请求对象域中
		request.setAttribute("userlist", userlist);
		
		request.setAttribute("tsum", arr[0]);
		request.setAttribute("tpage", arr[1]);
		request.setAttribute("cpage", cpage);


		//判断用户的搜索操作
		
		if (null!=user_keyword) {
			
			request.setAttribute("searchParams", "&user_keyword"+user_keyword);
		}
		
		request.getRequestDispatcher("admin_user.jsp").forward(request, response);
	}
	
}
