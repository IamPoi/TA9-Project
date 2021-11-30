package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.IdCheckMapper;

@Service
public class IdCheckServiceImpl implements IdCheckService {

	@Autowired
	private IdCheckMapper idCheckMapper;

	@Override
	public int idCheck(String id) throws Exception {

		return idCheckMapper.idCheck(id);

	}

}
