package com.web_animal.sevlet.home;

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

/**
 * Servlet implementation class CollectInsert
 */
@WebServlet("/collectinsert")
public class CollectInsert extends HttpServlet {

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

		// 获取纪念品ID
		int id = Integer.parseInt(request.getParameter("coll_id"));
		// 获取状态区分位
		int state = Integer.parseInt(request.getParameter("state"));

		// 获取用户Session，判断用户是否登录
		HttpSession session = request.getSession();

		web_animal_collect collect = null;

		web_animal_user user = (web_animal_user) session.getAttribute("user");

		String uid = (String) user.getUser_id();

		collect = new web_animal_collect(0, uid, id, state);

		// uid用户名，id为被收藏ID，state用于区分动物和纪念品，此处为收藏纪念品，为2，当查询到此纪录，返回对象
		int count = web_animal_collectDao.insert(collect);
		if (count > 0 && state==2) {
			//用户成功收藏纪念品，进行跳转
			response.sendRedirect("/web_animal/selectkeepsakeview?id=" + id);

		}
		else if (count > 0 && state==1) {

			response.sendRedirect("/web_animal/selectanimalview?id=" + id);

		}
	}

}
