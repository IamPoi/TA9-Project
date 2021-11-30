package com.example.demo.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.RankMapper;
import com.example.demo.model.AptInfoDTO;

@Service
public class RankServiceImpl implements RankService {
	
	@Autowired
	private RankMapper rankMapper;

	@Override
	public ArrayList<AptInfoDTO> rankView(Long dong_num) throws Exception {
		
		return rankMapper.rankView(dong_num);
	}

}
