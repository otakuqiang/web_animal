package com.web_animal.sevlet.animal;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web_animal.entity.web_animal_animal;
import com.web_animal.service.web_animal_animalDao;

/**
 * Servlet implementation class DoUserUpdate
 */
@WebServlet("/manage/admin_doanimalupdate")
public class DoAnimalUpdate extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 设置字符集
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");

		String animal_id = request.getParameter("animal_id");
		String animal_name = request.getParameter("animal_name");
		String animal_latin = request.getParameter("animal_latin");
		String animal_introduce = request.getParameter("animal_introduce");
		String animal_other = request.getParameter("animal_other");

		web_animal_animal temp = web_animal_animalDao.selectByID(Integer.parseInt(animal_id));
		// 连接数据库
		PrintWriter pw = response.getWriter();

		// 创建动物对象
		web_animal_animal animal = new web_animal_animal(Integer.parseInt(animal_id), animal_name, animal_latin,
				temp.getAnimal_fid(), temp.getAnimal_cid(), temp.getAnimal_photo(), temp.getAnimal_audio(),
				temp.getAnimal_video(), temp.getAnimal_point(), animal_introduce, animal_other);

		// 加入到数据库的用户表中
		int count = web_animal_animalDao.update(animal);

		// 成功或失败重定向到哪里

		if (count > 0) {
			response.sendRedirect("admin_animalselect");

		} else {
			PrintWriter out = response.getWriter();

			out.write("<script>");
			out.write("alert('动物信息修改失败');");
			out.write("location.href='/web_animal/manage/admin_animalselect';");
			out.write("</script>");

			out.close();

		}
	}

}
