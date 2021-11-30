package com.example.demo.model;

public class AptInfoDTO {

	private int year;
	private String road_name;
	private String road_num;
	private long dong_num;
	private String apt;
	private int max_price;
	private int min_price;
	private int avg_price;

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getRoad_name() {
		return road_name;
	}

	public void setRoad_name(String road_name) {
		this.road_name = road_name;
	}

	public String getRoad_num() {
		return road_num;
	}

	public void setRoad_num(String road_num) {
		this.road_num = road_num;
	}

	public long getDong_num() {
		return dong_num;
	}

	public void setDong_num(long dong_num) {
		this.dong_num = dong_num;
	}

	public String getApt() {
		return apt;
	}

	public void setApt(String apt) {
		this.apt = apt;
	}

	public int getMax_price() {
		return max_price;
	}

	public void setMax_price(int max_price) {
		this.max_price = max_price;
	}

	public int getMin_price() {
		return min_price;
	}

	public void setMin_price(int min_price) {
		this.min_price = min_price;
	}

	public int getAvg_price() {
		return avg_price;
	}

	public void setAvg_price(int avg_price) {
		this.avg_price = avg_price;
	}

	public AptInfoDTO(int year, String road_name, String road_num, long dong_num, String apt, int max_price,
			int min_price, int avg_price) {
		super();
		this.year = year;
		this.road_name = road_name;
		this.road_num = road_num;
		this.dong_num = dong_num;
		this.apt = apt;
		this.max_price = max_price;
		this.min_price = min_price;
		this.avg_price = avg_price;
	}

}
