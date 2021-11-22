package com.example.demo.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface PostWriteMapper {
	
	public void postWrite(Map<String,Object> map) ;

}
