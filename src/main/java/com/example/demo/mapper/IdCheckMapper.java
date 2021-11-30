package com.example.demo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface IdCheckMapper {

	public int idCheck(String id) throws Exception;

}
