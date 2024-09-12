package com.jeonpeace.memo.user.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.jeonpeace.memo.user.domain.User;

@Mapper
public interface UserRepository {

	public int insertUser(@Param("loginId") String loginId
						, @Param("password") String password
						, @Param("name") String name
						, @Param("email") String email);
	
	public User selectUser(@Param("loginId") String loginId
						, @Param("password") String password);
	
	public int checkDuplicate(@Param("loginId") String loginId);
}
