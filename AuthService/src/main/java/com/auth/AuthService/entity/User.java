package com.auth.AuthService.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity(name = "Users")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class User {
	@Id
	    @GeneratedValue
	    @JsonIgnore
	    private UUID userid;
	private String email;
	@JsonIgnore
	private String password;
	private String role;
	@CreatedDate
	@Column(updatable = false, nullable = false,insertable = true)
	@JsonIgnore
	private LocalDateTime createdAt;
	@JsonIgnore
	@LastModifiedDate
	private LocalDateTime updatedAt;
	
   // @OneToOne(mappedBy = "user", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
   // private UserProfile profile;
	

}
