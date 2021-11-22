package com.example.demo.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.CommentWriteMapper;

@Service
public class CommentWriteServiceImpl implements CommentWriteService{
	
	@Autowired
	private CommentWriteMapper commentWriteMapper;

	@Override
	public void commentWrite(Map<String, Object> map) throws Exception {
		
		commentWriteMapper.commentWrite(map);
	}
	
	
	

}
