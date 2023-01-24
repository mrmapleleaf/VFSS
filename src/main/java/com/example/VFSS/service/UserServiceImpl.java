package com.example.VFSS.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.example.VFSS.entity.User;
import com.example.VFSS.repository.UserDAO;
import com.example.VFSS.repository.UserDAOImpl;
import com.example.VFSS.service.Encrypto.CryptoHash;
import com.example.VFSS.service.Validators.UserValidator;

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
			return userDao.findUser(userId, CryptoHash.encryptoHash(password));
		} catch(EmptyResultDataAccessException e) {
			return null;
		}
	}

	@Override
	public List<String>  insert(User user) {
		
		List<String> errorList = UserValidator.validate(user.getUserId(), user.getPassword());
		if(!(errorList.size() == 0)) {
			return errorList;
		}
		
		if(userDao.checkRegisteredUserId(user.getUserId()) != 0) {
			errorList.add("入力されたユーザーIDは既に使用されています");
			return errorList;
		}
		
		user.setPassword(CryptoHash.encryptoHash(user.getPassword()));
		userDao.insert(user);
		
		return errorList;
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
