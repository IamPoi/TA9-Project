package com.example.demo.service;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.MyPostMapper;
import com.example.demo.model.PostDTO;

@Service
public class MyPostServiceImpl implements MyPostService{
	
	@Autowired 
	MyPostMapper myPostMapper;

	@Override
	public ArrayList<PostDTO> myPostView(Map<String, Object> map) throws Exception{
		
		return myPostMapper.myPostView(map);
	}
	
	

}
