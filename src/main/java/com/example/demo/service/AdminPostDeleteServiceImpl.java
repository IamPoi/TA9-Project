package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.AdminPostDeleteMapper;
import com.example.demo.mapper.PostDeleteMapper;

@Service
public class AdminPostDeleteServiceImpl  implements PostDeleteService{
	
	@Autowired
	private AdminPostDeleteMapper adminPostDeleteMapper; 

	@Override
	public void postDelete(int post_num) throws Exception {
		
		System.out.println("fxck");
		
		adminPostDeleteMapper.postDelete(post_num);

	}
	
	
	
	

}
