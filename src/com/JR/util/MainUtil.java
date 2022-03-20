package com.JR.util;

import java.util.List;
import java.util.Scanner;

import com.JR.dao.JRCommodityDao;
import com.JR.dao.JRUserDao;
import com.JR.entity.Commodity;
import com.JR.entity.User;

class MainUtil {
	static boolean b = true;

	public static void main(String[] args) throws ClassNotFoundException {
		ConnectUtil.getConnection();
		usermenu();
		while (b) {
			usermenu();
		}

	}

	public static void usermenu() throws ClassNotFoundException {
		System.out.println();
		System.out.println("\t=========================================================");
		System.out.println("\t=================" + "欢迎来到商品管理系统(用户管理)" + "=================");
		System.out.println("\t=========================================================");
		System.out.println("\t|1.用户登陆系统\t\t\t\t2.添加新用户\t|\n\t|3.删除用户数据\t\t\t\t4.修改用户信息\t|\n\t|5.查询个人用户信息\t\t\t\t6.全部用户信息\t|\n\t|7.退出系统\t\t\t\t\t\t|");
		System.out.println("\t=========================================================");
		System.out.println("\t=========================================================");
		System.out.println();
		System.out.print("请输入数字以进行下一步：");
		Scanner input = new Scanner(System.in);
		String n = input.next();
		switch (n) {
		case "1": {
			System.out.print("请输入用户ID：");
			String name = input.next();
			System.out.print("请输入密码：");
			String password = input.next();
			if (JRUserDao.login(name, password)) {
				System.out.print("恭喜登录成功！！");
				comenu();
			}
				
			else
				System.out.println("请重新检查用户名或密码！！");
			break;
		}
		case "2": {
			System.out.println("请依次输入用户的“学号”，“姓名”，“电话”，“登录密码”，“专业”：");
			System.out.print("学号：");
			int id = input.nextInt();
			System.out.print("姓名：");
			String name = input.next();
			System.out.print("电话：");
			String phone = input.next();
			System.out.print("密码：");
			String password = input.next();
			System.out.print("专业：");
			String major = input.next();
			JRUserDao.insertUser(new User(id, name, phone, password, major));
			break;
		}
		case "3": {
			System.out.print("请输入如你你要删除的学生学号：");
			int id = input.nextInt();
			JRUserDao.deleteUserById(id);
			break;

		}
		case "4": {
			System.out.println("请输入要修改的学生信息：");
			System.out.print("学号：");
			int id = input.nextInt();
			System.out.print("姓名：");
			String name = input.next();
			System.out.print("电话：");
			String phone = input.next();
			System.out.print("密码：");
			String password = input.next();
			System.out.print("专业：");
			String major = input.next();
			JRUserDao.updateUser(new User(id, name, phone, password, major));
			break;
		}
		case "5": {
			System.out.println("请输入如要查询的学号：");
			int user_id = input.nextInt();
			try {
				JRUserDao.getUserByID(user_id).show();
			} catch (NullPointerException e) {
				System.out.println("查询失败！！！请检查学号！！！");
			}
			break;
		}
		case "6": {
			List<User> list = JRUserDao.getAllUsers();
			System.out.printf("%-24s%-17s%-23s%-20s%-20s\n","学号","姓名","手机号","密码","专业");
			for (User u : list) {
				u.show();
			}
			usermenu();
			break;
		}
		case "7":{
			System.out.println("感谢使用！");
			ConnectUtil.close();
			input.close();
			System.exit(0);
		}
		default:System.out.println("您输入的选项有误！！！请输入正确的选项！！！");
		}
	}


	public static void comenu() throws ClassNotFoundException {
		System.out.println();
		System.out.println();
		System.out.println("\t=========================================================");
		System.out.println("\t=================" + "欢迎来到商品管理系统(商品管理)" + "=================");
		System.out.println("\t=========================================================");
		System.out.println("\t|1.添加新商品\t\t\t\t2.删除商品信息\t|\n\t|3.修改商品信息\t\t\t\t4.查询商品信息\t|\n\t|5.全部商品信息\t\t\t\t6.回到上一页\t|\n\t|7.退出系统\t\t\t\t\t\t|");
		System.out.println("\t=========================================================");
		System.out.println("\t=========================================================");
		System.out.println();
		System.out.print("请输入数字以进行下一步：");
		Scanner input = new Scanner(System.in);
		String n = input.next();
		switch (n) {
		case "1": {
			System.out.println("请依次输入商品的“商品编号”，“商品名”，“价格”，“库存”，“商品描述”，“备注”：");
			System.out.print("商品编号：");
			String 商品编号 = input.next();
			System.out.print("商品名：");
			String 商品名 = input.next();
			System.out.print("价格：");
			float 价格 = input.nextFloat();
			System.out.print("库存：");
			int 库存 = input.nextInt();
			System.out.print("商品描述：");
			String 商品描述 = input.next();
			System.out.print("备注：");
			String 备注 = input.next();
			JRCommodityDao.insertCommodity(new Commodity(商品编号, 商品名, 价格, 库存, 商品描述,备注));
			comenu();
			break;
		}
		case "2": {
			System.out.print("请输入如你你要删除的商品号：");
			String id = input.next();
			JRCommodityDao.deleteCommodityById(id);
			comenu();
			break;
		}
		case "3": {
			System.out.println("请输入要修改的商品编号：");
			System.out.print("商品编号：");
			String 商品编号 = input.next();
			System.out.println("请输入要修改的商品信息：");
			System.out.print("商品名：");
			String 商品名 = input.next();
			System.out.print("价格：");
			float 价格 = input.nextFloat();
			System.out.print("库存：");
			int 库存 = input.nextInt();
			System.out.print("商品描述：");
			String 商品描述 = input.next();
			System.out.print("备注：");
			String 备注 = input.next();
			JRCommodityDao.updateCommodity(new Commodity(商品编号, 商品名, 价格, 库存, 商品描述,备注));
			comenu();
			break;

		}
		case "4": {
			System.out.print("请输入如要查询的商品编号：");
			String id = input.next();
			try {
				System.out.printf("%-25s%-22s%-18s%-18s%-20s%s\n","商品编号","书名","售价","库存","商品描述","备注");
				JRCommodityDao.getCommunityByID(id).show();
			} catch (NullPointerException e) {
				System.out.println("查询失败！！！请检查商品编号！！！");
			}
			comenu();
			break;
		}
		case "5": {
			List<Commodity> list = JRCommodityDao.getAllCommodity();
			System.out.printf("%-25s%-22s%-18s%-18s%-20s%s\n","商品编号","书名","售价","库存","商品描述","备注");
			for (Commodity u : list) {
				u.show();
			}
			comenu();
			break;
		}
		case "6": {
			usermenu();
		}
		case "7":{
			System.out.println("感谢使用！");
			ConnectUtil.close();
			input.close();
			System.exit(0);
		}
		default:System.out.println("您输入的选项有误！！！请输入正确的选项！！！");
		}
	}
}

