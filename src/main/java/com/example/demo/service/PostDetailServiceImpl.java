package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.PostDetailMapper;
import com.example.demo.model.PostDTO;

@Service
public class PostDetailServiceImpl implements PostDetailService{
	
	@Autowired
	private PostDetailMapper postDetailMapper;

	@Override
	public PostDTO postDetailView(int post_num) throws Exception {
		System.out.println("게시판 상세 보기");
		return postDetailMapper.postDetailView(post_num);
	}
	

}
