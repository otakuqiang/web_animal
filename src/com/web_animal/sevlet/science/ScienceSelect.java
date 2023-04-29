package com.web_animal.sevlet.science;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web_animal.entity.web_animal_science;
import com.web_animal.service.web_animal_scienceDao;

/**
 * Servlet implementation class ScienceSelect
 */
@WebServlet("/manage/admin_scienceselect")
public class ScienceSelect extends HttpServlet {
		/**
		 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
		 *      response)
		 */
		protected void doGet(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {

			// 设置字符集
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/html;charset=utf-8");

			 
			ArrayList<web_animal_science> slist = web_animal_scienceDao.selectAll();
			
			request.setAttribute("slist", slist);
		
			request.getRequestDispatcher("/manage/admin_science.jsp").forward(request, response);
			
		}

}
