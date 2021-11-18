package com.example.demo.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.JoinMapper;
import com.example.demo.model.UserDTO;

@Service
public class JoinServiceImpl implements JoinService {

	@Autowired
	private JoinMapper joinMapper;

	@Override
	public void join(Map<String, Object> map) throws Exception {
		System.out.println("Join Service");
		joinMapper.join(map);
//		return joinMapper.join(map);
	}

}
