package com.example.demo.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.example.demo.model.CommentDTO;

@Mapper
@Repository
public interface CommentViewMapper {
	
	public ArrayList<CommentDTO> commentView(int no);

}
