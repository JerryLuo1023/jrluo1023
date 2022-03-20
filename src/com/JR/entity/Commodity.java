package com.JR.entity;

public class Commodity {
	private String 商品编号;
	private String 商品名;
	private float 价格;
	private int 库存;
	private String 商品描述;
	private String 备注;
	public Commodity() {}
	public Commodity(String 商品编号, String 商品名, float 价格, int 库存, String 商品描述, String 备注) {
		this.商品编号 = 商品编号;
		this.商品名 = 商品名;
		this.价格 = 价格;
		this.库存 = 库存;
		this.商品描述 = 商品描述;
		this.备注 = 备注;
	}
	public String get商品编号() {
		return 商品编号;
	}
	public void set商品编号(String 商品编号) {
		this.商品编号 = 商品编号;
	}
	public String get商品名() {
		return 商品名;
	}
	public void set商品名(String 商品名) {
		this.商品名 = 商品名;
	}
	public float get价格() {
		return 价格;
	}
	public void set价格(float 价格) {
		this.价格 = 价格;
	}
	public int get库存() {
		return 库存;
	}
	public void set库存(int 库存) {
		this.库存 = 库存;
	}
	public String get商品描述() {
		return 商品描述;
	}
	public void set商品描述(String 商品描述) {
		this.商品描述 = 商品描述;
	}
	public String get备注() {
		return 备注;
	}
	public void set备注(String 备注) {
		this.备注 = 备注;
	}
	public void show() {
		System.out.printf("%-20s%-10s\t\t%-20.2f%-20d%-20s%-20s\n",商品编号,商品名,价格,库存,商品描述,备注);
	}
	
}
