package com.example.demo.service;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.PostSearchMapper;
import com.example.demo.model.PostDTO;

@Service
public class PostSearchServiceImpl implements PostSearchService{
	
	@Autowired
	private PostSearchMapper postSearchMapper;

	@Override
	public ArrayList<PostDTO> postSearch(Map<String, Object> map) throws Exception {
		
		return postSearchMapper.postSearch(map);
	}
	
	

}
