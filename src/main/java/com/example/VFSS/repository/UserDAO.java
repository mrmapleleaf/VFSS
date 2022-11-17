package com.example.VFSS.repository;

import java.util.Optional;

import com.example.VFSS.entity.User;

public interface UserDAO {

	Optional<User> findUser(String userId, String password);
	
	void insert(User user);
	
	int update(User user);
	
	int delete(int id);
}
