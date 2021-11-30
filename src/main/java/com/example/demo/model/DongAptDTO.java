package com.example.demo.model;

public class DongAptDTO {
	private String dong;
	private String apt;
	
	public String getDong() {
		return dong;
	}
	public void setDong(String dong) {
		this.dong = dong;
	}
	public String getApt() {
		return apt;
	}
	public void setApt(String apt) {
		this.apt = apt;
	}
	public DongAptDTO(String dong, String apt) {
		super();
		this.dong = dong;
		this.apt = apt;
	}
	
}
