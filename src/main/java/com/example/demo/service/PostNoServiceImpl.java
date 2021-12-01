package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.PostNoMapper;

@Service
public class PostNoServiceImpl implements PostNoService{
	
	@Autowired
	private PostNoMapper postNoMapper;

	@Override
	public int postNo() throws Exception {
		return postNoMapper.postNo();
	}
	
	

}
