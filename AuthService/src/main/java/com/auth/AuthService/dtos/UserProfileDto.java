package com.auth.AuthService.dtos;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserProfileDto {
	private UUID profileId;
	private String partnerName;
	private String contactNumer;
	private String partnerEmail;
	private String country;
	private String state;
	private String district;
	private String portalCode;
	@CreatedDate
	@Column(updatable = false, nullable = false,insertable = true)
	private LocalDateTime createdAt;
	@LastModifiedDate
	private LocalDateTime updatedAt;
	
	private UUID userid;

}
