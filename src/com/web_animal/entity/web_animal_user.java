package com.web_animal.entity;

public class web_animal_user {
	

	private	String  user_id;
	private	String	user_name;
	private	String	user_password;
	private	String	user_sex;
	private	double	user_money;
	private int user_point;
	private	String	user_mobile;
	private	String	user_address;
	private	String	user_status;
	
	
	@Override
	public String toString() {
		return "web_animal_user [user_id=" + user_id + ", user_name=" + user_name + ", user_password=" + user_password
				+ ", user_sex=" + user_sex + ", user_money=" + user_money + ", user_point=" + user_point
				+ ", user_mobile=" + user_mobile + ", user_address=" + user_address + ", user_status=" + user_status
				+ "]";
	}
	public web_animal_user() {
		super();
	}
	public web_animal_user(String user_id, String user_name, String user_password, String user_sex, double user_money,
			int user_point, String user_mobile, String user_address, String user_status) {
		super();
		this.user_id = user_id;
		this.user_name = user_name;
		this.user_password = user_password;
		this.user_sex = user_sex;
		this.user_money = user_money;
		this.user_point = user_point;
		this.user_mobile = user_mobile;
		this.user_address = user_address;
		this.user_status = user_status;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_password() {
		return user_password;
	}
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}
	public String getUser_sex() {
		return user_sex;
	}
	public void setUser_sex(String user_sex) {
		this.user_sex = user_sex;
	}
	public double getUser_money() {
		return user_money;
	}
	public void setUser_money(double user_money) {
		this.user_money = user_money;
	}
	public int getUser_point() {
		return user_point;
	}
	public void setUser_point(int user_point) {
		this.user_point = user_point;
	}
	public String getUser_mobile() {
		return user_mobile;
	}
	public void setUser_mobile(String user_mobile) {
		this.user_mobile = user_mobile;
	}
	public String getUser_address() {
		return user_address;
	}
	public void setUser_address(String user_address) {
		this.user_address = user_address;
	}
	public String getUser_status() {
		return user_status;
	}
	public void setUser_status(String user_status) {
		this.user_status = user_status;
	}
	
	

}
