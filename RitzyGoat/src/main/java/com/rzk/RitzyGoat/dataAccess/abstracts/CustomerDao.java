package com.rzk.RitzyGoat.dataAccess.abstracts;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rzk.RitzyGoat.entities.concretes.Customer;

public interface CustomerDao extends JpaRepository<Customer, Long> {
	
	Customer findById(int id);

	Optional<Customer> findByEmail(String email);

	Boolean existsByUsername(String username);

	Boolean existsByEmail(String email);
	
}
