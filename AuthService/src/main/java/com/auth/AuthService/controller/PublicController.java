package com.auth.AuthService.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.auth.AuthService.dtos.UserProfileDto;
import com.auth.AuthService.entity.User;
import com.auth.AuthService.entity.UserProfile;
import com.auth.AuthService.service.ProfileService;
import com.auth.AuthService.service.implementation.UserInfoService;

@RestController
@RequestMapping("/api/public")
public class PublicController {
	
	@Autowired
	private UserInfoService userInfoService;
	@Autowired
	
	private ProfileService profileService;
	@Autowired
	private PasswordEncoder encoder;
	
	@PostMapping("/saveUser")
	public ResponseEntity<?> saveUser(@RequestBody User user){
		String encode = encoder.encode(user.getPassword());
		user.setPassword(encode);
		System.out.println(user.getPassword());
		User saveUser = this.userInfoService.saveUser(user);
		return new ResponseEntity<>(Map.of("data",saveUser), HttpStatus.OK);
	}
	
	@GetMapping("/getAllUser")
	public ResponseEntity<?> getAllUser(){
		
	 List<User> allUser = this.userInfoService.getAllUser();
		return new ResponseEntity<>(Map.of("data",allUser), HttpStatus.OK);
	}
	
	
	
	
	
	@PostMapping("/saveUserProfile")
	public ResponseEntity<?> saveUserProfile(@RequestBody UserProfileDto userProfileDto){
		
		 UserProfile saveProfile = this.profileService.saveProfile(userProfileDto);
		return new ResponseEntity<>(Map.of("data",saveProfile), HttpStatus.OK);
	}
	
	
	@GetMapping("/getUserProfiles")
	public ResponseEntity<?> getUserProfile(){
		
	List<UserProfile> alluserProfie = this.profileService.getAlluserProfie();
		return new ResponseEntity<>(Map.of("data",alluserProfie), HttpStatus.OK);
	}
	
	
	
	
}
 