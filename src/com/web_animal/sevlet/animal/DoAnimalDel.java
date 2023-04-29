package com.web_animal.sevlet.animal;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web_animal.service.web_animal_animalDao;

/**
 * Servlet implementation class DoUserDel
 */
@WebServlet("/manage/admin_doanimaldel")
public class DoAnimalDel extends HttpServlet {

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 设置字符集
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");

		String id = request.getParameter("id");
		int animal_id = Integer.parseInt(id);
		int count = web_animal_animalDao.delanimal(animal_id);
		// 成功或失败的重定向位置
		if (count > 0) {

			response.sendRedirect("/web_animal/manage/admin_animalselect");
		} else {

			PrintWriter out = response.getWriter();

			out.write("<script>");
			out.write("alter('用户删除失败');");
			out.write("location.href='manage/admin_animalselect';");
			out.write("</script>");

			out.close();
		}
	}
}
