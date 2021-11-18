package com.example.demo.mapper;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.example.demo.model.PostDTO;

@Mapper
@Repository
public interface PostMapper {
	
	public ArrayList<PostDTO> postView(int dong_num);
}
