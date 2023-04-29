package com.web_animal.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.web_animal.dao.Basedao;
import com.web_animal.entity.web_animal_animal;

public class web_animal_animalDao {

	/**
	 * 插入动物信息
	 * 
	 * @param animal
	 * @return
	 */
	public static int insert(web_animal_animal a) {
		String sql = "insert into web_animal_animal values(null,?, ?, ?, ?, ?, ?, ?, 0, ?, ?)";

		Object[] params = { a.getAnimal_name(), a.getAnimal_latin(), a.getAnimal_fid(), a.getAnimal_cid(),
				a.getAnimal_photo(), a.getAnimal_audio(), a.getAnimal_video(),
				// a.getAnimal_point(), 初始为0,表示动物点击数
				a.getAnimal_introduce(), a.getAnimal_other() };

		return Basedao.exectuIUD(sql, params);
	}

	/**
	 * 获取前top个动物信息
	 * 
	 * @param top
	 * @param flag
	 * @return
	 */
	public static ArrayList<web_animal_animal> selectAll(int top) {

		web_animal_animal a = null;
		ArrayList<web_animal_animal> list = new ArrayList<web_animal_animal>();

		// 结果集
		ResultSet rs = null;

		// 获取连接对象，连接数据库
		Connection conn = Basedao.getconn();

		PreparedStatement ps = null;
		String sql = null;
		try {
			sql = "select * from web_animal_animal order by animal_point desc";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			int count = 0;
			while (rs.next()) {

				a = new web_animal_animal(rs.getInt("animal_id"), rs.getString("animal_name"),
						rs.getString("animal_latin"), rs.getInt("animal_fid"), rs.getInt("animal_cid"),
						rs.getString("animal_photo"), rs.getString("animal_audio"), rs.getString("animal_video"),
						rs.getInt("animal_point"), rs.getString("animal_introduce"), rs.getString("animal_other"));

				list.add(a);
				count++;
				if (count == top) {
					return list;
				}
			}

		} catch (

		Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Basedao.closeall(rs, ps, conn);
		}
		return list;
	}

	/**
	 * 动物更新操作
	 * 
	 * @param animal
	 * @return
	 */
	public static int update(web_animal_animal animal) {
		String sql = "update web_animal_animal set animal_name=?, animal_latin=?,animal_introduce=?,animal_other=? where animal_id=?";

		Object[] params = { animal.getAnimal_name(), animal.getAnimal_latin(), animal.getAnimal_introduce(),
				animal.getAnimal_other(), animal.getAnimal_id() };

		return Basedao.exectuIUD(sql, params);
	}

	/**
	 * 动物点击数更新操作
	 * 
	 * @param animal
	 * @return
	 */
	public static int UpdatePoint(int id,int point) {
		String sql = "update web_animal_animal set animal_point=? where animal_id=?";

		Object[] params = { point,id};

		return Basedao.exectuIUD(sql, params);
	}

	/**
	 * 使用动物ID删除动物
	 * 
	 * @param animal_id
	 * @return
	 */
	public static int delanimal(int animal_id) {

		String sql = "delete from web_animal_animal where animal_id=?";

		Object[] params = { animal_id };

		return Basedao.exectuIUD(sql, params);

	}

	/**
	 * 查询所有动物信息
	 * 
	 * @return
	 */
	public static ArrayList<web_animal_animal> selectAll() {

		web_animal_animal a = null;
		ArrayList<web_animal_animal> list = new ArrayList<web_animal_animal>();

		// 结果集
		ResultSet rs = null;

		// 获取连接对象，连接数据库
		Connection conn = Basedao.getconn();

		PreparedStatement ps = null;
		String sql = null;
		try {

			sql = "select * from web_animal_animal";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {

				a = new web_animal_animal(rs.getInt("animal_id"), rs.getString("animal_name"),
						rs.getString("animal_latin"), rs.getInt("animal_fid"), rs.getInt("animal_cid"),
						rs.getString("animal_photo"), rs.getString("animal_audio"), rs.getString("animal_video"),
						rs.getInt("animal_point"), rs.getString("animal_introduce"), rs.getString("animal_other"));

				list.add(a);
			}

		} catch (

		Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Basedao.closeall(rs, ps, conn);
		}
		return list;
	}

	/**
	 * 使用动物ID查询动物信息
	 * 
	 * @param id
	 * @return
	 */
	public static web_animal_animal selectByID(int id) {

		web_animal_animal animal = null;
		;
		// 结果集
		ResultSet rs = null;

		// 获取连接对象，连接数据库
		Connection conn = Basedao.getconn();

		PreparedStatement ps = null;

		try {
			String sql = "select * from web_animal_animal where animal_id=?";

			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();

			while (rs.next()) {

				animal = new web_animal_animal(rs.getInt("animal_id"), rs.getString("animal_name"),
						rs.getString("animal_latin"), rs.getInt("animal_fid"), rs.getInt("animal_cid"),
						rs.getString("animal_photo"), rs.getString("animal_audio"), rs.getString("animal_video"),
						rs.getInt("animal_point"), rs.getString("animal_introduce"), rs.getString("animal_other"));

			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Basedao.closeall(rs, ps, conn);
		}

		return animal;
	}

	/**
	 * 使用关键字模糊化查询动物列表
	 * 
	 * @param keywords
	 * @return
	 */
	public static ArrayList<web_animal_animal> selectByName(String keywords) {

		web_animal_animal animal = null;
		ArrayList<web_animal_animal> list = new ArrayList<web_animal_animal>();
		// 结果集
		ResultSet rs = null;

		// 获取连接对象，连接数据库
		Connection conn = Basedao.getconn();

		PreparedStatement ps = null;
		String sql = "";
		try {
			if (keywords != null) {
				sql = "select * from web_animal_animal where animal_name like ? order by animal_id";

				ps = conn.prepareStatement(sql);
				ps.setString(1, "%" + keywords + "%");

			} else {
				sql = "select * from web_animal_animal order by animal_id";

				ps = conn.prepareStatement(sql);
			}
			rs = ps.executeQuery();

			while (rs.next()) {

				animal = new web_animal_animal(rs.getInt("animal_id"), rs.getString("animal_name"),
						rs.getString("animal_latin"), rs.getInt("animal_fid"), rs.getInt("animal_cid"),
						rs.getString("animal_photo"), rs.getString("animal_audio"), rs.getString("animal_video"),
						rs.getInt("animal_point"), rs.getString("animal_introduce"), rs.getString("animal_other"));
				list.add(animal);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Basedao.closeall(rs, ps, conn);
		}

		return list;
	}

	/**
	 * 通过动物类别ID，查询所有动物列表信息
	 * 
	 * @param id
	 * @param flag
	 *            判断是FID或CID
	 * @return
	 */
	public static ArrayList<web_animal_animal> selectAllByID(int id, int flag) {

		ArrayList<web_animal_animal> list = new ArrayList<web_animal_animal>();
		// 结果集
		ResultSet rs = null;

		// 获取连接对象，连接数据库
		Connection conn = Basedao.getconn();

		PreparedStatement ps = null;
		String sql = null;
		try {
			if (flag == 0) {

				sql = "select * from web_animal_animal where animal_fid=?";

			} else {

				sql = "select * from web_animal_animal where animal_cid=?";

			}
			ps = conn.prepareStatement(sql);

			ps.setInt(1, id);
			rs = ps.executeQuery();

			while (rs.next()) {

				web_animal_animal a = new web_animal_animal(rs.getInt("animal_id"), rs.getString("animal_name"),
						rs.getString("animal_latin"), rs.getInt("animal_fid"), rs.getInt("animal_cid"),
						rs.getString("animal_photo"), rs.getString("animal_audio"), rs.getString("animal_video"),
						rs.getInt("animal_point"), rs.getString("animal_introduce"), rs.getString("animal_other"));

				list.add(a);
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
