package com.web_animal.sevlet.manage;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.web_animal.entity.web_animal_category;
import com.web_animal.entity.web_animal_collect;
import com.web_animal.entity.web_animal_user;
import com.web_animal.service.web_animal_categoryDao;
import com.web_animal.service.web_animal_collectDao;
import com.web_animal.service.web_animal_orderDao;

/**
 * Servlet implementation class UserCenter
 */
@WebServlet("/usercenter")
public class UserCenter extends HttpServlet {
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 设置字符集
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		ArrayList<web_animal_category> flist = web_animal_categoryDao.selectCat("father");
		request.setAttribute("flist", flist);
		
		ArrayList<web_animal_category> clist = web_animal_categoryDao.selectCat("child");
		request.setAttribute("clist", clist);

		HttpSession session = request.getSession();

		String isLogin = (String) session.getAttribute("isLogin");
		// 提前声明收藏对象
		web_animal_collect collect = null;

		web_animal_user user = (web_animal_user) session.getAttribute("user");

		if (user != null && isLogin.equals("1")) {
			
			String uid = (String) user.getUser_id();
			//通过用户ID，获取所有订单列表，声明数组，通过数组接收用户的订单数
			int[] num = web_animal_orderDao.selectNum(uid);
			
			//通过用户获取所有收藏数量
			int userlove = web_animal_collectDao.selectNum(uid);
			
			request.setAttribute("allorder", num[0]);
			request.setAttribute("temporder", num[1]);
			request.setAttribute("resorder", num[2]);
			request.setAttribute("userlove", userlove);

		}
		
		
		request.setAttribute("user", user);

		request.getRequestDispatcher("usercenter.jsp").forward(request, response);
		
	}

}
