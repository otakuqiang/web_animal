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
 * Servlet implementation class DoUserAdd
 */
@WebServlet("/manage/admin_douseradd")
public class DoUserAdd extends HttpServlet {

	/**
	 * 使用post提交
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 设置字符集
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		String user_id = request.getParameter("user_id");
		String user_name = request.getParameter("user_name");
		String user_password = request.getParameter("user_password");
		String user_sex = request.getParameter("user_sex");
		double user_money = 0;
		int user_point = 0;
		String user_mobile = request.getParameter("user_mobile");
		String user_address = request.getParameter("user_address");
		String user_status = "1";
		
		
		//创建用户实体
		web_animal_user u = new web_animal_user(user_id,user_name,user_password,user_sex,user_money,user_point,user_mobile,user_address,user_status);
		
		
		//加入到数据库的用户表中
		int count = web_animal_userDao.insert(u);
		
		
		//成功或失败重定向到哪里
		
		if (count > 0) {
			response.sendRedirect("admin_douserselect");
		}else{
			PrintWriter out = response.getWriter();
			
			out.write("<script>");
			out.write("alert('添加用户失败');");
			out.write("location.href='manage/admin_useradd?';");
			out.write("</script>");
			
			
		}
		
	}

}
