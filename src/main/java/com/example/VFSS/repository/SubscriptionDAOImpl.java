package com.example.VFSS.repository;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
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
	public List<Subscription> findAllSubscriptions(int id, HashMap<String, String> search) {
		String sql = "select id, usersId, subscriptionName, monthlyFee, startingDate, createdAt, updatedAt, deleteFlg "
				+ "from SUBSCRIPTIONS where usersId = ? limit ? offset ?";
		int limit = Integer.parseInt(search.get("limit"));
		int page = Integer.parseInt(search.get("page")) - 1;
		
		List<Map<String, Object>> resultList= jdbcTemplate.queryForList(sql, id,  limit, page * limit);
		List<Subscription> subscriptionList = new ArrayList<>();
		
		for(Map<String, Object> list : resultList ) {
			Subscription sub = new Subscription();
			sub.setId((int)list.get("id"));
			sub.setId((int)list.get("usersId"));
			sub.setServiceName((String)list.get("subscriptionName"));
			sub.setMonthlyFee((int)list.get("monthlyFee"));
			sub.setStartingDate(((Date)list.get("startingDate")).toLocalDate());
			sub.setCreatedAt(Timestamp.valueOf((LocalDateTime)list.get("createdAt")));
			sub.setUpdatedAt(Timestamp.valueOf((LocalDateTime)list.get("updatedAt")));
			sub.setDeleteFlg((int)list.get("deleteFlg"));
			sub.setUsagePeriod(ChronoUnit.MONTHS.between(sub.getStartingDate(), LocalDate.now()));
			subscriptionList.add(sub);
		}
		return subscriptionList;
	}

	@Override
	public void insert(Subscription sub) {
		String sql = "insert into SUBSCRIPTIONS (usersId, subscriptionName, monthlyFee, startingDate, createdAt, updatedAt) "
				+ "values (?, ?, ?, ?, ?, ?)";
		jdbcTemplate.update(sql, sub.getUsersId(), sub.getServiceName(), sub.getMonthlyFee(), sub.getStartingDate(), sub.getCreatedAt(),
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

	@Override
	public int allSubscriptionsCount(int id) {
		String sql ="select count(1) as allSubscriptionsCount from SUBSCRIPTIONS where usersId = ?";
		Map<String, Object> result =  jdbcTemplate.queryForMap(sql, id);
		return  ((Number) result.get("allSubscriptionsCount")).intValue();
	}

}
