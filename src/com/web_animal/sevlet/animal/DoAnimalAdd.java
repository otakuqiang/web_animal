package com.web_animal.sevlet.animal;

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
import com.web_animal.entity.web_animal_animal;
import com.web_animal.service.web_animal_animalDao;

/**
 * Servlet implementation class DoAnimalAdd
 */
@WebServlet("/manage/admin_doanimaladd")
public class DoAnimalAdd extends HttpServlet {

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 设置字符集
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");

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

		// 获取上传的文件对象，传入的是所有文件
		Files fs = su.getFiles();

		// 获取动物图片
		File photo = fs.getFile(0);

		// 获取动物音频
		File audio = fs.getFile(1);

		// 获取动物视频
		File video = fs.getFile(2);

		// 获取上传的文件名称
		String animal_photo = photo.getFileName();

		String animal_audio = audio.getFileName();

		String animal_video = video.getFileName();

		try {
			su.save("animal");
		} catch (SmartUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Request req1 = su.getRequest();

		String animal_name = req1.getParameter("animal_name");
		String animal_latin = req1.getParameter("animal_latin");

		String animal_introduce = req1.getParameter("animal_introduce");
		String animal_other = req1.getParameter("animal_other");
		String ID = req1.getParameter("animal_parentID");

		web_animal_animal animal = new web_animal_animal(0, animal_name, animal_latin,
				Integer.parseInt(ID.split("-")[0]), // 获取父ID
				Integer.parseInt(ID.split("-")[1]), // 获取子ID
				animal_photo, animal_audio, animal_video, 0, // animal_point动物点击量
				animal_introduce, animal_other);

		int count = web_animal_animalDao.insert(animal);

		// 成功或失败重定向到哪里

		if (count > 0) {
			response.sendRedirect("admin_animalselect");
		} else {
			PrintWriter out = response.getWriter();

			out.write("<script>");
			out.write("alert('添加动物失败');");
			out.write("location.href='manage/admin_toanimaladd?';");
			out.write("</script>");

		}
	}

}
