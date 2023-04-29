package com.web_animal.entity;

public class web_animal_collect {

	private int collect_id;
	private String collect_u_id;
	private int collect_k_a_id;
	private int collect_state;
	public int getCollect_id() {
		return collect_id;
	}
	public void setCollect_id(int collect_id) {
		this.collect_id = collect_id;
	}
	public String getCollect_u_id() {
		return collect_u_id;
	}
	public void setCollect_u_id(String collect_u_id) {
		this.collect_u_id = collect_u_id;
	}
	public int getCollect_k_a_id() {
		return collect_k_a_id;
	}
	public void setCollect_k_a_id(int collect_k_a_id) {
		this.collect_k_a_id = collect_k_a_id;
	}
	public int getCollect_state() {
		return collect_state;
	}
	public void setCollect_state(int collect_state) {
		this.collect_state = collect_state;
	}
	public web_animal_collect(int collect_id, String collect_u_id, int collect_k_a_id, int collect_state) {
		super();
		this.collect_id = collect_id;
		this.collect_u_id = collect_u_id;
		this.collect_k_a_id = collect_k_a_id;
		this.collect_state = collect_state;
	}
	public web_animal_collect() {
		super();
	}
	@Override
	public String toString() {
		return "web_animal_collect [collect_id=" + collect_id + ", collect_u_id=" + collect_u_id + ", collect_k_a_id="
				+ collect_k_a_id + ", collect_state=" + collect_state + "]";
	}
	

}
