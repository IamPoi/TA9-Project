package com.example.demo.model;

public class LocationDTO {

	private Long dong_num;
	private String dong;

	public Long getDong_num() {
		return dong_num;
	}

	public void setDong_num(Long dong_num) {
		this.dong_num = dong_num;
	}

	public String getDong() {
		return dong;
	}

	public void setDong(String dong) {
		this.dong = dong;
	}

	public LocationDTO(Long dong_num, String dong) {
		super();
		this.dong_num = dong_num;
		this.dong = dong;
	}

}
