package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.DongAptMapper;
import com.example.demo.model.DongAptDTO;
import com.example.demo.model.UserDTO;

@Service
public class DongAptServiceImpl implements DongAptService{
	
	@Autowired
	private DongAptMapper dongAptMapper;

	@Override
	public DongAptDTO dongApt(UserDTO dto) throws Exception {
		System.out.println("동_아파트 검색하기");
		return dongAptMapper.dongApt(dto);
	}
	
	
	

}
