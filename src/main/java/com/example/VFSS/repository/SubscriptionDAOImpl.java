package com.example.VFSS.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.example.VFSS.entity.Subscription;

public class SubscriptionDAOImpl implements SubscriptionDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public Optional<Subscription> findSubscription(int id) {
		// TODO 自動生成されたメソッド・スタブ
		return Optional.empty();
	}

	@Override
	public Optional<List<Subscription>> findAllSubscriptions(int id) {
		
		return Optional.empty();
	}

	@Override
	public void insert(Subscription sub) {
		// TODO 自動生成されたメソッド・スタブ
		String sql = "insert into SUBSCRIPTIONS (usersId, subscriptionName, monthlyFee, createdAt, updatedAt)"
				+ "values (?, ?, ?, ?, ?)";
		jdbcTemplate.update(sql, sub.getUsersId(), sub.getSubscriptionName(), sub.getMonthlyFee(), sub.getCreatedAt(),
				 sub.getUpdatedAt());
	}

	@Override
	public int update(Subscription sub) {
		// TODO 自動生成されたメソッド・スタブ
		return 0;
	}

	@Override
	public int delete(int id) {
		// TODO 自動生成されたメソッド・スタブ
		return 0;
	}

}
