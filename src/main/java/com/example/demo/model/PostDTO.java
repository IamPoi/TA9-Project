package com.example.demo.model;

public class PostDTO {
	
	private int post_num;
	private String content;
	private String writer_id;
	private int dong_num;
	
	public PostDTO(int post_num, String content, String writer_id, int dong_num) {
		super();
		this.post_num = post_num;
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
	public int getDong_num() {
		return dong_num;
	}
	public void setDong_num(int dong_num) {
		this.dong_num = dong_num;
	}

	@Override
	public String toString() {
		return "PostDTO [post_num=" + post_num + ", content=" + content + ", writer_id=" + writer_id + ", dong_num="
				+ dong_num + "]";
	}
	
	

}
