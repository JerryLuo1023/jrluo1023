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
			ConnectUtil.ps.setString(1, com.get商品编号());
			ConnectUtil.ps.setString(2, com.get商品名());
			ConnectUtil.ps.setFloat(3, com.get价格());
			ConnectUtil.ps.setInt(4, com.get库存());
			ConnectUtil.ps.setString(5, com.get商品描述());
			ConnectUtil.ps.setString(6, com.get备注());
			int row = ConnectUtil.ps.executeUpdate();
			if (row > 0) {
				ConnectUtil.con.commit();
				System.out.println("插入成功！！！");
				return true;
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			//e.printStackTrace();
			System.out.println("请检查商品信息是否正确！！");
		}
		return true;
	}

	// 删除商品
	public static boolean deleteCommodityById(String 商品编号) {
		try {
			ConnectUtil.con.setAutoCommit(false);
			ConnectUtil.ps = ConnectUtil.con.prepareStatement("delete from commodity where 商品编号=?");
			ConnectUtil.ps.setString(1, 商品编号);

			int row = ConnectUtil.ps.executeUpdate();
			if (row > 0) {
				ConnectUtil.con.commit();
				System.out.println("删除成功！！！");
				return true;
			}else {
				System.out.println("请检查商品编号是否存在或正确！！！");
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
		//	e.printStackTrace();
			System.out.println("请检查商品编号是否存在或正确！！！");
		}

		return true;
	}

	// 更新数据
	public static boolean updateCommodity(Commodity com) {
		try {
			ConnectUtil.con.setAutoCommit(false);
			ConnectUtil.ps = ConnectUtil.con
					.prepareStatement("update commodity set 商品编号=?,商品名=?,价格=?,库存=?,商品描述=?,备注=? where 商品编号=?");
			ConnectUtil.ps.setString(1, com.get商品编号());
			ConnectUtil.ps.setString(2,	com.get商品名());
			ConnectUtil.ps.setFloat(3,	com.get价格());
			ConnectUtil.ps.setInt(4, com.get库存());
			ConnectUtil.ps.setString(5, com.get商品描述());
			ConnectUtil.ps.setString(6, com.get备注());
			ConnectUtil.ps.setString(7, com.get商品编号());

			int row = ConnectUtil.ps.executeUpdate();
			if (row > 0) {
				ConnectUtil.con.commit();
				System.out.println("更新成功！！！");
				return true;
			}else {
				System.out.println("更新失败！！！请检查商品编号是否正确！！！");
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			//e.printStackTrace();
			System.out.println("更新失败！！！");
		}

		return true;
	}

	// 查询一个商品
	public static Commodity getCommunityByID(String 商品编号) {
		Commodity com = null;
		ConnectUtil.con = ConnectUtil.getConnection();
		try {
			ConnectUtil.ps = ConnectUtil.con.prepareStatement("select * from commodity where 商品编号=?");
			ConnectUtil.ps.setString(1, 商品编号);
			ConnectUtil.rs = ConnectUtil.ps.executeQuery();
			if (ConnectUtil.rs.next()) {
				// 如果查询到则
				com = new Commodity();// 先创建对象
				com.set商品编号(ConnectUtil.rs.getString("商品编号"));
				com.set商品名(ConnectUtil.rs.getString("商品名"));
				com.set价格(ConnectUtil.rs.getFloat("价格"));
				com.set库存(ConnectUtil.rs.getInt("库存"));
				com.set商品描述(ConnectUtil.rs.getString("商品描述"));
				com.set备注(ConnectUtil.rs.getString("备注"));
			}else 
				System.out.println("未查询到商品信息！！请检查商品编号是否正确！！");
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			System.out.println("未查询到商品信息！！");
		}

		return com;
	}

	// 查询所有商品
	public static List<Commodity> getAllCommodity() {
		List<Commodity> comlist = null;
		ConnectUtil.con = ConnectUtil.getConnection();
		comlist = new ArrayList<Commodity>();
		try {
			ConnectUtil.ps = ConnectUtil.con.prepareStatement("select * from commodity");
			ConnectUtil.rs = ConnectUtil.ps.executeQuery();
			while (ConnectUtil.rs.next()) {
				Commodity com = new Commodity();
				com.set商品编号(ConnectUtil.rs.getString("商品编号"));
				com.set商品名(ConnectUtil.rs.getString("商品名"));
				com.set价格(ConnectUtil.rs.getFloat("价格"));
				com.set库存(ConnectUtil.rs.getInt("库存"));
				com.set商品描述(ConnectUtil.rs.getString("商品描述"));
				com.set备注(ConnectUtil.rs.getString("备注"));
				comlist.add(com);
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}

		return comlist;
	}
}
