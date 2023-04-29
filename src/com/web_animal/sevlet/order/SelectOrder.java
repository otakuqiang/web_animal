package com.web_animal.sevlet.order;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web_animal.entity.web_animal_order;
import com.web_animal.service.web_animal_orderDao;

/**
 * Servlet implementation class SelectOrder
 */
@WebServlet("/manage/admin_orderselect")
public class SelectOrder extends HttpServlet {
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 设置字符集
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");

		ArrayList<web_animal_order> list = web_animal_orderDao.OrderAll();

		request.setAttribute("list", list);

		request.getRequestDispatcher("/manage/admin_order.jsp").forward(request, response);

	}
}
