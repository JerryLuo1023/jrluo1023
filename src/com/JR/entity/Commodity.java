package com.JR.entity;

public class Commodity {
	private String ��Ʒ���;
	private String ��Ʒ��;
	private float �۸�;
	private int ���;
	private String ��Ʒ����;
	private String ��ע;
	public Commodity() {}
	public Commodity(String ��Ʒ���, String ��Ʒ��, float �۸�, int ���, String ��Ʒ����, String ��ע) {
		this.��Ʒ��� = ��Ʒ���;
		this.��Ʒ�� = ��Ʒ��;
		this.�۸� = �۸�;
		this.��� = ���;
		this.��Ʒ���� = ��Ʒ����;
		this.��ע = ��ע;
	}
	public String get��Ʒ���() {
		return ��Ʒ���;
	}
	public void set��Ʒ���(String ��Ʒ���) {
		this.��Ʒ��� = ��Ʒ���;
	}
	public String get��Ʒ��() {
		return ��Ʒ��;
	}
	public void set��Ʒ��(String ��Ʒ��) {
		this.��Ʒ�� = ��Ʒ��;
	}
	public float get�۸�() {
		return �۸�;
	}
	public void set�۸�(float �۸�) {
		this.�۸� = �۸�;
	}
	public int get���() {
		return ���;
	}
	public void set���(int ���) {
		this.��� = ���;
	}
	public String get��Ʒ����() {
		return ��Ʒ����;
	}
	public void set��Ʒ����(String ��Ʒ����) {
		this.��Ʒ���� = ��Ʒ����;
	}
	public String get��ע() {
		return ��ע;
	}
	public void set��ע(String ��ע) {
		this.��ע = ��ע;
	}
	public void show() {
		System.out.printf("%-20s%-10s\t\t%-20.2f%-20d%-20s%-20s\n",��Ʒ���,��Ʒ��,�۸�,���,��Ʒ����,��ע);
	}
	
}
