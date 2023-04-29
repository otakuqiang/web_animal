package com.web_animal.entity;

public class web_animal_science {
	private int science_id;
	private String science_title;
	private String science_photo;
	private String science_text;
	
	
	@Override
	public String toString() {
		return "web_animal_science [science_id=" + science_id + ", science_title=" + science_title + ", science_photo="
				+ science_photo + ", science_text=" + science_text + "]";
	}

	public web_animal_science(int science_id, String science_title, String science_photo, String science_text) {
		super();
		this.science_id = science_id;
		this.science_title = science_title;
		this.science_photo = science_photo;
		this.science_text = science_text;
	}

	public String getScience_photo() {
		return science_photo;
	}

	public void setScience_photo(String science_photo) {
		this.science_photo = science_photo;
	}

	public web_animal_science() {
		super();
	}
	
	public int getScience_id() {
		return science_id;
	}
	public void setScience_id(int science_id) {
		this.science_id = science_id;
	}
	public String getScience_title() {
		return science_title;
	}
	public void setScience_title(String science_title) {
		this.science_title = science_title;
	}
	public String getScience_text() {
		return science_text;
	}
	public void setScience_text(String science_text) {
		this.science_text = science_text;
	}


	
}
