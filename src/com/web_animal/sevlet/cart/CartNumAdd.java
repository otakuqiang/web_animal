package com.web_animal.sevlet.cart;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web_animal.service.web_animal_cartDao;

/**
 * Servlet implementation class CartNumAdd
 */
@WebServlet("/cartnumadd")
public class CartNumAdd extends HttpServlet {
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 设置字符集
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");

		String count = request.getParameter("count");
		String esid = request.getParameter("esid");
		
		web_animal_cartDao.updateNum(Integer.parseInt(esid), Integer.parseInt(count));
		
	}

}
