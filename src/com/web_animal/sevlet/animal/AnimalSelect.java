package com.web_animal.sevlet.animal;

import java.io.IOException;
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
 * Servlet implementation class AnimalSelect
 */
@WebServlet("/manage/admin_animalselect")
public class AnimalSelect extends HttpServlet {

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 设置字符集
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");

		ArrayList<web_animal_animal> alist = web_animal_animalDao.selectAll();

		request.setAttribute("alist", alist);

		request.getRequestDispatcher("admin_animal.jsp").forward(request, response);
		;

	}

}
