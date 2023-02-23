package com.example.VFSS.repository;

import java.util.List;
import java.util.Optional;

import com.example.VFSS.entity.Subscription;

public interface SubscriptionDAO {

	Optional<Subscription> findSubscription(int id);
	
	Optional<List<Subscription>> findAllSubscriptions(int id);
	
	void insert(Subscription sub);
	
	int update(Subscription sub);
	
	int delete(int id);
}
