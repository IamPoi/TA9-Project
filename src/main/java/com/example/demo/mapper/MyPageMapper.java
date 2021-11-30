package com.example.demo.mapper;

import java.util.ArrayList;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.example.demo.model.AptInfoDTO;

@Mapper
@Repository
public interface MyPageMapper {

	public ArrayList<AptInfoDTO> aptInfo(Map<String, Object> map);
}
