package com.example.demo.model;

public class CommentDTO {
	
	private int comment_num;
	private int post_num;
	private String comment_writer;
	private String content;
	
	public int getComment_num() {
		return comment_num;
	}
	public void setComment_num(int comment_num) {
		this.comment_num = comment_num;
	}
	public int getPost_num() {
		return post_num;
	}
	public void setPost_num(int post_num) {
		this.post_num = post_num;
	}
	public String getComment_writer() {
		return comment_writer;
	}
	public void setComment_writer(String comment_writer) {
		this.comment_writer = comment_writer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	public CommentDTO(int comment_num, int post_num, String comment_writer, String content) {
		super();
		this.comment_num = comment_num;
		this.post_num = post_num;
		this.comment_writer = comment_writer;
		this.content = content;
	}
	

}
