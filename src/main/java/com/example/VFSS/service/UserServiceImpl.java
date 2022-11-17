package com.example.VFSS.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.example.VFSS.entity.User;
import com.example.VFSS.repository.UserDAO;
import com.example.VFSS.repository.UserDAOImpl;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private final UserDAO userDao;
	
	public UserServiceImpl(UserDAOImpl userDaoImpl) {
		this.userDao = userDaoImpl;
	}

	@Override
	public Optional<User> findUser(String userId, String password) {
		
		try {
			return userDao.findUser(userId, password);
		} catch(DataAccessException e) {
			throw new UserNotFoundException("ユーザーが見つかりません。ユーザーID、パスワードが間違っている可能性があります。");
		}
	}

	@Override
	public void insert(User user) {
		userDao.insert(user);
	}

	@Override
	public int update(User user) {
		// TODO 自動生成されたメソッド・スタブ
		return 0;
	}

	@Override
	public int delete(int id) {
		// TODO 自動生成されたメソッド・スタブ
		return 0;
	}

}
