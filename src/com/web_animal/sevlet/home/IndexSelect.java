package com.web_animal.sevlet.home;

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
 * Servlet implementation class IndexSelect
 */
@WebServlet("/indexselect")
public class IndexSelect extends HttpServlet {
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 设置字符集
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		ArrayList<web_animal_category> flist = web_animal_categoryDao.selectCat("father");
		request.setAttribute("flist", flist);
		
		ArrayList<web_animal_category> clist = web_animal_categoryDao.selectCat("child");
		request.setAttribute("clist", clist);

		
		//获取动物列表点击前20的动物集合
		int top = 20;
		ArrayList<web_animal_animal> toplist = null;

		//flag=1为按照热度查找
		toplist = web_animal_animalDao.selectAll(top);

		request.setAttribute("top", top);
		
		request.setAttribute("toplist", toplist);

		request.getRequestDispatcher("index.jsp").forward(request, response);
		
		
	}

	
}
