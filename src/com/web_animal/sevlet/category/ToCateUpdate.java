package com.web_animal.sevlet.category;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web_animal.entity.web_animal_category;
import com.web_animal.service.web_animal_categoryDao;

/**
 * Servlet implementation class ToCateUpdate
 */
@WebServlet("/manage/admin_tocateupdate")
public class ToCateUpdate extends HttpServlet {

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 设置字符集
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		
		//通过类别ID，查询类别对象
		web_animal_category cate = web_animal_categoryDao.selectByID(id);
		
		ArrayList<web_animal_category> catelist = web_animal_categoryDao.selectAll();
		
		request.setAttribute("catelist",catelist);
		request.setAttribute("cate1",cate);
		
		request.getRequestDispatcher("admin_catemodify.jsp").forward(request, response);
		
		
		
	}

}
