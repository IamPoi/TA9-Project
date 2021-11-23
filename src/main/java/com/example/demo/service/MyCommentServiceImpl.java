package com.example.demo.service;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.MyCommentMapper;
import com.example.demo.model.CommentDTO;

@Service
public class MyCommentServiceImpl implements MyCommentService{
	
	@Autowired
	MyCommentMapper myCommentMapper;

	@Override
	public ArrayList<CommentDTO> myCommentView(Map<String, Object> map) throws Exception {

		return myCommentMapper.myCommentView(map);
	}
	

}
