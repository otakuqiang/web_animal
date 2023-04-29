package com.web_animal.sevlet.manage;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.web_animal.entity.web_animal_animal;
import com.web_animal.entity.web_animal_category;
import com.web_animal.entity.web_animal_collect;
import com.web_animal.entity.web_animal_keepsake;
import com.web_animal.entity.web_animal_user;
import com.web_animal.service.web_animal_animalDao;
import com.web_animal.service.web_animal_categoryDao;
import com.web_animal.service.web_animal_collectDao;
import com.web_animal.service.web_animal_keepsakeDao;

/**
 * Servlet implementation class ShowLove
 */
@WebServlet("/showlove")
public class ShowLove extends HttpServlet {

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@SuppressWarnings("null")
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
		ArrayList<web_animal_animal> alist = new ArrayList<web_animal_animal>();
		ArrayList<web_animal_keepsake> klist = new ArrayList<web_animal_keepsake>();

		ArrayList<web_animal_collect> clist_a = new ArrayList<web_animal_collect>();
		ArrayList<web_animal_collect> clist_k = new ArrayList<web_animal_collect>();


		web_animal_user user = (web_animal_user) session.getAttribute("user");

		int showflag = Integer.parseInt(request.getParameter("showflag"));
		if (user != null && isLogin.equals("1")) {

			String uid = (String) user.getUser_id();
			// 通过用户ID，获取收藏ID的次ID,showflag 1全部2动物3纪念品
			clist_a = web_animal_collectDao.selectByUid(uid, 1);
			if (clist_a != null) {
				for (web_animal_collect c : clist_a) {
					alist.add(web_animal_animalDao.selectByID(c.getCollect_k_a_id()));
				}
			}
			clist_k = web_animal_collectDao.selectByUid(uid, 2);
			if (clist_k != null) {
				for (web_animal_collect c : clist_k) {
					klist.add(web_animal_keepsakeDao.selectByID(c.getCollect_k_a_id()));
				}
			}
			if (showflag == 1) {
				// selectAll(),1为动物，2为纪念品
				request.setAttribute("alist", alist);
				request.setAttribute("klist", klist);
			} else if (showflag == 2) {
				request.setAttribute("alist", alist);


			} else if (showflag == 3) {
				request.setAttribute("klist", klist);

			}
			// 通过用户获取所有收藏集合

			
			request.setAttribute("showflag", showflag);

		}

		request.setAttribute("user", user);

		request.getRequestDispatcher("mylove.jsp").forward(request, response);

	}

}
