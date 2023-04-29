package com.web_animal.sevlet.home;

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
import com.web_animal.entity.web_animal_user;
import com.web_animal.service.web_animal_animalDao;
import com.web_animal.service.web_animal_categoryDao;
import com.web_animal.service.web_animal_collectDao;
import com.web_animal.service.web_animal_keepsakeDao;
import com.web_animal.service.web_animal_userDao;

/**
 * Servlet implementation class SelectKeepsakeView
 */
@WebServlet("/selectanimalview")
public class SelectAnimalView extends HttpServlet {

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

		int id = Integer.parseInt(request.getParameter("id"));

		web_animal_animal a = null;

		a = web_animal_animalDao.selectByID(id);

		// 每次点击更新，通过动物ID更新点击数
		int temppoint = a.getAnimal_point();
		int point = temppoint + 1;
		web_animal_animalDao.UpdatePoint(id, point);

		request.setAttribute("a", a);

		HttpSession session = request.getSession();

		String isLogin = (String) session.getAttribute("isLogin");
		// 提前声明收藏对象
		web_animal_collect collect = null;

		web_animal_user user = (web_animal_user) session.getAttribute("user");

		if (user != null && isLogin.equals("1")) {
			
			a = web_animal_animalDao.selectByID(id);

			request.setAttribute("a", a);

			String uid = (String) user.getUser_id();

			//用户点击某一某一动物获取积分奖励,flagPoint判断是否更新成功
			int flagPoint = web_animal_userDao.updatePoint(uid);
			
			// uid用户名，id为被收藏ID，state用于区分动物和纪念品，此处为收藏动物，为1，当查询到此纪录，返回对象
			collect = web_animal_collectDao.selectCollect(uid, a.getAnimal_id(), 1);

			// 表明用户已经收藏该动物
			if (collect != null) {
				request.setAttribute("flag", 1);

			} else {
				request.setAttribute("flag", 0);

			}
		}

		request.getRequestDispatcher("animalview.jsp").forward(request, response);

	}

}
