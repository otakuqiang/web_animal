package com.web_animal.sevlet.animal;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web_animal.entity.web_animal_animal;
import com.web_animal.service.web_animal_animalDao;

/**
 * Servlet implementation class ToUserUpdate
 */
@WebServlet("/manage/admin_toanimalupdate")
public class ToAnimalUpdate extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 设置字符集
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;character=UTF-8");

		String animal_id = request.getParameter("id");

		web_animal_animal animal = web_animal_animalDao.selectByID(Integer.parseInt(animal_id));

		request.setAttribute("animal", animal);

		request.getRequestDispatcher("/manage/admin_animalmodify.jsp").forward(request, response);

	}

}
