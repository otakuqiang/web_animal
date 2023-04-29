package com.web_animal.sevlet.keepsake;

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
import com.web_animal.entity.web_animal_keepsake;
import com.web_animal.service.web_animal_keepsakeDao;

/**
 * Servlet implementation class DoKeepsakeAdd
 */
@WebServlet("/manage/admin_dokeepsakeadd")
public class DoKeepsakeAdd extends HttpServlet {

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

		// 获取上传的文件对象
		Files fs = su.getFiles();

		File f = fs.getFile(0);

		// 获取上传的文件名称
		String keepsake_photo = f.getFileName();

		try {
			su.save("/images/keepsake");
		} catch (SmartUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//System.out.println(fname);

		Request req1 = su.getRequest();

		String keepsake_name = req1.getParameter("keepsake_name");
		String price = req1.getParameter("keepsake_price");
		//String keepsake_point = req1.getParameter("keepsake_point");
		String keepsake_introduce = req1.getParameter("keepsake_introduce");
		String keepsake_stock = req1.getParameter("keepsake_stock");
		double keepsake_price = Double.parseDouble(price);
		//对纪念品金额进行取整，转换为积分
		int keepsake_point = (int)(keepsake_price*10)/1;
		
		web_animal_keepsake keepsake = new web_animal_keepsake(0, keepsake_name, keepsake_photo,
				keepsake_price,keepsake_point,keepsake_introduce, Integer.parseInt(keepsake_stock));

		int count = web_animal_keepsakeDao.insert(keepsake);

		// 成功或失败重定向到哪里

		if (count > 0) {
			response.sendRedirect("admin_keepsakeselect");
		} else {
			PrintWriter out = response.getWriter();

			out.write("<script>");
			out.write("alert('添加纪念品失败');");
			out.write("location.href='manage/admin_tokeepsakeadd?';");
			out.write("</script>");

		}
	}

}
