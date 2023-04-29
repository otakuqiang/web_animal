package com.web_animal.sevlet.category;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web_animal.entity.web_animal_category;
import com.web_animal.service.web_animal_categoryDao;

/**
 * Servlet implementation class DoCateUpdate
 */
@WebServlet("/manage/admin_docateupdate")
public class DoCateUpdate extends HttpServlet {

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 设置字符集
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		
		int id = Integer.parseInt(request.getParameter("id"));
		int cate_fid = Integer.parseInt(request.getParameter("parentId"));
		
		String cate_name = request.getParameter("className");
		
		if (id!=cate_fid) {
			web_animal_category cate = new web_animal_category(
					id,cate_name,cate_fid);
			
			web_animal_categoryDao.update(cate);
			
			response.sendRedirect("admin_categoryselect");
		}else{
			PrintWriter out = response.getWriter();
			
			out.write("<script>");
			out.write("alert('分类不能以自己为父类，修改失败');");
			out.write("location.href='/web_animal/manage/admin_categoryselect';");
			out.write("</script>");
			
			out.close();
				
		}
		
	
		
	}

}
