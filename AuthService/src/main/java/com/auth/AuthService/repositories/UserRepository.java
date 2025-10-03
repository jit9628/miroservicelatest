package com.auth.AuthService.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.auth.AuthService.entity.User;


@Repository
public interface UserRepository extends JpaRepository<User, UUID>{
	
	Optional<User>findByEmail(String email);

}
