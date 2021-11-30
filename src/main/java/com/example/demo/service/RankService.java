package com.example.demo.service;

import java.lang.reflect.Array;
import java.util.ArrayList;

import com.example.demo.model.AptInfoDTO;

public interface RankService {
	
	public ArrayList<AptInfoDTO> rankView(Long dong_num) throws Exception;

}
