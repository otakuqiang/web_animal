package com.web_animal.entity;

public class web_animal_cart {
	private int cart_id;
	private String cart_k_name;
	private String cart_k_photo;
	private double cart_k_price;
	private int cart_k_point;
	private int cart_quantity;
	private int cart_k_stock;
	private int cart_k_id;
	private String cart_u_id;
	private int cart_valid;
	

	public web_animal_cart() {
		super();
	}
	
	public web_animal_cart(int cart_id, String cart_k_name, String cart_k_photo, double cart_k_price,
			int cart_k_point, int cart_quantity, int cart_k_stock, int cart_k_id, String cart_u_id, int cart_valid) {
		super();
		this.cart_id = cart_id;
		this.cart_k_name = cart_k_name;
		this.cart_k_photo = cart_k_photo;
		this.cart_k_price = cart_k_price;
		this.cart_k_point = cart_k_point;
		this.cart_quantity = cart_quantity;
		this.cart_k_stock = cart_k_stock;
		this.cart_k_id = cart_k_id;
		this.cart_u_id = cart_u_id;
		this.cart_valid = cart_valid;
	}

	public int getCart_k_point() {
		return cart_k_point;
	}

	public void setCart_k_point(int cart_k_point) {
		this.cart_k_point = cart_k_point;
	}

	public int getCart_id() {
		return cart_id;
	}
	public void setCart_id(int cart_id) {
		this.cart_id = cart_id;
	}
	public String getCart_k_name() {
		return cart_k_name;
	}
	public void setCart_k_name(String cart_k_name) {
		this.cart_k_name = cart_k_name;
	}
	public String getCart_k_photo() {
		return cart_k_photo;
	}
	public void setCart_k_photo(String cart_k_photo) {
		this.cart_k_photo = cart_k_photo;
	}
	public double getCart_k_price() {
		return cart_k_price;
	}
	public void setCart_k_price(double cart_k_price) {
		this.cart_k_price = cart_k_price;
	}
	public int getCart_quantity() {
		return cart_quantity;
	}
	public void setCart_quantity(int cart_quantity) {
		this.cart_quantity = cart_quantity;
	}
	public int getCart_k_stock() {
		return cart_k_stock;
	}
	public void setCart_k_stock(int cart_k_stock) {
		this.cart_k_stock = cart_k_stock;
	}
	public int getCart_k_id() {
		return cart_k_id;
	}
	public void setCart_k_id(int cart_k_id) {
		this.cart_k_id = cart_k_id;
	}
	public String getCart_u_id() {
		return cart_u_id;
	}
	public void setCart_u_id(String cart_u_id) {
		this.cart_u_id = cart_u_id;
	}
	public int getCart_valid() {
		return cart_valid;
	}
	public void setCart_valid(int cart_valid) {
		this.cart_valid = cart_valid;
	}

	
}
