package com.example.demo.model;

public class UserDTO {

	private String id;
	private String pw;
	private String name;
	private Long dong_num;
	private String apt;
	private int activation;

	public int getActivation() {
		return activation;
	}

	public void setActivation(int activation) {
		this.activation = activation;
	}

	public UserDTO(String id, String pw) {
		super();
		this.id = id;
		this.pw = pw;
	}

	public UserDTO(String id, Long dong_num) {
		super();
		this.id = id;
		this.dong_num = dong_num;
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

	public Long getDong_num() {
		return dong_num;
	}

	public void setDong_num(Long dong_num) {
		this.dong_num = dong_num;
	}

	public String getApt() {
		return apt;
	}

	public void setApt(String apt) {
		this.apt = apt;
	}

	public UserDTO(String id, String pw, String name, Long dong_num, String apt, int activation) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.dong_num = dong_num;
		this.apt = apt;
		this.activation = activation;
	}


}
