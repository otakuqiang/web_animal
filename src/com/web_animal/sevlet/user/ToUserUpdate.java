package com.web_animal.sevlet.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.tribes.util.Arrays;

import com.web_animal.entity.web_animal_user;
import com.web_animal.service.web_animal_userDao;

/**
 * Servlet implementation class ToUserUpdate
 */
@WebServlet("/manage/admin_touserupdate")
public class ToUserUpdate extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 设置字符集
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;character=UTF-8");

		String user_id = request.getParameter("id");

		web_animal_user user = web_animal_userDao.selectByID(user_id);

		request.setAttribute("user", user);

		request.setAttribute("cpage", request.getParameter("cpage"));
		request.getRequestDispatcher("/manage/admin_usermodify.jsp").forward(request, response);

	}

}
