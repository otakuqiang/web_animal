package com.web_animal.sevlet.cart;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web_animal.service.web_animal_cartDao;

/**
 * Servlet implementation class CartDel
 */
@WebServlet("/cartdel")
public class CartDel extends HttpServlet {

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 设置字符集
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");

		String esid = request.getParameter("esid");
		
		int temp_id = Integer.parseInt(esid);
		web_animal_cartDao.Delete(temp_id);
	}

	
}
