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
import com.web_animal.entity.web_animal_keepsake;
import com.web_animal.entity.web_animal_user;
import com.web_animal.service.web_animal_cartDao;
import com.web_animal.service.web_animal_categoryDao;
import com.web_animal.service.web_animal_keepsakeDao;

import sun.net.www.content.text.plain;

/**
 * Servlet implementation class CartAdd
 */
@WebServlet("/cartadd")
public class CartAdd extends HttpServlet {

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ArrayList<web_animal_category> flist = web_animal_categoryDao.selectCat("father");
		request.setAttribute("flist", flist);

		ArrayList<web_animal_category> clist = web_animal_categoryDao.selectCat("child");
		request.setAttribute("clist", clist);

		// 设置字符集
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");

		web_animal_keepsake k = null;

		String kid = request.getParameter("id");
		String count = request.getParameter("count");
		String url = request.getParameter("url");

		HttpSession session = request.getSession();

		String isLogin = (String) session.getAttribute("isLogin");

		// Session获取用户信息，在用户登录时存入session中，注意命名一致
		web_animal_user user = (web_animal_user) session.getAttribute("user");

		if (user != null && isLogin.equals("1")) {

			String uid = (String) user.getUser_id();

			// 通过用户ID和购物车中的纪念品ID 查询纪念品是否存在
			int temp_kid = Integer.parseInt(kid);
			web_animal_cart srcsp = web_animal_cartDao.getCartExist(uid, temp_kid);
			if (srcsp != null) {
				int srccount = srcsp.getCart_quantity();

				int newcount = srccount + Integer.parseInt(count);

				if (newcount >= 5) {
					newcount = 5;
				}
				web_animal_cartDao.updateNum(srcsp.getCart_id(), newcount);
			} else {

				if (kid != null) {

					k = web_animal_keepsakeDao.selectByID(Integer.parseInt(kid));
				}

				web_animal_cart cart = new web_animal_cart(0, k.getKeepsake_name(), k.getKeepsake_photo(),
						k.getKeepsake_price(), k.getKeepsake_point(), Integer.parseInt(count), k.getKeepsake_stock(),
						k.getKeepsake_id(), uid, 1);

				web_animal_cartDao.insert(cart);
			}

		} else {
			PrintWriter out = response.getWriter();

			out.write("<script>");
			out.write("alert('请先登录，再购买');");
			out.write("location.href='login.jsp';");
			out.write("</script>");
			out.close();
			return;
		}

		if (url.equals("z")) {
			response.sendRedirect("showcart");
		} else {
			response.sendRedirect("selectkeepsakeview?id=" + kid);
		}

	}

}
