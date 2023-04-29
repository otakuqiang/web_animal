package com.web_animal.sevlet.science;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspsmart.upload.File;
import com.jspsmart.upload.Files;
import com.jspsmart.upload.Request;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;
import com.web_animal.entity.web_animal_science;
import com.web_animal.service.web_animal_scienceDao;

/**
 * Servlet implementation class scienceadd
 */
@WebServlet("/manage/admin_doscienceadd")
public class DoScienceAdd extends HttpServlet {


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 设置字符集
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");

		
		String science_photo = null;
		SmartUpload su = new SmartUpload();

		// 初始化
		su.initialize(this.getServletConfig(), request, response);

		// 上传过程
		try {
			su.upload();
		} catch (SmartUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// 获取上传的文件对象
		Files fs = su.getFiles();

		File f = fs.getFile(0);

		// 获取上传的文件名称
		science_photo = f.getFileName();

		try {
			su.save("/images/science");
		} catch (SmartUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Request req1 = su.getRequest();

		String science_title = req1.getParameter("science_title");
		
		String science_text = req1.getParameter("science_text");
		
		web_animal_science science = new web_animal_science(0,science_title,science_photo,science_text);
		int count = web_animal_scienceDao.insert(science);

		// 成功或失败重定向到哪里

		if (count > 0) {
			response.sendRedirect("admin_scienceselect");
		} else {
			PrintWriter out = response.getWriter();

			out.write("<script>");
			out.write("alert('添加科普信息失败');");
			out.write("location.href='manage/admin_toscienceadd?';");
			out.write("</script>");
			
			out.close();

		}

	}
}

