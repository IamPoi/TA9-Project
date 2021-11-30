package com.example.demo.model;

public class NewsDTO {

	private String title;
	private String href;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public NewsDTO(String title, String href) {
		super();
		this.title = title;
		this.href = href;
	}

}
