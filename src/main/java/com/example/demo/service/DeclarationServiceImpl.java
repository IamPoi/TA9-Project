package com.example.demo.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.DeclarationMapper;

@Service
public class DeclarationServiceImpl implements DeclarationService {
	
	@Autowired
	private DeclarationMapper decarationMapper;

	@Override
	public void declaration(Map<String, Object> map) throws Exception {
		decarationMapper.declaration(map);
	}
	


}
