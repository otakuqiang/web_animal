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
import com.web_animal.service.web_animal_categoryDao;
import com.web_animal.service.web_animal_orderDao;
import com.web_animal.entity.web_animal_order;
import com.web_animal.entity.web_animal_user;

/**
 * Servlet implementation class ShowOrder
 */
@WebServlet("/showorder")
public class ShowOrder extends HttpServlet {

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 设置字符集
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");

		ArrayList<web_animal_category> flist = web_animal_categoryDao.selectCat("father");
		request.setAttribute("flist", flist);

		ArrayList<web_animal_category> clist = web_animal_categoryDao.selectCat("child");
		request.setAttribute("clist", clist);

		HttpSession session = request.getSession();

		String isLogin = (String) session.getAttribute("isLogin");
		// 提前声明集合
		ArrayList<web_animal_order> olist = new ArrayList<>();

		web_animal_user user = (web_animal_user) session.getAttribute("user");

		int showflag = Integer.parseInt(request.getParameter("showflag"));
		if (user != null && isLogin.equals("1")) {

			String uid = (String) user.getUser_id();

			// showflag 1为全部，2为待收货，3为已完成
			if (showflag == 1) {
				olist = web_animal_orderDao.getOrder(uid);
			} else if (showflag == 2) {

				olist = web_animal_orderDao.SelectBy_F(uid, "1");
				
			} else if (showflag == 3) {
				olist = web_animal_orderDao.SelectBy_F(uid, "2");

			}
			
			request.setAttribute("olist", olist);

			request.setAttribute("showflag", showflag);

		}

		request.setAttribute("user", user);

		request.getRequestDispatcher("myorder.jsp").forward(request, response);

	}
}
