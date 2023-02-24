package com.example.VFSS.repository;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.VFSS.entity.User;

@Repository
public class UserDAOImpl implements UserDAO {
	
	@Autowired
	private JdbcTemplate jdbctemplate;
	
	public UserDAOImpl(JdbcTemplate jdbctemplate) {
		this.jdbctemplate = jdbctemplate;
	}
	

	@Override
	public Optional<User> findUser(String userId, String password) {
		String sql = "select id, userId, createdAt, updatedAt, deleteFlg from USERS where userId = ? and password = ?";
		Map<String, Object> result = jdbctemplate.queryForMap(sql, userId, password);

		User user = new User();
		user.setId((int)result.get("id"));
		user.setUserId((String)result.get("userId"));
		user.setCreatedAt(Timestamp.valueOf((LocalDateTime)result.get("createdAt")));
		user.setCreatedAt(Timestamp.valueOf((LocalDateTime)result.get("updatedAt")));
		user.setDeleteFlg((int)result.get("deleteFlg"));

		Optional<User> userOpt = Optional.ofNullable(user);

		return userOpt;
	}

	@Override
	public void insert(User user) {
		String sql = "insert  into USERS (userId, password, createdAt, updatedAt) values (?, ?, ?, ?)";
		jdbctemplate.update(sql, user.getUserId(), user.getPassword(), user.getCreatedAt(), user.getUpdatedAt());
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

	@Override
	public int checkRegisteredUserId(String userId) {
		String sql = "select userId from USERS where userId = ?" ;
		
		List<Map<String, Object> >result = jdbctemplate.queryForList(sql, userId);

		return result.size();
	}

}
