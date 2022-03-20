package com.JR.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.JR.entity.User;
import com.JR.util.ConnectUtil;

public class JRUserDao {
	// 用户登录
	public static boolean login(String name, String password) throws ClassNotFoundException {

		// System.out.println("select user_password from user where
		// dept_id='"+name+"'");
		try {
			ConnectUtil.stm = ConnectUtil.con.createStatement();
			ConnectUtil.rs = ConnectUtil.stm.executeQuery("select password from user where user_id='" + name + "'");
			if (ConnectUtil.rs.next()) {
				if (ConnectUtil.rs.getString("password").equals(password)) {
					return true;
				} else {
					return false;
				}
			} else {
				System.out.println("查无此人！！！");
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}

	// 插入数据
	public static void insertUser(User user) {
		try {
			ConnectUtil.con.setAutoCommit(false);
			ConnectUtil.ps = ConnectUtil.con.prepareStatement("insert into user values(?,?,?,?,?)");
			ConnectUtil.ps.setInt(1, user.getUser_id());
			ConnectUtil.ps.setString(2, user.getUser_name());
			ConnectUtil.ps.setString(3, user.getPhone());
			ConnectUtil.ps.setString(4, user.getPassword());
			ConnectUtil.ps.setString(5, user.getMajor());
			int row = ConnectUtil.ps.executeUpdate();
			if (row > 0) {
				ConnectUtil.con.commit();
				System.out.println("插入成功！！！");
			}
			else {
				System.out.println("插入失败！！！请检查用户信息是否完整！");
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			
//			e.printStackTrace();
			System.out.println("插入失败！！！请检查用户信息是否完整！！！");
			System.exit(0);
		}
	}

	// 删除用户
	public static  void deleteUserById(int user_id) {
		try {
			ConnectUtil.con.setAutoCommit(false);
			ConnectUtil.ps = ConnectUtil.con.prepareStatement("delete from user where user_id=?");
			ConnectUtil.ps.setInt(1, user_id);

			int row = ConnectUtil.ps.executeUpdate();
			if (row > 0) {
				ConnectUtil.con.commit();
				System.out.println("删除成功！！！");

			}
			else 
				System.out.println("删除失败！！！请检查学号！！！");
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			//e.printStackTrace();
			System.out.println("删除失败！！！请检查学号！！！!!!!");
		}


	}

	// 更新数据
	public static boolean updateUser(User user) {
		try {
			ConnectUtil.con.setAutoCommit(false);
			ConnectUtil.ps = ConnectUtil.con.prepareStatement("update user set user_name=?,phone=?,password=?,major=? where user_id=?");
			ConnectUtil.ps.setString(1, user.getUser_name());
			ConnectUtil.ps.setString(2, user.getPhone());
			ConnectUtil.ps.setString(3, user.getPassword());
			ConnectUtil.ps.setString(4, user.getMajor());
			ConnectUtil.ps.setInt(5, user.getUser_id());

			int row = ConnectUtil.ps.executeUpdate();
			if (row > 0) {
				ConnectUtil.con.commit();
				System.out.println("更新成功！！！");
				return true;
			}
			else
				System.out.println("更新失败！！！请检查用户的学号！！！");
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			
		}

		return true;
	}

	// 查询一个用户
	public static User getUserByID(int user_id) {
		User user = null;
		ConnectUtil.con = ConnectUtil.getConnection();
		try {
			ConnectUtil.ps = ConnectUtil.con.prepareStatement("select * from user where user_id=?");
			ConnectUtil.ps.setInt(1, user_id);
			ConnectUtil.rs = ConnectUtil.ps.executeQuery();
			if (ConnectUtil.rs.next()) {
				// 如果查询到则
				user = new User();// 先创建对象
				user.setUser_id(ConnectUtil.rs.getInt("user_id"));
				user.setUser_name(ConnectUtil.rs.getString("user_name"));
				user.setPhone(ConnectUtil.rs.getString("phone"));
				user.setPassword(ConnectUtil.rs.getString("password"));
				user.setMajor(ConnectUtil.rs.getString("major"));
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			//e.printStackTrace();
			System.out.println("查询失败！！！请检查学号！！！");
		}

		return user;
	}

	// 查询所有用户
	public static List<User> getAllUsers() {
		List<User> userlist = null;
		ConnectUtil.con = ConnectUtil.getConnection();
		userlist = new ArrayList<User>();
		try {
			ConnectUtil.ps = ConnectUtil.con.prepareStatement("select * from user");
			ConnectUtil.rs = ConnectUtil.ps.executeQuery();
			while (ConnectUtil.rs.next()) {
				User user = new User();
				user.setUser_id(ConnectUtil.rs.getInt("user_id"));
				user.setUser_name(ConnectUtil.rs.getString("user_name"));
				user.setPhone(ConnectUtil.rs.getString("phone"));
				user.setPassword(ConnectUtil.rs.getString("password"));
				user.setMajor(ConnectUtil.rs.getString("major"));
				userlist.add(user);
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}

		return userlist;
	}

}
