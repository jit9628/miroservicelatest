package com.auth.AuthService.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.auth.AuthService.entity.User;
import com.auth.AuthService.repositories.UserRepository;
@Service
public class UserInfoServiceImplementation implements UserInfoService {

	@Autowired
	private UserRepository userRepository;
	@Override
	public User saveUser(User user) {
		
		return this.userRepository.save(user);
	}
	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		return this.userRepository.findAll();
	}
	

}
