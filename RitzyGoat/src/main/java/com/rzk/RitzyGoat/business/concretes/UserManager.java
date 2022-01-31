package com.rzk.RitzyGoat.business.concretes;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.rzk.RitzyGoat.core.utilities.results.DataResult;
import com.rzk.RitzyGoat.core.utilities.results.Result;
import com.rzk.RitzyGoat.core.utilities.results.SuccessResult;
import com.rzk.RitzyGoat.core.utilities.results.SuccessDataResult;
import com.rzk.RitzyGoat.business.abstracts.UserService;
import com.rzk.RitzyGoat.dataAccess.abstracts.RoleDao;
import com.rzk.RitzyGoat.dataAccess.abstracts.UserDao;
import com.rzk.RitzyGoat.entities.concretes.User;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class UserManager implements UserService {

	private final UserDao userDao;
	private final RoleDao roleDao;
	private final PasswordEncoder passwordEncoder;

	@Override
	public Result add(User user) {

		log.info("saving new user to the database");
		this.userDao.save(user);
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return new SuccessResult("registration is successful!!");

	}

	@Override
	public DataResult<List<User>> getAll() {

		log.info("users are listed");
		return new SuccessDataResult<List<User>>(this.userDao.findAll(), "users are listed!");

	}
	
	

}
