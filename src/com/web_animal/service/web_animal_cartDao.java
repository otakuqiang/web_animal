package com.web_animal.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.web_animal.dao.Basedao;
import com.web_animal.entity.web_animal_cart;

public class web_animal_cartDao {

	/**
	 * 插入购物车信息
	 * 
	 * @param cart
	 * @return
	 */
	public static int insert(web_animal_cart cart) {

		String sql = "insert into web_animal_cart values(null, ?, ?, ?, ?, ?, ?, ?, ?, 1)";

		Object[] params = { cart.getCart_k_name(), cart.getCart_k_photo(), cart.getCart_k_price(),
				cart.getCart_k_point(), cart.getCart_quantity(), cart.getCart_k_stock(), cart.getCart_k_id(),
				cart.getCart_u_id() };

		return Basedao.exectuIUD(sql, params);
	}

	/**
	 * 购物车纪念品删除操作
	 * 
	 * @param id
	 * @return
	 */
	public static int Delete(int id) {

		String sql = "delete from web_animal_cart where cart_id=?";

		Object[] params = { id };
		return Basedao.exectuIUD(sql, params);
	}

	/**
	 * 购物车查询操作
	 * 
	 * @param uid
	 * @param kid
	 * @return
	 */
	public static web_animal_cart getCartList(int id) {
		web_animal_cart cart = null;

		// 结果集
		ResultSet rs = null;

		// 获取连接对象，连接数据库
		Connection conn = Basedao.getconn();

		PreparedStatement ps = null;

		try {
			String sql = "select * from web_animal_cart where cart_id=? and cart_valid=1";

			ps = conn.prepareStatement(sql);

			ps.setInt(1, id);

			rs = ps.executeQuery();

			while (rs.next()) {

				cart = new web_animal_cart(rs.getInt("cart_id"), rs.getString("cart_k_name"),
						rs.getString("cart_k_photo"), rs.getDouble("cart_k_price"), rs.getInt("cart_k_point"),
						rs.getInt("cart_quantity"), rs.getInt("cart_k_stock"), rs.getInt("cart_k_id"),
						rs.getString("cart_u_id"), rs.getInt("cart_valid"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Basedao.closeall(rs, ps, conn);
		}

		return cart;
	}

	/**
	 * 购物车查询操作
	 * 
	 * @param id
	 * @return
	 */
	public static ArrayList<web_animal_cart> getCart(String id) {

		ArrayList<web_animal_cart> list = new ArrayList<web_animal_cart>();
		// 结果集
		ResultSet rs = null;

		// 获取连接对象，连接数据库
		Connection conn = Basedao.getconn();

		PreparedStatement ps = null;

		try {
			String sql = "select * from web_animal_cart where cart_u_id=? and cart_valid=1 order by cart_id desc";

			ps = conn.prepareStatement(sql);

			ps.setString(1, id);

			rs = ps.executeQuery();

			while (rs.next()) {

				web_animal_cart cart = new web_animal_cart(rs.getInt("cart_id"), rs.getString("cart_k_name"),
						rs.getString("cart_k_photo"), rs.getDouble("cart_k_price"), rs.getInt("cart_k_point"),
						rs.getInt("cart_quantity"), rs.getInt("cart_k_stock"), rs.getInt("cart_k_id"),
						rs.getString("cart_u_id"), rs.getInt("cart_valid"));

				list.add(cart);
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
	 * 更新购物车同名纪念品的数量
	 * 
	 * @param esid
	 * @param count
	 * @return
	 */
	public static int updateNum(int esid, int count) {

		String sql = "update web_animal_cart set cart_quantity=? where cart_id=?";

		Object[] params = { count, esid };

		return Basedao.exectuIUD(sql, params);

	}
	/**
	 * 更新购物车纪念品的状态
	 * @param valid
	 * @param cid
	 * @return
	 */
	public static int updateValid(int valid,int cid) {

		String sql = "update web_animal_cart set cart_valid=? where cart_id=?";

		Object[] params = { valid, cid };

		return Basedao.exectuIUD(sql, params);

	}

	/**
	 * 购物车查询操作
	 * 
	 * @param uid
	 * @param kid
	 * @return
	 */
	public static web_animal_cart getCartExist(String uid, int kid) {
		web_animal_cart cart = null;

		// 结果集
		ResultSet rs = null;

		// 获取连接对象，连接数据库
		Connection conn = Basedao.getconn();

		PreparedStatement ps = null;

		try {
			String sql = "select * from web_animal_cart where cart_u_id=? and cart_k_id=? and cart_valid=1 order by cart_id desc";

			ps = conn.prepareStatement(sql);

			ps.setString(1, uid);
			ps.setInt(2, kid);

			rs = ps.executeQuery();

			while (rs.next()) {

				cart = new web_animal_cart(rs.getInt("cart_id"), rs.getString("cart_k_name"),
						rs.getString("cart_k_photo"), rs.getDouble("cart_k_price"), rs.getInt("cart_k_point"),
						rs.getInt("cart_quantity"), rs.getInt("cart_k_stock"), rs.getInt("cart_k_id"),
						rs.getString("cart_u_id"), rs.getInt("cart_valid"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Basedao.closeall(rs, ps, conn);
		}

		return cart;
	}

}
