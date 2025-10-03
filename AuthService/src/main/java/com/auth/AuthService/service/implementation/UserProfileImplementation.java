package com.auth.AuthService.service.implementation;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.auth.AuthService.dtos.UserProfileDto;
import com.auth.AuthService.entity.User;
import com.auth.AuthService.entity.UserProfile;
import com.auth.AuthService.repositories.ProfileRepository;
import com.auth.AuthService.repositories.UserRepository;
import com.auth.AuthService.service.ProfileService;
@Service
public class UserProfileImplementation implements ProfileService{
	@Autowired
	private ProfileRepository profileRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private ModelMapper mapper;

	
	@Override
	public UserProfile saveProfile(UserProfileDto userProfile) {
		
		Optional<User> userid = this.userRepository.findById(userProfile.getUserid());
		UserProfile mappedProfileData = this.mapper.map(userProfile, UserProfile.class);
		mappedProfileData.setUser(userid.get());
		
		return this.profileRepository.save(mappedProfileData);
		
		
	}


	@Override
	public List<UserProfile> getAlluserProfie() {
		
		return this.profileRepository.findAll();
	}

}
