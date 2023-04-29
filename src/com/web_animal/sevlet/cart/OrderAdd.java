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
import com.web_animal.entity.web_animal_order;
import com.web_animal.entity.web_animal_user;
import com.web_animal.service.web_animal_cartDao;
import com.web_animal.service.web_animal_categoryDao;
import com.web_animal.service.web_animal_keepsakeDao;
import com.web_animal.service.web_animal_orderDao;
import com.web_animal.service.web_animal_userDao;

/**
 * Servlet implementation class OrderSelect
 */
@WebServlet("/orderadd")
public class OrderAdd extends HttpServlet {

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

		String ordertype = request.getParameter("ordertype");
		PrintWriter out = response.getWriter();

		// 获取支付方式，1为 2为
		// System.out.println(ordertype);

		HttpSession session = request.getSession();

		String isLoign = (String) session.getAttribute("isLogin");

		// 通过session获取用户对象
		web_animal_user user = (web_animal_user) session.getAttribute("user");

		String eids = request.getParameter("eids");

		if (user != null && isLoign.equals("1")) {

			// 用户地址非空才能实现购买功能
			if (user.getUser_address() != null) {
				double user_money = user.getUser_money();
				double user_point = user.getUser_point();

				// 通过split分割购物车的订单ID
				String ids[] = eids.split(",");

				double totalprice = 0.0;
				int totalpoint = 0;

				for (int i = 0; i < ids.length; i++) {

					web_animal_cart es = web_animal_cartDao.getCartList(Integer.parseInt(ids[i]));

					totalprice = totalprice + es.getCart_k_price() * es.getCart_quantity();
					totalpoint = totalpoint + es.getCart_k_point() * es.getCart_quantity();
				}
				// System.out.println(totalprice);
				// System.out.println(totalpoint);
				if (ordertype.equals("T") && user_money >= totalprice) {
					// 用户使用余额支付，并且余额足够支付所有纪念品，进行用户支付操作。--->需要进行修改的表 订单表添加信息，用户余额
					// 纪念品数量 纪念品表 库存
					for (int i = 0; i < ids.length; i++) {

						web_animal_cart cart = web_animal_cartDao.getCartList(Integer.parseInt(ids[i]));
						double money = cart.getCart_k_price() * cart.getCart_quantity();
						web_animal_order order = new web_animal_order(0, cart.getCart_u_id(), cart.getCart_k_id(),
								user.getUser_name(), cart.getCart_k_photo(), user.getUser_address(), money, 0,
								cart.getCart_quantity(), ordertype, "1");
						web_animal_orderDao.insert(order);
						// updateMP 价格、积分、区分位、用户ID
						web_animal_userDao.updateM(money, cart.getCart_u_id());
						// 2标识该纪念品已经完成支付
						web_animal_cartDao.updateValid(2, cart.getCart_id());
						web_animal_keepsakeDao.updateStock(cart.getCart_quantity(), cart.getCart_k_id());
					}
					request.getRequestDispatcher("showok").forward(request, response);

				} else if (ordertype.equals("F") && user_point >= totalpoint) {
					// 用户使用积分支付，并且积分足够支付所有纪念品，进行用户支付操作。--->需要进行修改的表 订单表添加信息，用户余额
					// 纪念品数量 纪念品表 库存
					for (int i = 0; i < ids.length; i++) {

						web_animal_cart cart = web_animal_cartDao.getCartList(Integer.parseInt(ids[i]));
						int point = cart.getCart_k_point() * cart.getCart_quantity();
						web_animal_order order = new web_animal_order(0, cart.getCart_u_id(), cart.getCart_k_id(),
								user.getUser_name(), cart.getCart_k_photo(), user.getUser_address(), 0.0, point,
								cart.getCart_quantity(), ordertype, "1");
						web_animal_orderDao.insert(order);

						// updateMP 价格、积分、区分位、用户ID
						web_animal_userDao.updateP(point, cart.getCart_u_id());

						// 2标识该纪念品已经完成支付,后期查询购物车将不在显示
						web_animal_cartDao.updateValid(2, cart.getCart_id());
						web_animal_keepsakeDao.updateStock(cart.getCart_quantity(), cart.getCart_k_id());
					}
					request.getRequestDispatcher("showok").forward(request, response);

				} else {
					out.write("<script>");
					out.write("alert('用户余额或积分不足，请重新购买');");
					out.write("location.href='/web_animal/showcart';");
					out.write("</script>");
					out.close();
				}
			} else {
				out.write("<script>");
				out.write("alert('请设置收货地址后，再购买');");
				out.write("location.href='/web_animal/showcart';");
				out.write("</script>");
				out.close();
			}
		} else {
			out.write("<script>");
			out.write("alert('请先登录，再购买');");
			out.write("location.href='login.jsp';");
			out.write("</script>");
			out.close();
		}
	}
}
