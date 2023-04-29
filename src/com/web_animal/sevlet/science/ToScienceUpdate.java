package com.web_animal.sevlet.science;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web_animal.entity.web_animal_science;
import com.web_animal.service.web_animal_scienceDao;


/**
 * Servlet implementation class ToUserUpdate
 */
@WebServlet("/manage/admin_toscienceupdate")
public class ToScienceUpdate extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 设置字符集
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;character=UTF-8");

		String id = request.getParameter("id");
		
		int science_id = Integer.parseInt(id);

		web_animal_science s = web_animal_scienceDao.selectByID(science_id);

		request.setAttribute("s", s);

		request.setAttribute("cpage", request.getParameter("cpage"));
		request.getRequestDispatcher("/manage/admin_sciencemodify.jsp").forward(request, response);

	}

}
