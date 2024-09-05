package com.jeonpeace.memo.user;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

	@GetMapping("/join-view")
	public String inputJoin() {
		
		return "/user/join";
	}
	
	@PostMapping("/join")
	public Map<String, String> join(){
		
		
	}
	
	@GetMapping("/login-view")
	public String inputlogin() {
		
		return "user/login"; 
	}
	
}
