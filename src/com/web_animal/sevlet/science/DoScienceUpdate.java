package com.web_animal.sevlet.science;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web_animal.entity.web_animal_science;
import com.web_animal.service.web_animal_scienceDao;

/**
 * Servlet implementation class DoUserUpdate
 */
@WebServlet("/manage/admin_doscienceupdate")
public class DoScienceUpdate extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 设置字符集
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
				
		int science_id = Integer.parseInt(request.getParameter("science_id"));
		String science_title = request.getParameter("science_title");
		String science_text = request.getParameter("science_text");

		web_animal_science temp = web_animal_scienceDao.selectByID(science_id);
		//连接数据库 
		PrintWriter pw =response.getWriter(); 			

		//创建用户实体
		web_animal_science science = new web_animal_science(
				science_id,
				science_title,
				temp.getScience_photo(),
				science_text
				);
	
		//加入到数据库的用户表中
		int count = web_animal_scienceDao.Update(science);
				
				
		//成功或失败重定向到哪里
				
		if (count > 0) {
			response.sendRedirect("admin_scienceselect");
								
		}else{
			PrintWriter out = response.getWriter();
					
			out.write("<script>");
			out.write("alert('科普信息修改失败');");
			out.write("location.href='/web_animal/manage/admin_toscienceupdate';");
			out.write("</script>");
			
			out.close();
				
		}
	}

}
