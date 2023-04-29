package com.web_animal.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Basedao {
	/**
	 * 连接的方法
	 * 
	 * 关闭的方法
	 * 
	 * 通用的SQL语句
	 */
	//静态代码块，加载驱动  此处为MySQL8.0的连接方式
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	//连接的方法
	public static Connection getconn(){
		Connection conn = null;
		//"jdbc:mysql://localhost:3306/web_animal?useSSL=false&serverTimezone=UTC"
		String url="jdbc:mysql://localhost:3306/web_animal?useSSL=false&serverTimezone=UTC&useUnicode=true&characterEncoding=UTF-8";
		try{
			conn = DriverManager.getConnection(url,"root","123456");
		}catch(SQLException e){
			e.printStackTrace();
		}
		//System.out.println("数据库连接成功");
	return conn; 
	}
	
	//通用的SQL语句    insert update delete
	public static int exectuIUD(String sql,Object[] params){
		int count = 0;
		Connection conn = Basedao.getconn();
		
		//准备SQL语句
		PreparedStatement ps = null;
		
		//例如  insert into user('''''') values(?,?,?)
		try {
			//准备SQL
			ps = conn.prepareStatement(sql);
			
			for(int i=0; i<params.length; i++){
				ps.setObject(i+1, params[i]);
			}
			count = ps.executeUpdate();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			Basedao.closeall(null, ps, conn);
		}
		
		return count;
		
	}
	
	//关闭的方法
	public static void closeall(ResultSet rs,PreparedStatement ps,Connection conn){
		try {
			if (null!=rs) {
				rs.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			if (null!=ps) {
				ps.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			if (null!=conn) {
				conn.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
