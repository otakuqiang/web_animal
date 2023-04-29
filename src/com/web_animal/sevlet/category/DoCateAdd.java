package com.web_animal.sevlet.category;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web_animal.entity.web_animal_category;
import com.web_animal.service.web_animal_categoryDao;

/**
 * Servlet implementation class DoCateAdd
 */
@WebServlet("/manage/admin_docateadd")
public class DoCateAdd extends HttpServlet {

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//设置字符集
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		
		//将父ID取出，类型强转
		int cate_fid = Integer.parseInt(request.getParameter("parentId"));
		
		String cate_name = request.getParameter("className");
		
		web_animal_category cate = new web_animal_category(
				0,cate_name,cate_fid);
		
		web_animal_categoryDao.insert(cate);
		
		response.sendRedirect("admin_categoryselect");
		
	}

}
