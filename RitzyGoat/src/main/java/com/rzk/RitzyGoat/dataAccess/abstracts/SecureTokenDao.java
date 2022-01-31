package com.rzk.RitzyGoat.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rzk.RitzyGoat.entities.concretes.SecureToken;

@Repository
public interface SecureTokenDao extends JpaRepository<SecureToken,Long> {

	SecureToken findByToken(final String token);
	Long removeByToken(String token);
	
}
