package com.example.demo.model;

public class UserDTO {
	
	private String id;
	private String pw;
	private String name;
	private int dong_num;
	private String apt;
	
	public UserDTO(String id, String pw) {
		super();
		this.id = id;
		this.pw = pw;
	}

	public UserDTO(String id, String pw, String name, int dong_num, String apt) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.dong_num = dong_num;
		this.apt = apt;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDong_num() {
		return dong_num;
	}
	public void setDong_num(int dong_num) {
		this.dong_num = dong_num;
	}
	public String getApt() {
		return apt;
	}
	public void setApt(String apt) {
		this.apt = apt;
	}
	
	

}
