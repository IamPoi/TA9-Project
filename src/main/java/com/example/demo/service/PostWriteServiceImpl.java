package com.example.demo.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.PostWriteMapper;

@Service
public class PostWriteServiceImpl implements PostWriteService{
	
	@Autowired
	private PostWriteMapper postWriteMapper;

	@Override
	public void postWrite(Map<String,Object> map) throws Exception {
		postWriteMapper.postWrite(map);
	}
	
	

}
