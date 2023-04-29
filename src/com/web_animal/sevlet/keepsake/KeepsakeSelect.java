package com.web_animal.sevlet.keepsake;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web_animal.entity.web_animal_keepsake;
import com.web_animal.service.web_animal_keepsakeDao;

/**
 * Servlet implementation class KeepsakeSelect
 */
@WebServlet("/manage/admin_keepsakeselect")
public class KeepsakeSelect extends HttpServlet {
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 设置字符集
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");

		 
		ArrayList<web_animal_keepsake> klist = web_animal_keepsakeDao.selectAll();
		
		request.setAttribute("klist", klist);
	
		request.getRequestDispatcher("/manage/admin_keepsake.jsp").forward(request, response);
		
	}

}
