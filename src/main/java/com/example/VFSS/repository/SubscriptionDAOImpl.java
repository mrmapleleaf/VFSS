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
		String sql = "select id, usersId, serviceName, monthlyFee, startingDate, createdAt, updatedAt, deleteFlg "
				+ "from SUBSCRIPTIONS where id = ?";
		
		Map<String, Object> subObj = jdbcTemplate.queryForMap(sql, id);
		Subscription sub = subscriptionFactory(subObj);
		Optional<Subscription> subOpt = Optional.ofNullable(sub);
		
		return subOpt;
	}

	@Override
	public List<Subscription> findAllSubscriptions(int id, HashMap<String, String> search) {
		String sql = "select id, usersId, serviceName, monthlyFee, startingDate, createdAt, updatedAt, deleteFlg "
				+ "from SUBSCRIPTIONS where usersId = ? and deleteFlg = 0 limit ? offset ?";
		int limit = Integer.parseInt(search.get("limit"));
		int page = Integer.parseInt(search.get("page")) - 1;
		
		List<Map<String, Object>> resultList= jdbcTemplate.queryForList(sql, id,  limit, page * limit);
		List<Subscription> subscriptionList = new ArrayList<>();
		
		for(Map<String, Object> subObj : resultList ) {
			Subscription sub = subscriptionFactory(subObj);
			subscriptionList.add(sub);
		}
		return subscriptionList;
	}

	@Override
	public void insert(Subscription sub) {
		String sql = "insert into SUBSCRIPTIONS (usersId, serviceName, monthlyFee, startingDate, createdAt, updatedAt) "
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
		String sql ="select count(1) as allSubscriptionsCount from SUBSCRIPTIONS where usersId = ? and deleteFlg = 0";
		Map<String, Object> result =  jdbcTemplate.queryForMap(sql, id);
		return  ((Number) result.get("allSubscriptionsCount")).intValue();
	}
	
	private Subscription subscriptionFactory(Map<String, Object> obj) {
		Subscription sub = new Subscription();
		sub.setId((int)obj.get("id"));
		sub.setUsersId((int)obj.get("usersId"));
		sub.setServiceName((String)obj.get("serviceName"));
		sub.setMonthlyFee((int)obj.get("monthlyFee"));
		sub.setStartingDate(((Date)obj.get("startingDate")).toLocalDate());
		sub.setCreatedAt(Timestamp.valueOf((LocalDateTime)obj.get("createdAt")));
		sub.setUpdatedAt(Timestamp.valueOf((LocalDateTime)obj.get("updatedAt")));
		sub.setDeleteFlg((int)obj.get("deleteFlg"));
		sub.setUsagePeriod(ChronoUnit.MONTHS.between(sub.getStartingDate(), LocalDate.now()));
		return sub;
	}

}
