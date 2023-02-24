package com.example.VFSS.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.VFSS.entity.Subscription;
import com.example.VFSS.repository.SubscriptionDAO;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {
	
	@Autowired
	private final SubscriptionDAO subscriptionDao;
	
	public SubscriptionServiceImpl(SubscriptionDAO subscriptionDao) {
		this.subscriptionDao = subscriptionDao;
	}

	@Override
	public Optional<Subscription> findSubscription(int id) {
		// TODO 自動生成されたメソッド・スタブ
		return Optional.empty();
	}

	@Override
	public Optional<List<Subscription>> findAllSubscriptions(int id) {
		// TODO 自動生成されたメソッド・スタブ
		return Optional.empty();
	}

	@Override
	public List<String> insert(Subscription sub) {

		return null;
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
