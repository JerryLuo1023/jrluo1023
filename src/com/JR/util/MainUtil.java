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
		System.out.println("\t=================" + "��ӭ������Ʒ����ϵͳ(�û�����)" + "=================");
		System.out.println("\t=========================================================");
		System.out.println("\t|1.�û���½ϵͳ\t\t\t\t2.������û�\t|\n\t|3.ɾ���û�����\t\t\t\t4.�޸��û���Ϣ\t|\n\t|5.��ѯ�����û���Ϣ\t\t\t\t6.ȫ���û���Ϣ\t|\n\t|7.�˳�ϵͳ\t\t\t\t\t\t|");
		System.out.println("\t=========================================================");
		System.out.println("\t=========================================================");
		System.out.println();
		System.out.print("�����������Խ�����һ����");
		Scanner input = new Scanner(System.in);
		String n = input.next();
		switch (n) {
		case "1": {
			System.out.print("�������û�ID��");
			String name = input.next();
			System.out.print("���������룺");
			String password = input.next();
			if (JRUserDao.login(name, password)) {
				System.out.print("��ϲ��¼�ɹ�����");
				comenu();
			}
				
			else
				System.out.println("�����¼���û��������룡��");
			break;
		}
		case "2": {
			System.out.println("�����������û��ġ�ѧ�š����������������绰��������¼���롱����רҵ����");
			System.out.print("ѧ�ţ�");
			int id = input.nextInt();
			System.out.print("������");
			String name = input.next();
			System.out.print("�绰��");
			String phone = input.next();
			System.out.print("���룺");
			String password = input.next();
			System.out.print("רҵ��");
			String major = input.next();
			JRUserDao.insertUser(new User(id, name, phone, password, major));
			break;
		}
		case "3": {
			System.out.print("������������Ҫɾ����ѧ��ѧ�ţ�");
			int id = input.nextInt();
			JRUserDao.deleteUserById(id);
			break;

		}
		case "4": {
			System.out.println("������Ҫ�޸ĵ�ѧ����Ϣ��");
			System.out.print("ѧ�ţ�");
			int id = input.nextInt();
			System.out.print("������");
			String name = input.next();
			System.out.print("�绰��");
			String phone = input.next();
			System.out.print("���룺");
			String password = input.next();
			System.out.print("רҵ��");
			String major = input.next();
			JRUserDao.updateUser(new User(id, name, phone, password, major));
			break;
		}
		case "5": {
			System.out.println("��������Ҫ��ѯ��ѧ�ţ�");
			int user_id = input.nextInt();
			try {
				JRUserDao.getUserByID(user_id).show();
			} catch (NullPointerException e) {
				System.out.println("��ѯʧ�ܣ���������ѧ�ţ�����");
			}
			break;
		}
		case "6": {
			List<User> list = JRUserDao.getAllUsers();
			System.out.printf("%-24s%-17s%-23s%-20s%-20s\n","ѧ��","����","�ֻ���","����","רҵ");
			for (User u : list) {
				u.show();
			}
			usermenu();
			break;
		}
		case "7":{
			System.out.println("��лʹ�ã�");
			ConnectUtil.close();
			input.close();
			System.exit(0);
		}
		default:System.out.println("�������ѡ�����󣡣�����������ȷ��ѡ�����");
		}
	}


	public static void comenu() throws ClassNotFoundException {
		System.out.println();
		System.out.println();
		System.out.println("\t=========================================================");
		System.out.println("\t=================" + "��ӭ������Ʒ����ϵͳ(��Ʒ����)" + "=================");
		System.out.println("\t=========================================================");
		System.out.println("\t|1.�������Ʒ\t\t\t\t2.ɾ����Ʒ��Ϣ\t|\n\t|3.�޸���Ʒ��Ϣ\t\t\t\t4.��ѯ��Ʒ��Ϣ\t|\n\t|5.ȫ����Ʒ��Ϣ\t\t\t\t6.�ص���һҳ\t|\n\t|7.�˳�ϵͳ\t\t\t\t\t\t|");
		System.out.println("\t=========================================================");
		System.out.println("\t=========================================================");
		System.out.println();
		System.out.print("�����������Խ�����һ����");
		Scanner input = new Scanner(System.in);
		String n = input.next();
		switch (n) {
		case "1": {
			System.out.println("������������Ʒ�ġ���Ʒ��š�������Ʒ���������۸񡱣�����桱������Ʒ������������ע����");
			System.out.print("��Ʒ��ţ�");
			String ��Ʒ��� = input.next();
			System.out.print("��Ʒ����");
			String ��Ʒ�� = input.next();
			System.out.print("�۸�");
			float �۸� = input.nextFloat();
			System.out.print("��棺");
			int ��� = input.nextInt();
			System.out.print("��Ʒ������");
			String ��Ʒ���� = input.next();
			System.out.print("��ע��");
			String ��ע = input.next();
			JRCommodityDao.insertCommodity(new Commodity(��Ʒ���, ��Ʒ��, �۸�, ���, ��Ʒ����,��ע));
			comenu();
			break;
		}
		case "2": {
			System.out.print("������������Ҫɾ������Ʒ�ţ�");
			String id = input.next();
			JRCommodityDao.deleteCommodityById(id);
			comenu();
			break;
		}
		case "3": {
			System.out.println("������Ҫ�޸ĵ���Ʒ��ţ�");
			System.out.print("��Ʒ��ţ�");
			String ��Ʒ��� = input.next();
			System.out.println("������Ҫ�޸ĵ���Ʒ��Ϣ��");
			System.out.print("��Ʒ����");
			String ��Ʒ�� = input.next();
			System.out.print("�۸�");
			float �۸� = input.nextFloat();
			System.out.print("��棺");
			int ��� = input.nextInt();
			System.out.print("��Ʒ������");
			String ��Ʒ���� = input.next();
			System.out.print("��ע��");
			String ��ע = input.next();
			JRCommodityDao.updateCommodity(new Commodity(��Ʒ���, ��Ʒ��, �۸�, ���, ��Ʒ����,��ע));
			comenu();
			break;

		}
		case "4": {
			System.out.print("��������Ҫ��ѯ����Ʒ��ţ�");
			String id = input.next();
			try {
				System.out.printf("%-25s%-22s%-18s%-18s%-20s%s\n","��Ʒ���","����","�ۼ�","���","��Ʒ����","��ע");
				JRCommodityDao.getCommunityByID(id).show();
			} catch (NullPointerException e) {
				System.out.println("��ѯʧ�ܣ�����������Ʒ��ţ�����");
			}
			comenu();
			break;
		}
		case "5": {
			List<Commodity> list = JRCommodityDao.getAllCommodity();
			System.out.printf("%-25s%-22s%-18s%-18s%-20s%s\n","��Ʒ���","����","�ۼ�","���","��Ʒ����","��ע");
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
			System.out.println("��лʹ�ã�");
			ConnectUtil.close();
			input.close();
			System.exit(0);
		}
		default:System.out.println("�������ѡ�����󣡣�����������ȷ��ѡ�����");
		}
	}
}

