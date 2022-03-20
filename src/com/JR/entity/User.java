package com.JR.entity;

public class User {
	//1.属性私有
	//2.方法公有
	//3.必须存在一个无参构造方法
	private int user_id;
	private String user_name;
	private String phone;
	private String password;
	private String major;
	public User(int user_id,String user_name,String phone,String password,String major){
		this.user_id = user_id;
		this.user_name = user_name;
		this.phone = phone;
		this.password = password;
		this.major = major;
	}
	public User(){}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}

	public void show() {
		System.out.println(user_id+"\t\t"+user_name+"\t\t"+phone+"\t\t"+password+"\t\t"+major);
	}
	
}
