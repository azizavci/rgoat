package com.rzk.RitzyGoat.business.abstracts;

import java.util.List;

import com.rzk.RitzyGoat.core.utilities.results.DataResult;
import com.rzk.RitzyGoat.core.utilities.results.Result;
import com.rzk.RitzyGoat.entities.concretes.User;

public interface UserService {
	
	DataResult<List<User>> getAll();
	Result add(User user);
	
	//Result addRole(Role role);
	//Result addRoleToUser(String userName,String roleName);
	//User getUser(String userName);
	
	
}
