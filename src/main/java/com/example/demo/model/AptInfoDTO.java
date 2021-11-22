package com.example.demo.model;

public class AptInfoDTO {
	
	private String dong_apt;
	private Long dong_num;
	private int min_price;
	private int max_price;
	public String getDong_apt() {
		return dong_apt;
	}
	public void setDong_apt(String dong_apt) {
		this.dong_apt = dong_apt;
	}
	public Long getDong_num() {
		return dong_num;
	}
	public void setDong_num(Long dong_num) {
		this.dong_num = dong_num;
	}
	public int getMin_price() {
		return min_price;
	}
	public void setMin_price(int min_price) {
		this.min_price = min_price;
	}
	public int getMax_price() {
		return max_price;
	}
	public void setMax_price(int max_price) {
		this.max_price = max_price;
	}
	public AptInfoDTO(String dong_apt, Long dong_num, int min_price, int max_price) {
		super();
		this.dong_apt = dong_apt;
		this.dong_num = dong_num;
		this.min_price = min_price;
		this.max_price = max_price;
	}
	
	
	
	
	
	

}
