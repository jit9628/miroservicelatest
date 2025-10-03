package com.auth.AuthService.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@EntityListeners(AuditingEntityListener.class)
@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserProfile {
	 @Id
	    
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
	
	 @OneToOne
	    @MapsId  // 👈 primary key share karega
	    @JoinColumn(name = "userid")
	    private User user;
	

}
