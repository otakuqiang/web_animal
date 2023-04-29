package com.web_animal.entity;

public class web_animal_order {
	
	private int	order_id;
	private String	order_u_id;
	private int	order_k_id;
	private String	order_u_name;
	private String order_k_photo;
	private String	order_u_address;
	private double order_money;
	private int order_point;
	private int order_quantity;
	private String	order_method;
	private String order_status;
	
	
	@Override
	public String toString() {
		return "web_animal_order [order_id=" + order_id + ", order_u_id=" + order_u_id + ", order_k_id=" + order_k_id
				+ ", order_u_name=" + order_u_name + ", order_k_photo=" + order_k_photo + ", order_u_address="
				+ order_u_address + ", order_money=" + order_money + ", order_point=" + order_point
				+ ", order_quantity=" + order_quantity + ", order_method=" + order_method + ", order_status="
				+ order_status + "]";
	}
	public web_animal_order(int order_id, String order_u_id, int order_k_id, String order_u_name, String order_k_photo,
			String order_u_address, double order_money, int order_point, int order_quantity, String order_method,
			String order_status) {
		super();
		this.order_id = order_id;
		this.order_u_id = order_u_id;
		this.order_k_id = order_k_id;
		this.order_u_name = order_u_name;
		this.order_k_photo = order_k_photo;
		this.order_u_address = order_u_address;
		this.order_money = order_money;
		this.order_point = order_point;
		this.order_quantity = order_quantity;
		this.order_method = order_method;
		this.order_status = order_status;
	}
	public int getOrder_quantity() {
		return order_quantity;
	}
	public void setOrder_quantity(int order_quantity) {
		this.order_quantity = order_quantity;
	}
	public web_animal_order() {
		super();
	}
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public String getOrder_u_id() {
		return order_u_id;
	}
	public void setOrder_u_id(String order_u_id) {
		this.order_u_id = order_u_id;
	}
	public int getOrder_k_id() {
		return order_k_id;
	}
	public void setOrder_k_id(int order_k_id) {
		this.order_k_id = order_k_id;
	}
	public String getOrder_u_name() {
		return order_u_name;
	}
	public void setOrder_u_name(String order_u_name) {
		this.order_u_name = order_u_name;
	}
	public String getOrder_k_photo() {
		return order_k_photo;
	}
	public void setOrder_k_photo(String order_k_photo) {
		this.order_k_photo = order_k_photo;
	}
	public String getOrder_u_address() {
		return order_u_address;
	}
	public void setOrder_u_address(String order_u_address) {
		this.order_u_address = order_u_address;
	}
	public double getOrder_money() {
		return order_money;
	}
	public void setOrder_money(double order_money) {
		this.order_money = order_money;
	}
	public int getOrder_point() {
		return order_point;
	}
	public void setOrder_point(int order_point) {
		this.order_point = order_point;
	}
	public String getOrder_method() {
		return order_method;
	}
	public void setOrder_method(String order_method) {
		this.order_method = order_method;
	}
	public String getOrder_status() {
		return order_status;
	}
	public void setOrder_status(String order_status) {
		this.order_status = order_status;
	}
	
	
}
