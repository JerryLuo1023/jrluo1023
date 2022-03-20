package com.JR.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.JR.entity.Commodity;
import com.JR.util.ConnectUtil;

public class JRCommodityDao {
	public static boolean insertCommodity(Commodity com) {
		try {
			ConnectUtil.con.setAutoCommit(false);
			ConnectUtil.ps = ConnectUtil.con.prepareStatement("insert into commodity values(?,?,?,?,?,?)");
			ConnectUtil.ps.setString(1, com.get��Ʒ���());
			ConnectUtil.ps.setString(2, com.get��Ʒ��());
			ConnectUtil.ps.setFloat(3, com.get�۸�());
			ConnectUtil.ps.setInt(4, com.get���());
			ConnectUtil.ps.setString(5, com.get��Ʒ����());
			ConnectUtil.ps.setString(6, com.get��ע());
			int row = ConnectUtil.ps.executeUpdate();
			if (row > 0) {
				ConnectUtil.con.commit();
				System.out.println("����ɹ�������");
				return true;
			}
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			//e.printStackTrace();
			System.out.println("������Ʒ��Ϣ�Ƿ���ȷ����");
		}
		return true;
	}

	// ɾ����Ʒ
	public static boolean deleteCommodityById(String ��Ʒ���) {
		try {
			ConnectUtil.con.setAutoCommit(false);
			ConnectUtil.ps = ConnectUtil.con.prepareStatement("delete from commodity where ��Ʒ���=?");
			ConnectUtil.ps.setString(1, ��Ʒ���);

			int row = ConnectUtil.ps.executeUpdate();
			if (row > 0) {
				ConnectUtil.con.commit();
				System.out.println("ɾ���ɹ�������");
				return true;
			}else {
				System.out.println("������Ʒ����Ƿ���ڻ���ȷ������");
			}
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
		//	e.printStackTrace();
			System.out.println("������Ʒ����Ƿ���ڻ���ȷ������");
		}

		return true;
	}

	// ��������
	public static boolean updateCommodity(Commodity com) {
		try {
			ConnectUtil.con.setAutoCommit(false);
			ConnectUtil.ps = ConnectUtil.con
					.prepareStatement("update commodity set ��Ʒ���=?,��Ʒ��=?,�۸�=?,���=?,��Ʒ����=?,��ע=? where ��Ʒ���=?");
			ConnectUtil.ps.setString(1, com.get��Ʒ���());
			ConnectUtil.ps.setString(2,	com.get��Ʒ��());
			ConnectUtil.ps.setFloat(3,	com.get�۸�());
			ConnectUtil.ps.setInt(4, com.get���());
			ConnectUtil.ps.setString(5, com.get��Ʒ����());
			ConnectUtil.ps.setString(6, com.get��ע());
			ConnectUtil.ps.setString(7, com.get��Ʒ���());

			int row = ConnectUtil.ps.executeUpdate();
			if (row > 0) {
				ConnectUtil.con.commit();
				System.out.println("���³ɹ�������");
				return true;
			}else {
				System.out.println("����ʧ�ܣ�����������Ʒ����Ƿ���ȷ������");
			}
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			//e.printStackTrace();
			System.out.println("����ʧ�ܣ�����");
		}

		return true;
	}

	// ��ѯһ����Ʒ
	public static Commodity getCommunityByID(String ��Ʒ���) {
		Commodity com = null;
		ConnectUtil.con = ConnectUtil.getConnection();
		try {
			ConnectUtil.ps = ConnectUtil.con.prepareStatement("select * from commodity where ��Ʒ���=?");
			ConnectUtil.ps.setString(1, ��Ʒ���);
			ConnectUtil.rs = ConnectUtil.ps.executeQuery();
			if (ConnectUtil.rs.next()) {
				// �����ѯ����
				com = new Commodity();// �ȴ�������
				com.set��Ʒ���(ConnectUtil.rs.getString("��Ʒ���"));
				com.set��Ʒ��(ConnectUtil.rs.getString("��Ʒ��"));
				com.set�۸�(ConnectUtil.rs.getFloat("�۸�"));
				com.set���(ConnectUtil.rs.getInt("���"));
				com.set��Ʒ����(ConnectUtil.rs.getString("��Ʒ����"));
				com.set��ע(ConnectUtil.rs.getString("��ע"));
			}else 
				System.out.println("δ��ѯ����Ʒ��Ϣ����������Ʒ����Ƿ���ȷ����");
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
			System.out.println("δ��ѯ����Ʒ��Ϣ����");
		}

		return com;
	}

	// ��ѯ������Ʒ
	public static List<Commodity> getAllCommodity() {
		List<Commodity> comlist = null;
		ConnectUtil.con = ConnectUtil.getConnection();
		comlist = new ArrayList<Commodity>();
		try {
			ConnectUtil.ps = ConnectUtil.con.prepareStatement("select * from commodity");
			ConnectUtil.rs = ConnectUtil.ps.executeQuery();
			while (ConnectUtil.rs.next()) {
				Commodity com = new Commodity();
				com.set��Ʒ���(ConnectUtil.rs.getString("��Ʒ���"));
				com.set��Ʒ��(ConnectUtil.rs.getString("��Ʒ��"));
				com.set�۸�(ConnectUtil.rs.getFloat("�۸�"));
				com.set���(ConnectUtil.rs.getInt("���"));
				com.set��Ʒ����(ConnectUtil.rs.getString("��Ʒ����"));
				com.set��ע(ConnectUtil.rs.getString("��ע"));
				comlist.add(com);
			}
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}

		return comlist;
	}
}
