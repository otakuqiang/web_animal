package com.web_animal.sevlet.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.web_animal.entity.web_animal_user;
import com.web_animal.service.web_animal_userDao;

import com.mysql.cj.Session;
/**
 * Servlet implementation class AdminLogin
 */
@WebServlet("/manage/adminlogin")
public class AdminLogin extends HttpServlet {
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		web_animal_user user = null;

		// 设置字符集
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");

		boolean flag = false;

		String user_id = request.getParameter("user_id");
		String user_password = request.getParameter("user_password");

		user = web_animal_userDao.selectByID_Pwd(user_id, user_password);

		if (user!=null) {
			
			HttpSession session = request.getSession();

			session.setAttribute("user", user);
			session.setAttribute("isLogin", "1");

			// 用户状态使用字符串类型，调用equals方法判断
			
			if (user.getUser_status().equals("2")) {

				session.setAttribute("isAdminLogin", "1");
				response.sendRedirect("/web_animal/manage/admin_index.jsp");
			} else {

				response.sendRedirect("/web_animal/indexselect");

			}
		} else {
			//System.out.println("用户" + user_id + "不存在");

			PrintWriter out = response.getWriter();

			out.write("<script>");
			out.write("alert('user login defeat');");
			out.write("location.href='login.jsp';");
			out.write("</script>");

			out.close();
		}

	}

}
