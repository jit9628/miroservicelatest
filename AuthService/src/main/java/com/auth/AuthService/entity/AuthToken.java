package com.auth.AuthService.entity;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@Entity
public class AuthToken {
	 @Id
	    @GeneratedValue
	private UUID authId;
	private String  authTokenId;
	private String authToken;
	private boolean isExpred;
	private boolean isVerified;
	
	// one to  one mapping
	

}
