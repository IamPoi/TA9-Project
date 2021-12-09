package com.example.demo.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.AptDetailMapper;
import com.example.demo.model.AptInfoDTO;

@Service
public class AptDetailServiceImpl implements AptDetailService{
	
	@Autowired
	private AptDetailMapper aptDetailMapper;

	@Override
	public AptInfoDTO aptDetailView(Map<String, Object> map) throws Exception {
		// 
		return aptDetailMapper.aptDetailView(map);
	}
	
	
	

}
