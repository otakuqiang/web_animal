package com.web_animal.sevlet.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web_animal.entity.web_animal_user;
import com.web_animal.service.web_animal_userDao;

/**
 * Servlet implementation class UseridCheck
 */
@WebServlet("/useridcheck")
public class UseridCheck extends HttpServlet {

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//设置字符集
				request.setCharacterEncoding("UTF-8");
				response.setContentType("text/html;charset=utf-8");
				
		String user_id = request.getParameter("user_id");
		

		web_animal_user user = null;
		
		user = 	web_animal_userDao.selectByID(user_id);

		PrintWriter out = response.getWriter();
		
		//true说明用户ID不存在，可以使用
		if (user!=null) {
			out.print("false");
		}
		else{
			out.print("true");
		}
				
		out.close();
	}

}
