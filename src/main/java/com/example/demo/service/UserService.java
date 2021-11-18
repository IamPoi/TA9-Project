package com.example.demo.service;

import java.util.Map;

import com.example.demo.model.UserDTO;

public interface UserService {

	public UserDTO login(Map<String, String> map) throws Exception;

}
