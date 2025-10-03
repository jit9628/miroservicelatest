package com.auth.AuthService.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.auth.AuthService.entity.UserProfile;
@Repository
public interface ProfileRepository extends JpaRepository<UserProfile, UUID> {
	

}
