package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.CommentDeleteMapper;

@Service
public class CommentDeleteServiceImpl implements CommentDeleteService{
	
	@Autowired
	private CommentDeleteMapper commentDeleteMapper;

	@Override
	public void commentDelete(int comment_num) throws Exception {
		commentDeleteMapper.commentDelete(comment_num);
	}
	
	

}
