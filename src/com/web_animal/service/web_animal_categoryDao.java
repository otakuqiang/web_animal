package com.web_animal.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.web_animal.dao.Basedao;
import com.web_animal.entity.web_animal_category;

public class web_animal_categoryDao {

	/**
	 * 类别插入操作
	 * @param cate
	 * @return
	 */ 
	public static int insert(web_animal_category cate) {
		
		String sql = "insert into web_animal_category values(null,?, ?)";
		
		Object[] params = {
				cate.getCate_name(),
				cate.getCate_parent_id()		
		};
		return Basedao.exectuIUD(sql, params);
	}
	
	
	/**
	 * 类别更新操作
	 * @param cate
	 * @return
	 */
	public static int update(web_animal_category cate) {
		
		String sql = "update web_animal_category set cate_name=?, cate_parent_id=? where cate_id=?";
		
		Object[] params = {
				cate.getCate_name(),
				cate.getCate_parent_id(),
				cate.getCate_id()
		};
		return Basedao.exectuIUD(sql, params);
	}
	
	
	/**
	 * 通过ID查找类别
	 * 
	 * @param cpage
	 * @param count
	 * @param user_keyword
	 * @return
	 */
	public static web_animal_category selectByID(int cate_id) {

		web_animal_category cate = null;

		// 声明结果集
		ResultSet rs = null;

		// 获取连接对象，连接数据库
		Connection conn = Basedao.getconn();

		PreparedStatement ps = null;

		try {
			String sql = "select * from web_animal_category where cate_id=?";

			ps = conn.prepareStatement(sql);

			ps.setInt(1, cate_id);
			rs = ps.executeQuery();

			while (rs.next()) {

				cate = new web_animal_category(
						rs.getInt("cate_id"),
						rs.getString("cate_name"),
						rs.getInt("cate_parent_id"));}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Basedao.closeall(rs, ps, conn);
		}

		return cate;
	}
	
	/**
	 * 类别刪除操作
	 * @param cate
	 * @return
	 */
	public static int del(int id) {
		
		String sql = "delete from web_animal_category where cate_id=?";
		
		Object[] params = {id};
		
		return Basedao.exectuIUD(sql, params);
	}
	
	
	
	/**
	 * 获取所有分类
	 * @param cpage
	 * @param count
	 * @param user_keyword
	 * @return
	 */
	public static ArrayList<web_animal_category> selectAll() {

		ArrayList<web_animal_category> catelist = new ArrayList<web_animal_category>();
		// 结果集
		ResultSet rs = null;

		// 获取连接对象，连接数据库
		Connection conn = Basedao.getconn();

		// System.out.println("查询分类信息连接数据库");

		PreparedStatement ps = null;

		try {
			String sql = "select * from web_animal_category";

			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {

				web_animal_category cate = new web_animal_category(
						rs.getInt("cate_id"), 
						rs.getString("cate_name"),
						rs.getInt("cate_parent_id"));
				catelist.add(cate);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Basedao.closeall(rs, ps, conn);
		}

		return catelist;
	}
	
	/**
	 * 获取分类,子分类和父分类
	 * @param cpage
	 * @param count
	 * @param user_keyword
	 * @return
	 */
	public static ArrayList<web_animal_category> selectCat(String flag) {

		ArrayList<web_animal_category> catelist = new ArrayList<web_animal_category>();
		// 结果集
		ResultSet rs = null;

		// 获取连接对象，连接数据库
		Connection conn = Basedao.getconn();

		// System.out.println("查询分类信息连接数据库");

		PreparedStatement ps = null;

		try {
			String sql = null;
			if (flag!=null && flag.equals("father")) {
				
				sql = "select * from web_animal_category where cate_parent_id=0";
			}else{
				
				sql = "select * from web_animal_category where cate_parent_id!=0";

			}
			
			
			
			

			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {

				web_animal_category cate = new web_animal_category(
						rs.getInt("cate_id"), 
						rs.getString("cate_name"),
						rs.getInt("cate_parent_id"));
				catelist.add(cate);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Basedao.closeall(rs, ps, conn);
		}

		return catelist;
	}
	
	
	
	

}
