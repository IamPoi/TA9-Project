package com.example.demo.model;

public class PostDTO {
	
	private int post_num;
	private String title;
	private String content;
	private String writer_id;
	private Long dong_num;
	public PostDTO(int post_num, String title, String content, String writer_id, Long dong_num) {
		super();
		this.post_num = post_num;
		this.title = title;
		this.content = content;
		this.writer_id = writer_id;
		this.dong_num = dong_num;
	}
	public int getPost_num() {
		return post_num;
	}
	public void setPost_num(int post_num) {
		this.post_num = post_num;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriter_id() {
		return writer_id;
	}
	public void setWriter_id(String writer_id) {
		this.writer_id = writer_id;
	}
	public Long getDong_num() {
		return dong_num;
	}
	public void setDong_num(Long dong_num) {
		this.dong_num = dong_num;
	}
	
	
	

}
