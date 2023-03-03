package com.example.VFSS.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import com.example.VFSS.entity.Subscription;

public interface SubscriptionDAO {

	Optional<Subscription> findSubscription(int id);
	
	List<Subscription> findAllSubscriptions(int id, HashMap<String, String> search);
	
	int allSubscriptionsCount(int id);
	
	void insert(Subscription sub);
	
	int update(Subscription sub);
	
	int delete(int id);
}
