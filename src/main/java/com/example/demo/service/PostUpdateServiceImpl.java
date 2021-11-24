package com.example.demo.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.PostUpdateMapper;

@Service
public class PostUpdateServiceImpl implements PostUpdateService{
	
	@Autowired
	private PostUpdateMapper postUpdateMapper;

	@Override
	public void postUpdate(Map<String,Object> map) throws Exception {
		postUpdateMapper.postUpdate(map);
	}
	
	
	

}
