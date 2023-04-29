package com.web_animal.sevlet.home;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web_animal.entity.web_animal_animal;
import com.web_animal.entity.web_animal_category;
import com.web_animal.service.web_animal_animalDao;
import com.web_animal.service.web_animal_categoryDao;

/**
 * Servlet implementation class SelectProductList
 */
@WebServlet("/searchanimal")
public class SearchAnimal extends HttpServlet {

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 设置字符集
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");

		ArrayList<web_animal_category> flist = web_animal_categoryDao.selectCat("father");
		request.setAttribute("flist", flist);

		ArrayList<web_animal_category> clist = web_animal_categoryDao.selectCat("child");
		request.setAttribute("clist", clist);

		String animal_name = request.getParameter("keywords");
		//System.out.println(animal_name);
		ArrayList<web_animal_animal> list = null;

		list = web_animal_animalDao.selectByName(animal_name);
		if (list != null) {

			request.setAttribute("list", list);

			request.getRequestDispatcher("search.jsp").forward(request, response);

		} else {

			PrintWriter out = response.getWriter();

			out.write("<script>");
			out.write("alert('搜索失败');");
			out.write("location.href='indexselect';");
			out.write("</script>");

		}
	}

}
