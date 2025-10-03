package com.auth.AuthService.service.implementation;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import com.auth.AuthService.entity.User;

import lombok.NoArgsConstructor;

@NoArgsConstructor
@Service

public class UserDetailsInfo implements org.springframework.security.core.userdetails.UserDetails{
	
	private String email;
	private String password ;
	
	private List<GrantedAuthority> grantedAuthorities;
	
	
	UserDetailsInfo(User user){
		this.email=user.getEmail();
		this.password=user.getPassword();
		this.grantedAuthorities=Arrays.stream(user.getRole().split(",")).map(SimpleGrantedAuthority::new).collect(Collectors.toList());
				
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		return grantedAuthorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return this.password;
	}

	@Override
	public String getUsername() {
		return this.email;
	}
	
}
