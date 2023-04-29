package com.web_animal.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.web_animal.dao.Basedao;
import com.web_animal.entity.web_animal_science;

public class web_animal_scienceDao {

	/**
	 * 科普信息插入
	 * 
	 * @param science
	 * @return
	 */
	public static int insert(web_animal_science science) {
		String sql = "insert into web_animal_science values(null, ?, ?, ?)";

		Object[] params = { science.getScience_title(), science.getScience_photo(), science.getScience_text() };

		return Basedao.exectuIUD(sql, params);
	}

	/**
	 * 用户更新操作
	 * 
	 * @param user
	 * @return
	 */
	public static int Update(web_animal_science science) {
		String sql = "update web_animal_science set science_title=?, science_photo=?, science_text=? where science_id=?";

		Object[] params = { science.getScience_title(), science.getScience_photo(), science.getScience_text(),science.getScience_id() };

		return Basedao.exectuIUD(sql, params);
	}
	
	/**
	 * 科普信息删除
	 * @param id
	 * @return
	 */
	public static int delScience(int id) {

		String sql = "delete from web_animal_science where science_id=?";

		Object[] params = { id };

		return Basedao.exectuIUD(sql, params);

	}
	
	/**
	 * 通过ID查询科普信息
	 * 
	 * @param id
	 * @return
	 */
	public static web_animal_science selectByID(int id) {

		web_animal_science science = null;
		// 结果集
		ResultSet rs = null;

		// 获取连接对象，连接数据库
		Connection conn = Basedao.getconn();

		PreparedStatement ps = null;

		try {
			String sql = "select * from web_animal_science where science_id=?";

			ps = conn.prepareStatement(sql);

			ps.setInt(1, id);
			rs = ps.executeQuery();
			while(rs.next()){
			science = new web_animal_science(rs.getInt("science_id"), rs.getString("science_title"),
					rs.getString("science_photo"), rs.getString("science_text"));

			}
		} catch (

		Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Basedao.closeall(rs, ps, conn);
		}

		return science;
	}

	/**
	 * 科普信息查询
	 * 
	 * @return
	 */
	public static ArrayList<web_animal_science> selectAll() {

		ArrayList<web_animal_science> list = new ArrayList<web_animal_science>();
		// 结果集
		ResultSet rs = null;

		// 获取连接对象，连接数据库
		Connection conn = Basedao.getconn();

		PreparedStatement ps = null;

		try {
			String sql = "select * from web_animal_science";

			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {

				web_animal_science science = new web_animal_science(rs.getInt("science_id"),
						rs.getString("science_title"), rs.getString("science_photo"), rs.getString("science_text"));

				list.add(science);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Basedao.closeall(rs, ps, conn);
		}

		return list;
	}
}
