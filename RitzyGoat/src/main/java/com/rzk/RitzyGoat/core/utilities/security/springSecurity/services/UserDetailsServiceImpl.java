package com.rzk.RitzyGoat.core.utilities.security.springSecurity.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rzk.RitzyGoat.dataAccess.abstracts.UserDao;
import com.rzk.RitzyGoat.entities.concretes.User;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	UserDao userRepository;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = userRepository.findByEmail(email)
				.orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + email));

		return UserDetailsImpl.build(user);
	}
	
	

}
