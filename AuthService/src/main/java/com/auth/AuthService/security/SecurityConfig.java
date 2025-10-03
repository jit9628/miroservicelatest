package com.auth.AuthService.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.auth.AuthService.service.implementation.UserDetailsServiceInfo;

@EnableWebSecurity
@Configuration
public class SecurityConfig {
	
	@Autowired
	private UserDetailsServiceInfo detailsServiceInfo;
	
//	password Encoder Bean 
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	//Authentication MAnage Bean 
	@Bean
	AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
		 daoAuthenticationProvider.setUserDetailsService(detailsServiceInfo);
		 daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
		return daoAuthenticationProvider;
		 
	}
	
	
	 @Bean
	  SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	        http
	            .csrf(csrf -> csrf.disable())  // Disable CSRF for stateless API
	            .sessionManagement(session -> 
	                session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))  // Stateless session
	            .authorizeHttpRequests(auth -> auth
	                .requestMatchers("/api/public/saveUser","/api/public/saveUserProfile","/api/public/getAllUser","/api/public/getUserProfiles").permitAll()  // Public endpoints
	                .anyRequest().authenticated()  // All others need authentication
	            );

	        return http.build();
	        
	    }
	
	
	
	
	
	
	
	
	
	
	
	
}
