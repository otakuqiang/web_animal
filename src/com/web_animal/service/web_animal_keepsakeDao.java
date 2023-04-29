package com.web_animal.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.web_animal.dao.Basedao;
import com.web_animal.entity.web_animal_keepsake;

public class web_animal_keepsakeDao {

	/**
	 * 纪念品插入操作
	 * 
	 * @param
	 * @return
	 */
	public static int insert(web_animal_keepsake keepsake) {
		String sql = "insert into web_animal_keepsake values(?, ?, ?, ?, ?, ?, ?)";

		Object[] params = { keepsake.getKeepsake_id(), keepsake.getKeepsake_name(), keepsake.getKeepsake_photo(),
				keepsake.getKeepsake_price(),keepsake.getKeepsake_point(), keepsake.getKeepsake_introduce(), keepsake.getKeepsake_stock() };

		return Basedao.exectuIUD(sql, params);
	}

	/**
	 * 纪念品库存更新操作
	 * @param kid
	 * @return
	 */
	public static int updateStock(int count,int kid) {
		String sql = "update web_animal_keepsake set keepsake_stock=keepsake_stock-? where keepsake_id=?";

		Object[] params = {count,kid};

		return Basedao.exectuIUD(sql, params);
	}

	
	/**
	 * 通过ID查找纪念品信息
	 * 
	 * @param keepsake_id
	 * @return
	 */
	public static web_animal_keepsake selectByID(int keepsake_id) {

		web_animal_keepsake keepsake = null;

		// 结果集
		ResultSet rs = null;

		// 获取连接对象，连接数据库
		Connection conn = Basedao.getconn();

		// System.out.println("查询用户信息连接数据库");

		PreparedStatement ps = null;

		try {
			String sql = "select * from web_animal_keepsake where keepsake_id=?";

			ps = conn.prepareStatement(sql);

			ps.setInt(1, keepsake_id);
			rs = ps.executeQuery();

			while (rs.next()) {

				keepsake = new web_animal_keepsake(rs.getInt("keepsake_id"), rs.getString("keepsake_name"),
						rs.getString("keepsake_photo"), rs.getDouble("keepsake_price"), rs.getInt("keepsake_point"),
						rs.getString("keepsake_introduce"), rs.getInt("Keepsake_stock"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Basedao.closeall(rs, ps, conn);
		}
		// System.out.println(keepsake);
		return keepsake;
	}

	/**
	 * 纪念品查询操作
	 * 
	 * @return
	 */
	public static ArrayList<web_animal_keepsake> selectAll() {

		ArrayList<web_animal_keepsake> list = new ArrayList<web_animal_keepsake>();
		// 结果集
		ResultSet rs = null;

		// 获取连接对象，连接数据库
		Connection conn = Basedao.getconn();

		PreparedStatement ps = null;

		try {
			String sql = "select * from web_animal_keepsake";

			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {

				web_animal_keepsake keepsake = new web_animal_keepsake(rs.getInt("keepsake_id"),
						rs.getString("keepsake_name"), rs.getString("keepsake_photo"), rs.getDouble("keepsake_price"),
						rs.getInt("keepsake_point"), rs.getString("keepsake_introduce"), rs.getInt("Keepsake_stock"));

				list.add(keepsake);
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
