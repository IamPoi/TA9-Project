package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.PostDeleteMapper;

@Service
public class PostDeleteServiceImpl  implements PostDeleteService{
	
	@Autowired
	private PostDeleteMapper postDeleteMapper;

	@Override
	public void postDelete(int post_num) throws Exception {
		
		postDeleteMapper.postDelete(post_num);

	}
	
	
	
	

}
