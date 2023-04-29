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

/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class Login extends HttpServlet {

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		boolean flag = false;

		// 设置字符集
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");

		String user_id = request.getParameter("user_id");
		String user_password = request.getParameter("user_password");

		web_animal_user user = web_animal_userDao.selectByID_Pwd(user_id, user_password);

		if (user!=null) {
			// System.out.println("用户"+user_id+"存在");

			HttpSession session = request.getSession();
			
			session.setAttribute("user", user);
			
			session.setAttribute("isLogin", "1");

			response.sendRedirect("indexselect");

		} else {
			//System.out.println("用户" + user_id + "不存在");

			PrintWriter out = response.getWriter();

			out.write("<script>");
			out.write("alert('用户登录失败，请检查用户名或密码');");
			out.write("location.href='login.jsp';");
			out.write("</script>");

			out.close();
		}

	}

}
