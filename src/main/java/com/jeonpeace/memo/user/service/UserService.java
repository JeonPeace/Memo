package com.jeonpeace.memo.user.service;

import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeonpeace.memo.common.HashingEncoder;
import com.jeonpeace.memo.user.domain.User;
import com.jeonpeace.memo.user.repository.UserRepository;

@Service
public class UserService {

	// IOC : 제어의 역전
	// DI(Dependency Injection) : 의존성 주입
	private UserRepository userRepository;
	
	private HashingEncoder encoder;
	
	// 생성자가 autowired를 위한 것 하나만 존재하는 경우 autowired 생략
//	@Autowired
	private UserService(UserRepository userRepository, @Qualifier("md5Hashing") HashingEncoder encoder) {
		this.userRepository = userRepository;
		this.encoder = encoder;
	}
	
	public int addUser(String loginId
					, String password
					, String name
					, String email) {
		
		// 암호화
		String encryptPassword = encoder.encode(password);
		
		return userRepository.insertUser(loginId, encryptPassword, name, email);
	}
	
	public User getUser(String loginId, String password) {
		
		String encryptPassword = encoder.encode(password);
		
		User user = userRepository.selectUser(loginId, encryptPassword);
		
		return user;
	}
	
	public boolean checkDuplicate(String loginId) {
		
		int count = userRepository.checkDuplicate(loginId);
		
		if(count == 0) {
			// 중복 안됨
			return false;
		}else {
			// 중복됨
			return true;
		}
	}
	
}
