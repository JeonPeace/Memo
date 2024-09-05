package com.jeonpeace.memo.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeonpeace.memo.user.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public int addUser(String loginId
					, String password
					, String name
					, String email) {
		
		int count = userRepository.insertUser(loginId, password, name, email);
		
		return count;
	}
	
}
