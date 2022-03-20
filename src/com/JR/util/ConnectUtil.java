package com.JR.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectUtil {
	public static Connection con = null;
	public static Statement stm = null;
	public static ResultSet rs = null;
	public static PreparedStatement ps;

	public static void close() {
		if (rs != null)
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		if (ps != null)
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		if (con != null)
			try {
				con.close();
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		if (stm != null)
			try {
				stm.close();
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
	}

	// 连接数据库
	public static Connection getConnection() {
		// TODO 自动生成的方法存根
		try {
			// 1. 加载JDBC-MySQL驱动
			Class.forName("com.mysql.cj.jdbc.Driver");
			// 2. 连接数据库
			String url = "jdbc:mysql://localhost:3306/jrluo?useSSL=false & serverTimezone=UTC & characterEncoding=utf-8";
			String username = "root";
			String password = "123456";
			con = DriverManager.getConnection(url, username, password);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}

	public static void showStudent() {
		// 3.获取连接状态
		try {
			stm = con.createStatement();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		// 4.执行查询的SQL语句
		try {
			rs = stm.executeQuery("select * from user");
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}

		try {
			while (rs.next()) {
				// System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3));
				System.out.println(rs.getInt("user_id") + "\t" + rs.getString("user_name") + "\t"
						+ rs.getString("phone") + "\t" + rs.getString("password") + "\t" + rs.getString("major"));
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
}
