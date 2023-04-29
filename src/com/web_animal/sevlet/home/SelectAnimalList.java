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
 * Servlet implementation class SelectProductList
 */
@WebServlet("/selectanimallist")
public class SelectAnimalList extends HttpServlet {

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

		String fid = request.getParameter("fid");
		String cid = request.getParameter("cid");

		int id = 0;
		ArrayList<web_animal_animal> list = null;

		if (fid != null) {
			id = Integer.parseInt(fid);
			
			//selectAllByID(id,0),0->父类
			list = web_animal_animalDao.selectAllByID(id,0);
		}
		if (cid != null) {
			id = Integer.parseInt(cid);
			
			//selectAllByID(id,1),1->子类
			list = web_animal_animalDao.selectAllByID(id,1);

		}
		
		request.setAttribute("title", web_animal_categoryDao.selectByID(id).getCate_name());
		
		request.setAttribute("list", list);
		
		request.getRequestDispatcher("animallist.jsp").forward(request, response);

	}

}
