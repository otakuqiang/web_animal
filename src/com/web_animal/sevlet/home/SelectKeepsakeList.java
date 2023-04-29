package com.web_animal.sevlet.home;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web_animal.entity.web_animal_category;
import com.web_animal.entity.web_animal_keepsake;
import com.web_animal.service.web_animal_categoryDao;
import com.web_animal.service.web_animal_keepsakeDao;

/**
 * Servlet implementation class SelectKeepsakeList
 */
@WebServlet("/selectkeepsakelist")
public class SelectKeepsakeList extends HttpServlet {

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

		ArrayList<web_animal_keepsake> klist = web_animal_keepsakeDao.selectAll();

		request.setAttribute("klist", klist);

		request.getRequestDispatcher("keepsakelist.jsp").forward(request, response);

	}
}
