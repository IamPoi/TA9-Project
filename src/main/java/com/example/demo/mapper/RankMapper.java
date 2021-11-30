package com.example.demo.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.example.demo.model.AptInfoDTO;

@Mapper
@Repository
public interface RankMapper {
	
	public ArrayList<AptInfoDTO> rankView(Long dong_num);

}
