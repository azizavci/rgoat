package com.rzk.RitzyGoat.dataAccess.abstracts;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rzk.RitzyGoat.entities.concretes.User;

@Repository
public interface UserDao extends JpaRepository<User, Long> {

	User findById(int id);

	Optional<User> findByEmail(String email);

	Boolean existsByUsername(String username);

	Boolean existsByEmail(String email);

}
