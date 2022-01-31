package com.rzk.RitzyGoat.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rzk.RitzyGoat.entities.concretes.ERole;
import com.rzk.RitzyGoat.entities.concretes.Role;
import java.util.Optional;

@Repository
public interface RoleDao extends JpaRepository<Role, Integer> {

	Optional<Role> findByName(ERole roleName);
	
}
