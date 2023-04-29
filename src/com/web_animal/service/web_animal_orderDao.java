package com.web_animal.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.web_animal.dao.Basedao;
import com.web_animal.entity.web_animal_order;

public class web_animal_orderDao {

	/**
	 * 订单添加
	 * 
	 * @param order
	 * @return
	 */
	public static int insert(web_animal_order order) {

		String sql = "insert into web_animal_order values(null, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		Object[] params = { order.getOrder_u_id(), order.getOrder_k_id(), order.getOrder_u_name(),
				order.getOrder_k_photo(), order.getOrder_u_address(), order.getOrder_money(), order.getOrder_point(),
				order.getOrder_quantity(), order.getOrder_method(), order.getOrder_status() };

		return Basedao.exectuIUD(sql, params);
	}

	/**
	 * 删除订单,实际上不可删除
	 * 
	 * @param id
	 * @return
	 */
	public static int Delete(int id) {

		String sql = "delete from web_animal_order where order_id=?";

		Object[] params = { id };
		return Basedao.exectuIUD(sql, params);
	}

	/**
	 * 通过用户ID获取所有订单信息集合
	 * 
	 * @param uid
	 * @return
	 */
	public static ArrayList<web_animal_order> getOrder(String uid) {
		ArrayList<web_animal_order> list = new ArrayList<web_animal_order>();
		// 结果集
		ResultSet rs = null;

		// 获取连接对象，连接数据库
		Connection conn = Basedao.getconn();

		PreparedStatement ps = null;
		try {
			String sql = "select * from web_animal_order where order_u_id=?";

			ps = conn.prepareStatement(sql);

			ps.setString(1, uid);

			rs = ps.executeQuery();

			while (rs.next()) {

				web_animal_order order = new web_animal_order(rs.getInt("order_id"), rs.getString("order_u_id"),
						rs.getInt("order_k_id"), rs.getString("order_u_name"), rs.getString("order_k_photo"),
						rs.getString("order_u_address"), rs.getDouble("order_money"), rs.getInt("order_point"),
						rs.getInt("order_quantity"), rs.getString("order_method"), rs.getString("order_status"));

				list.add(order);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Basedao.closeall(rs, ps, conn);
		}

		return list;
	}

	/**
	 * 通过用户ID和订单状态，获取所有订单信息集合
	 * 
	 * @param uid
	 * @return
	 */
	public static ArrayList<web_animal_order> SelectBy_F(String uid,String flag) {
		ArrayList<web_animal_order> list = new ArrayList<web_animal_order>();
		// 结果集
		ResultSet rs = null;

		// 获取连接对象，连接数据库
		Connection conn = Basedao.getconn();

		PreparedStatement ps = null;
		try {
			String sql = "select * from web_animal_order where order_u_id=? and order_status=?";

			ps = conn.prepareStatement(sql);

			ps.setString(1, uid);
			ps.setString(2, flag);

			rs = ps.executeQuery();

			while (rs.next()) {

				web_animal_order order = new web_animal_order(rs.getInt("order_id"), rs.getString("order_u_id"),
						rs.getInt("order_k_id"), rs.getString("order_u_name"), rs.getString("order_k_photo"),
						rs.getString("order_u_address"), rs.getDouble("order_money"), rs.getInt("order_point"),
						rs.getInt("order_quantity"), rs.getString("order_method"), rs.getString("order_status"));

				list.add(order);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Basedao.closeall(rs, ps, conn);
		}

		return list;
	}

	
	/**
	 * 通过用户ID获取所有订单数
	 * 
	 * @param uid
	 * @return
	 */
	public static int[] selectNum(String uid) {
		// 全部、待收货、已完成
		int all = 0, temp = 0, res = 0;
		int[] num = new int[3];
		// 结果集
		ResultSet rs = null;

		// 获取连接对象，连接数据库
		Connection conn = Basedao.getconn();

		PreparedStatement ps = null;
		try {
			String sql = "select * from web_animal_order where order_u_id=?";

			ps = conn.prepareStatement(sql);

			ps.setString(1, uid);

			rs = ps.executeQuery();

			while (rs.next()) {

				web_animal_order order = new web_animal_order(rs.getInt("order_id"), rs.getString("order_u_id"),
						rs.getInt("order_k_id"), rs.getString("order_u_name"), rs.getString("order_k_photo"),
						rs.getString("order_u_address"), rs.getDouble("order_money"), rs.getInt("order_point"),
						rs.getInt("order_quantity"), rs.getString("order_method"), rs.getString("order_status"));
				all++;
				if (order.getOrder_status().equals("1")) {
					temp++;
				} else if (order.getOrder_status().equals("2")) {
					res++;
				}
			}
			num[0] = all;
			num[1] = temp;
			num[2] = res;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Basedao.closeall(rs, ps, conn);
		}

		return num;
	}

	/**
	 * 所有订单信息集合
	 * 
	 * @param uid
	 * @return
	 */
	public static ArrayList<web_animal_order> OrderAll() {
		ArrayList<web_animal_order> list = new ArrayList<web_animal_order>();
		// 结果集
		ResultSet rs = null;

		// 获取连接对象，连接数据库
		Connection conn = Basedao.getconn();

		PreparedStatement ps = null;
		try {
			String sql = "select * from web_animal_order";

			ps = conn.prepareStatement(sql);

			rs = ps.executeQuery();

			while (rs.next()) {

				web_animal_order order = new web_animal_order(rs.getInt("order_id"), rs.getString("order_u_id"),
						rs.getInt("order_k_id"), rs.getString("order_u_name"), rs.getString("order_k_photo"),
						rs.getString("order_u_address"), rs.getDouble("order_money"), rs.getInt("order_point"),
						rs.getInt("order_quantity"), rs.getString("order_method"), rs.getString("order_status"));

				list.add(order);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Basedao.closeall(rs, ps, conn);
		}

		return list;
	}

}
