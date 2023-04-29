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
import com.web_animal.entity.web_animal_keepsake;
import com.web_animal.entity.web_animal_user;
import com.web_animal.service.web_animal_categoryDao;
import com.web_animal.service.web_animal_collectDao;
import com.web_animal.service.web_animal_keepsakeDao;

/**
 * Servlet implementation class SelectKeepsakeView
 */
@WebServlet("/selectkeepsakeview")
public class SelectKeepsakeView extends HttpServlet {

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

		String id = null;

		id = request.getParameter("id");

		web_animal_keepsake k = null;

		if (id != null) {
			k = web_animal_keepsakeDao.selectByID(Integer.parseInt(id));
			request.setAttribute("k", k);
		}
		// 获取用户Session，判断用户是否登录
		HttpSession session = request.getSession();

		String isLogin = (String) session.getAttribute("isLogin");
		// 提前声明收藏对象
		web_animal_collect collect = null;

		web_animal_user user = (web_animal_user) session.getAttribute("user");

		if (user != null && isLogin.equals("1")) {
			k = web_animal_keepsakeDao.selectByID(Integer.parseInt(id));

			request.setAttribute("k", k);

			String uid = (String) user.getUser_id();
			
			// uid用户名，id为被收藏ID，state用于区分动物和纪念品，此处为收藏纪念品，为2，当查询到此纪录，返回对象
			collect = web_animal_collectDao.selectCollect(uid, k.getKeepsake_id(), 2);

			// 表明用户已经收藏该纪念品
			if (collect != null) {
				request.setAttribute("flag", 1);

			} else {
				request.setAttribute("flag", 0);

			}
		}
		request.getRequestDispatcher("keepsakeview.jsp").forward(request, response);

	}
}
