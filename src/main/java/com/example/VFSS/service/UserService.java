package com.example.VFSS.service;

import java.util.List;
import java.util.Optional;

import com.example.VFSS.entity.User;

public interface UserService {

	Optional<User> findUser(String userId, String password);
	
	List<String> insert(User user);
	
	int update(User user);
	
	int delete(int id);
}
