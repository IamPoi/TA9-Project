package com.example.demo.mapper;

import java.util.ArrayList;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.example.demo.model.PostDTO;

@Mapper
@Repository
public interface AdminPostViewMapper {
	
	public ArrayList<PostDTO> allPostView(Map<String, Object> map);

}
