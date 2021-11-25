package com.example.demo.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.CommentUpdateMapper;

@Service
public class CommentUpdateServiceImpl implements CommentUpdateService {
	
	@Autowired
	private CommentUpdateMapper commentUpdateMapper;

	@Override
	public void commentUpdate(Map<String, Object> map) throws Exception {
		commentUpdateMapper.commentUpdate(map);
	}
	
	
}
