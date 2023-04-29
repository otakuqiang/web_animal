package com.web_animal.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.web_animal.dao.Basedao;
import com.web_animal.entity.web_animal_user;

public class web_animal_userDao {

	/**
	 * 用户插入操作
	 * 
	 * @param user
	 * @return
	 */
	public static int insert(web_animal_user user) {
		String sql = "insert into web_animal_user values(?, ?, ?, ?, ?, ?, ?, ?, ?)";

		Object[] params = { user.getUser_id(), user.getUser_name(), user.getUser_password(), user.getUser_sex(),
				user.getUser_money(), user.getUser_point(), user.getUser_mobile(), user.getUser_address(),
				user.getUser_status() };

		return Basedao.exectuIUD(sql, params);
	}

	/**
	 * 用户更新操作
	 * 
	 * @param user
	 * @return
	 */
	public static int update(web_animal_user user) {
		String sql = "update web_animal_user set user_name=?, user_password=?, user_sex=?, user_mobile=?, user_address=? where user_id=?";

		Object[] params = { user.getUser_name(), user.getUser_password(), user.getUser_sex(), user.getUser_mobile(),
				user.getUser_address(), user.getUser_id() };

		return Basedao.exectuIUD(sql, params);
	}

	/**
	 * 用户更新积分
	 * 
	 * @param user
	 * @return
	 */
	public static int updatePoint(String uid) {
		String sql = "UPDATE web_animal_user set user_point=user_point+10 where user_id=?";

		Object[] params = { uid };

		return Basedao.exectuIUD(sql, params);
	}

	/**
	 * 用户更新余额或积分
	 * 
	 * @param user
	 * @return
	 */
	public static int updateM(Double money, String uid) {
		String sql = null;
		sql = "UPDATE web_animal_user set user_money=user_money-? where user_id=?";
		Object[] params = { money, uid };

		return Basedao.exectuIUD(sql, params);
	}

	/**
	 * 用户更新余额或积分
	 * 
	 * @param user
	 * @return
	 */
	public static int updateP(int point, String uid) {
		String sql = "UPDATE web_animal_user set user_point=user_point-? where user_id=?";
		Object[] params = { point, uid };

		return Basedao.exectuIUD(sql, params);
	}

	/**
	 * 用户总页数
	 * 
	 * @param count
	 * @param user_keyword
	 * @return
	 */
	public static int[] totalPage(int count, String user_keyword) {
		int arr[] = { 0, 1 };

		Connection conn = Basedao.getconn();

		// System.out.println("totalPage数据库连接成功");

		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			String sql = "";

			if (null != user_keyword) {
				sql = "select count(*) from web_animal_user where user_name like ?";
				ps = conn.prepareStatement(sql);
				ps.setString(1, "%" + user_keyword + "%");

			} else {
				sql = "select count(*) from web_animal_user";

				ps = conn.prepareStatement(sql);

			}

			rs = ps.executeQuery();

			while (rs.next()) {
				arr[0] = rs.getInt(1);

				if (arr[0] % count == 0) {
					arr[1] = arr[0] / count;
				} else {
					arr[1] = arr[0] / count + 1;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Basedao.closeall(rs, ps, conn);
		}

		return arr;
	}

	/**
	 * 用户删除操作
	 * 
	 * @param cpage
	 * @param count
	 * @param user_keyword
	 * @return
	 */
	public static int deluser(String user_id) {

		String sql = "delete from web_animal_user where user_id =?";

		Object[] params = { user_id };

		return Basedao.exectuIUD(sql, params);

	}

	/**
	 * 用户查询操作
	 * 
	 * @param cpage
	 * @param count
	 * @param user_keyword
	 * @return
	 */
	public static ArrayList<web_animal_user> selectAll(int cpage, int count, String user_keyword) {

		ArrayList<web_animal_user> userlist = new ArrayList<web_animal_user>();
		// 结果集
		ResultSet rs = null;

		// 获取连接对象，连接数据库
		Connection conn = Basedao.getconn();

		// System.out.println("查询用户信息连接数据库");

		PreparedStatement ps = null;

		try {
			String sql = "";

			if (null != user_keyword) {

				// 判断关键字是否为空
				sql = "select * from web_animal_user where user_name like ? order by user_id desc limit ?, ?";
				ps = conn.prepareStatement(sql);

				// 传递参数
				ps.setString(1, "%" + user_keyword + "%");
				ps.setInt(2, (cpage - 1) * count);
				ps.setInt(3, count);

			} else {

				sql = "select * from web_animal_user order by user_id desc limit ?, ?";

				ps = conn.prepareStatement(sql);

				// 传递参数
				ps.setInt(1, (cpage - 1) * count);
				ps.setInt(2, count);

			}

			rs = ps.executeQuery();

			web_animal_user user = null;

			while (rs.next()) {

				user = new web_animal_user(rs.getString("user_id"), rs.getString("user_name"),
						rs.getString("user_password"), rs.getString("user_sex"), rs.getDouble("user_money"),
						rs.getInt("user_point"), rs.getString("user_mobile"), rs.getString("user_address"),
						rs.getString("user_status"));
				userlist.add(user);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Basedao.closeall(rs, ps, conn);
		}

		return userlist;
	}

	/**
	 * 通过ID和密码查找用户，实现用户登录功能
	 * 
	 * @param user_id
	 * @param user_password
	 * @return
	 */
	public static web_animal_user selectByID_Pwd(String user_id, String user_password) {

		web_animal_user user = null;

		// 连接数据库
		Connection conn = Basedao.getconn();
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			String sql = "select * from web_animal_user where user_id=? and user_password=?";

			ps = conn.prepareStatement(sql);

			ps.setString(1, user_id);
			ps.setString(2, user_password);

			rs = ps.executeQuery();

			while (rs.next()) {
				user = new web_animal_user(rs.getString("user_id"), rs.getString("user_name"),
						rs.getString("user_password"), rs.getString("user_sex"), rs.getDouble("user_money"),
						rs.getInt("user_point"), rs.getString("user_mobile"), rs.getString("user_address"),
						rs.getString("user_status"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Basedao.closeall(rs, ps, conn);
		}
		return user;
	}

	/**
	 * 通过ID查找用户
	 * 
	 * @param cpage
	 * @param count
	 * @param user_keyword
	 * @return
	 */
	public static web_animal_user selectByID(String user_id) {

		web_animal_user user = null;

		// 结果集
		ResultSet rs = null;

		// 获取连接对象，连接数据库
		Connection conn = Basedao.getconn();

		// System.out.println("查询用户信息连接数据库");

		PreparedStatement ps = null;

		try {
			String sql = "select * from web_animal_user where user_id=?";

			ps = conn.prepareStatement(sql);

			ps.setString(1, user_id);
			rs = ps.executeQuery();

			while (rs.next()) {

				user = new web_animal_user(rs.getString("user_id"), rs.getString("user_name"),
						rs.getString("user_password"), rs.getString("user_sex"), rs.getDouble("user_money"),
						rs.getInt("user_point"), rs.getString("user_mobile"), rs.getString("user_address"),
						rs.getString("user_status"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Basedao.closeall(rs, ps, conn);
		}

		return user;
	}

}
