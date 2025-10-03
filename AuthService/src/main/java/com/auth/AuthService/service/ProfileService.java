package com.auth.AuthService.service;

import java.util.List;

import com.auth.AuthService.dtos.UserProfileDto;
import com.auth.AuthService.entity.UserProfile;

public interface ProfileService {
	
	public UserProfile saveProfile(UserProfileDto userProfile);
	public List<UserProfile> getAlluserProfie();

}
