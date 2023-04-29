package com.web_animal.entity;

public class web_animal_keepsake {
	private int keepsake_id;
	private String keepsake_name;
	private String keepsake_photo;
	private double keepsake_price;
	private int keepsake_point;
	private String keepsake_introduce;
	private int keepsake_stock;
	
	
	public web_animal_keepsake() {
		super();
	}


	@Override
	public String toString() {
		return "web_animal_keepsake [keepsake_id=" + keepsake_id + ", keepsake_name=" + keepsake_name
				+ ", keepsake_photo=" + keepsake_photo + ", keepsake_price=" + keepsake_price + ", keepsake_point="
				+ keepsake_point + ", keepsake_introduce=" + keepsake_introduce + ", keepsake_stock=" + keepsake_stock
				+ "]";
	}


	public web_animal_keepsake(int keepsake_id, String keepsake_name, String keepsake_photo, double keepsake_price,
			int keepsake_point, String keepsake_introduce, int keepsake_stock) {
		super();
		this.keepsake_id = keepsake_id;
		this.keepsake_name = keepsake_name;
		this.keepsake_photo = keepsake_photo;
		this.keepsake_price = keepsake_price;
		this.keepsake_point = keepsake_point;
		this.keepsake_introduce = keepsake_introduce;
		this.keepsake_stock = keepsake_stock;
	}


	public int getKeepsake_id() {
		return keepsake_id;
	}


	public void setKeepsake_id(int keepsake_id) {
		this.keepsake_id = keepsake_id;
	}


	public String getKeepsake_name() {
		return keepsake_name;
	}


	public void setKeepsake_name(String keepsake_name) {
		this.keepsake_name = keepsake_name;
	}


	public String getKeepsake_photo() {
		return keepsake_photo;
	}


	public void setKeepsake_photo(String keepsake_photo) {
		this.keepsake_photo = keepsake_photo;
	}


	public double getKeepsake_price() {
		return keepsake_price;
	}


	public void setKeepsake_price(double keepsake_price) {
		this.keepsake_price = keepsake_price;
	}


	public int getKeepsake_point() {
		return keepsake_point;
	}


	public void setKeepsake_point(int keepsake_point) {
		this.keepsake_point = keepsake_point;
	}


	public String getKeepsake_introduce() {
		return keepsake_introduce;
	}


	public void setKeepsake_introduce(String keepsake_introduce) {
		this.keepsake_introduce = keepsake_introduce;
	}


	public int getKeepsake_stock() {
		return keepsake_stock;
	}


	public void setKeepsake_stock(int keepsake_stock) {
		this.keepsake_stock = keepsake_stock;
	}
	
	
	
}
