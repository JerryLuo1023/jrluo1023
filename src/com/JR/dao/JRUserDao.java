package com.JR.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.JR.entity.User;
import com.JR.util.ConnectUtil;

public class JRUserDao {
	// �û���¼
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
				System.out.println("���޴��ˣ�����");
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}

	// ��������
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
				System.out.println("����ɹ�������");
			}
			else {
				System.out.println("����ʧ�ܣ����������û���Ϣ�Ƿ�������");
			}
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			
//			e.printStackTrace();
			System.out.println("����ʧ�ܣ����������û���Ϣ�Ƿ�����������");
			System.exit(0);
		}
	}

	// ɾ���û�
	public static  void deleteUserById(int user_id) {
		try {
			ConnectUtil.con.setAutoCommit(false);
			ConnectUtil.ps = ConnectUtil.con.prepareStatement("delete from user where user_id=?");
			ConnectUtil.ps.setInt(1, user_id);

			int row = ConnectUtil.ps.executeUpdate();
			if (row > 0) {
				ConnectUtil.con.commit();
				System.out.println("ɾ���ɹ�������");

			}
			else 
				System.out.println("ɾ��ʧ�ܣ���������ѧ�ţ�����");
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			//e.printStackTrace();
			System.out.println("ɾ��ʧ�ܣ���������ѧ�ţ�����!!!!");
		}


	}

	// ��������
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
				System.out.println("���³ɹ�������");
				return true;
			}
			else
				System.out.println("����ʧ�ܣ����������û���ѧ�ţ�����");
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
			
		}

		return true;
	}

	// ��ѯһ���û�
	public static User getUserByID(int user_id) {
		User user = null;
		ConnectUtil.con = ConnectUtil.getConnection();
		try {
			ConnectUtil.ps = ConnectUtil.con.prepareStatement("select * from user where user_id=?");
			ConnectUtil.ps.setInt(1, user_id);
			ConnectUtil.rs = ConnectUtil.ps.executeQuery();
			if (ConnectUtil.rs.next()) {
				// �����ѯ����
				user = new User();// �ȴ�������
				user.setUser_id(ConnectUtil.rs.getInt("user_id"));
				user.setUser_name(ConnectUtil.rs.getString("user_name"));
				user.setPhone(ConnectUtil.rs.getString("phone"));
				user.setPassword(ConnectUtil.rs.getString("password"));
				user.setMajor(ConnectUtil.rs.getString("major"));
			}
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			//e.printStackTrace();
			System.out.println("��ѯʧ�ܣ���������ѧ�ţ�����");
		}

		return user;
	}

	// ��ѯ�����û�
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
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}

		return userlist;
	}

}
