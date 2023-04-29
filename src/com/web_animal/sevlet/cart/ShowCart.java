package com.web_animal.sevlet.cart;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.web_animal.entity.web_animal_cart;
import com.web_animal.entity.web_animal_category;
import com.web_animal.entity.web_animal_user;
import com.web_animal.service.web_animal_cartDao;
import com.web_animal.service.web_animal_categoryDao;

/**
 * Servlet implementation class ShowCart
 */
@WebServlet("/showcart")
public class ShowCart extends HttpServlet {

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 设置字符集
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");


		ArrayList<web_animal_category> flist = web_animal_categoryDao.selectCat("father");
		request.setAttribute("flist", flist);
		
		ArrayList<web_animal_category> clist = web_animal_categoryDao.selectCat("child");
		request.setAttribute("clist", clist);

		HttpSession session = request.getSession();

		String isLogin = (String) session.getAttribute("isLogin");

		web_animal_user user = (web_animal_user) session.getAttribute("user");

		if (user != null && isLogin.equals("1")) {

			String uid = (String)user.getUser_id();
			
			ArrayList<web_animal_cart> cartlist = web_animal_cartDao.getCart(uid);
			
			request.setAttribute("cartlist", cartlist);
			
			request.getRequestDispatcher("cart.jsp").forward(request, response);
			
		}else{
			PrintWriter out = response.getWriter();

			out.write("<script>");
			out.write("alert('请先登录，再查看购物车信息');");
			out.write("location.href='login.jsp';");
			out.write("</script>");
			out.close();
			return;
		}
			
	}
}
