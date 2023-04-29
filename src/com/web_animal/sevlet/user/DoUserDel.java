package com.web_animal.sevlet.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web_animal.service.web_animal_userDao;

/**
 * Servlet implementation class DoUserDel
 */
@WebServlet("/manage/admin_douserdel")
public class DoUserDel extends HttpServlet {

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 设置字符集
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");

		String user_id = request.getParameter("id");
		int count = web_animal_userDao.deluser(user_id);
		// 成功或失败的重定向位置
		if (count > 0) {

			response.sendRedirect("/web_animal/manage/admin_douserselect?cp=" + request.getParameter("cpage"));
		} else {

			PrintWriter out = response.getWriter();

			out.write("<script>");
			out.write("alter('用户删除失败');");
			out.write("location.href='manage/admin_douserselect?cp=" + request.getParameter("cpage") + "';");
			out.write("</script>");

			out.close();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 设置字符集
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");

		String ids[] = request.getParameterValues("id[]");
		int flag = 0;
		for (int i = 0; i < ids.length; i++) {

			flag = web_animal_userDao.deluser(ids[i]);
		}
		
		if (flag > 0) {

			response.sendRedirect("/web_animal/manage/admin_douserselect");
		} else {

			PrintWriter out = response.getWriter();

			out.write("<script>");
			out.write("alter('用户批量删除失败');");
			out.write("location.href='manage/admin_douserselect?cp=1';");
			out.write("</script>");

			out.close();
		}
	}
}
