package com.example.VFSS.repository;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.VFSS.entity.Subscription;

@Repository
public class SubscriptionDAOImpl implements SubscriptionDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public Optional<Subscription> findSubscription(int id) {
		
		return Optional.empty();
	}

	@Override
	public List<Subscription> findAllSubscriptions(int id) {
		String sql = "select id, usersId, subscriptionName, monthlyFee, startingDate, createdAt, updatedAt, deleteFlg "
				+ "from SUBSCRIPTIONS where usersId = ?";
		
		List<Map<String, Object>> resultList= jdbcTemplate.queryForList(sql, id);
		List<Subscription> subscriptionList = new ArrayList<>();
		
		for(Map<String, Object> list : resultList ) {
			Subscription sub = new Subscription();
			sub.setId((int)list.get("id"));
			sub.setId((int)list.get("usersId"));
			sub.setSubscriptionName((String)list.get("subscriptionName"));
			sub.setMonthlyFee((int)list.get("mouthlyFee"));
			sub.setStartingDate((LocalDate)list.get("startingDate"));
			sub.setCreatedAt((Timestamp)list.get("createdAt"));
			sub.setUpdatedAt((Timestamp)list.get("updatedAt"));
			sub.setDeleteFlg((int)list.get("deleteFlg"));
			subscriptionList.add(sub);
		}
		return subscriptionList;
	}

	@Override
	public void insert(Subscription sub) {
		// TODO 自動生成されたメソッド・スタブ
		String sql = "insert into SUBSCRIPTIONS (usersId, subscriptionName, monthlyFee, startingDate, createdAt, updatedAt) "
				+ "values (?, ?, ?, ?, ?, ?)";
		jdbcTemplate.update(sql, sub.getUsersId(), sub.getSubscriptionName(), sub.getMonthlyFee(), sub.getStartingDate(), sub.getCreatedAt(),
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
