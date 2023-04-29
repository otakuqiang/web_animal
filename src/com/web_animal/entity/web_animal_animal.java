package com.web_animal.entity;

public class web_animal_animal {

	private int animal_id;
	private String animal_name;
	private String animal_latin;
	private int animal_fid;
	private int animal_cid;
	private String animal_photo;
	private String animal_audio;
	private String animal_video;
	private int animal_point;
	private String animal_introduce;
	private String animal_other;
	
	
	@Override
	public String toString() {
		return "web_animal_animal [animal_id=" + animal_id + ", animal_name=" + animal_name + ", animal_latin="
				+ animal_latin + ", animal_fid=" + animal_fid + ", animal_cid=" + animal_cid + ", animal_photo="
				+ animal_photo + ", animal_audio=" + animal_audio + ", animal_video=" + animal_video + ", animal_point="
				+ animal_point + ", animal_introduce=" + animal_introduce + ", animal_other=" + animal_other + "]";
	}
	public web_animal_animal() {
		super();
	}
	public web_animal_animal(int animal_id, String animal_name, String animal_latin, int animal_fid, int animal_cid,
			String animal_photo, String animal_audio, String animal_video, int animal_point, String animal_introduce,
			String animal_other) {
		super();
		this.animal_id = animal_id;
		this.animal_name = animal_name;
		this.animal_latin = animal_latin;
		this.animal_fid = animal_fid;
		this.animal_cid = animal_cid;
		this.animal_photo = animal_photo;
		this.animal_audio = animal_audio;
		this.animal_video = animal_video;
		this.animal_point = animal_point;
		this.animal_introduce = animal_introduce;
		this.animal_other = animal_other;
	}
	public int getAnimal_id() {
		return animal_id;
	}
	public void setAnimal_id(int animal_id) {
		this.animal_id = animal_id;
	}
	public String getAnimal_name() {
		return animal_name;
	}
	public void setAnimal_name(String animal_name) {
		this.animal_name = animal_name;
	}
	public String getAnimal_latin() {
		return animal_latin;
	}
	public void setAnimal_latin(String animal_latin) {
		this.animal_latin = animal_latin;
	}
	public int getAnimal_fid() {
		return animal_fid;
	}
	public void setAnimal_fid(int animal_fid) {
		this.animal_fid = animal_fid;
	}
	public int getAnimal_cid() {
		return animal_cid;
	}
	public void setAnimal_cid(int animal_cid) {
		this.animal_cid = animal_cid;
	}
	public String getAnimal_photo() {
		return animal_photo;
	}
	public void setAnimal_photo(String animal_photo) {
		this.animal_photo = animal_photo;
	}
	public String getAnimal_audio() {
		return animal_audio;
	}
	public void setAnimal_audio(String animal_audio) {
		this.animal_audio = animal_audio;
	}
	public String getAnimal_video() {
		return animal_video;
	}
	public void setAnimal_video(String animal_video) {
		this.animal_video = animal_video;
	}
	public int getAnimal_point() {
		return animal_point;
	}
	public void setAnimal_point(int animal_point) {
		this.animal_point = animal_point;
	}
	public String getAnimal_introduce() {
		return animal_introduce;
	}
	public void setAnimal_introduce(String animal_introduce) {
		this.animal_introduce = animal_introduce;
	}
	public String getAnimal_other() {
		return animal_other;
	}
	public void setAnimal_other(String animal_other) {
		this.animal_other = animal_other;
	}

	
	
}
