package com.rzk.RitzyGoat.entities.concretes;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "secure_tokens")
public class SecureToken {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="token",unique = true)
	private String token;
	
	@Column(updatable = false,name="time_stamp")
	private LocalDateTime timeStamp;
	
	@Column(name="expire_at",updatable = false)
	@Basic(optional = false)
	private LocalDateTime expireAt;
	
	@ManyToOne()
	@JoinColumn(name = "user_id")
	private User user;
	
	@Transient
	@Column(name="is_expired")
	private boolean isExpired;
	
}
