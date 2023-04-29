package com.web_animal.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.web_animal.dao.Basedao;
import com.web_animal.entity.web_animal_collect;

public class web_animal_collectDao {

	/**
	 * 添加用户收藏
	 * 
	 * @param collect
	 * @return
	 */
	public static int insert(web_animal_collect collect) {
		String sql = "insert into web_animal_collect values(null, ?, ?, ?)";

		Object[] params = { collect.getCollect_u_id(), collect.getCollect_k_a_id(), collect.getCollect_state() };

		return Basedao.exectuIUD(sql, params);
	}

	/**
	 * 通过收藏ID进行删除
	 * 
	 * @param id
	 * @return
	 */

	public static int delcollect(int id) {

		String sql = "delete from web_animal_collect where collect_id=?";

		Object[] params = { id };

		return Basedao.exectuIUD(sql, params);

	}

	/**
	 * 查询单个收藏信息，返回收藏对象
	 * 
	 * @param user_id
	 * @param k_a_id
	 * @param state
	 * @return
	 */
	public static web_animal_collect selectCollect(String user_id, int k_a_id, int state) {
		web_animal_collect collect = null;
		// 结果集
		ResultSet rs = null;

		// 获取连接对象，连接数据库
		Connection conn = Basedao.getconn();

		PreparedStatement ps = null;
		String sql = "";
		try {

			sql = "select * from web_animal_collect where collect_u_id=? and collect_k_a_id=? and collect_state=?";
			ps = conn.prepareStatement(sql);

			// 传递参数
			ps.setString(1, user_id);
			ps.setInt(2, k_a_id);
			ps.setInt(3, state);

			rs = ps.executeQuery();

			while (rs.next()) {

				collect = new web_animal_collect(rs.getInt("collect_id"), rs.getString("collect_u_id"),
						rs.getInt("collect_k_a_id"), rs.getInt("collect_state"));
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Basedao.closeall(rs, ps, conn);
		}
		return collect;
	}

	/**
	 * 查询某用户的收藏信息集合
	 * 
	 * @param uid
	 * @return
	 */
	public static ArrayList<web_animal_collect> selectByUid(String uid, int state) {

		ArrayList<web_animal_collect> clist = new ArrayList<>();
		// 结果集
		ResultSet rs = null;

		// 获取连接对象，连接数据库
		Connection conn = Basedao.getconn();

		PreparedStatement ps = null;
		try {

			String sql = "select * from web_animal_collect where collect_u_id=? and collect_state=?";
			ps = conn.prepareStatement(sql);
			// 传递参数
			ps.setString(1, uid);
			ps.setInt(2, state);

			rs = ps.executeQuery();
			
			while (rs.next()) {
				web_animal_collect c = new web_animal_collect(rs.getInt("collect_id"),
						rs.getString("collect_u_id"), rs.getInt("collect_k_a_id"), rs.getInt("collect_state"));
				clist.add(c);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Basedao.closeall(rs, ps, conn);
		}
		return clist;
	}

	/**
	 * 查询某用户所有收藏数量
	 * 
	 * @param uid
	 * @return
	 */
	public static int selectNum(String uid) {
		int count = 0;
		// 结果集
		ResultSet rs = null;

		// 获取连接对象，连接数据库
		Connection conn = Basedao.getconn();
		PreparedStatement ps = null;
		try {

			String sql = "select * from web_animal_collect where collect_u_id=?";
			ps = conn.prepareStatement(sql);

			// 传递参数
			ps.setString(1, uid);

			rs = ps.executeQuery();

			while (rs.next()) {
				count++;
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Basedao.closeall(rs, ps, conn);
		}
		return count;
	}
}
