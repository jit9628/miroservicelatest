package com.auth.AuthService.service.implementation;

import java.util.List;

import com.auth.AuthService.entity.User;

public interface UserInfoService {
	public User saveUser(User user);
	
	public List<User> getAllUser();

}
