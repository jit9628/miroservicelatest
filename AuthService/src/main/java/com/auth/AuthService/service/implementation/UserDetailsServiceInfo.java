package com.auth.AuthService.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.auth.AuthService.entity.User;
import com.auth.AuthService.repositories.UserRepository;
@Service
public class UserDetailsServiceInfo implements org.springframework.security.core.userdetails.UserDetailsService{

	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User users = this.userRepository.findByEmail(username)
		.orElseThrow(()->new UsernameNotFoundException("User Not Available "+username));
		
		
		return new UserDetailsInfo(users);
		
		  

	}

}
