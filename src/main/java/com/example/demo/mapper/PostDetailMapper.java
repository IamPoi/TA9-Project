package com.example.demo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.example.demo.model.PostDTO;

@Mapper
@Repository
public interface PostDetailMapper {

	public PostDTO postDetailView(int post_num);

}
