package com.example.VFSS.service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.example.VFSS.entity.Subscription;
import com.example.VFSS.exception.SubscriptionNotFoundException;
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
		try {
			return subscriptionDao.findSubscription(id);
		} catch(EmptyResultDataAccessException e) {
			throw new SubscriptionNotFoundException("指定されたIDのサービスが存在しません");
		}
	}

	@Override
	public List<Subscription> findAllSubscriptions(int id, HashMap<String, String> search) {
		return subscriptionDao.findAllSubscriptions(id, search);
	}

	@Override
	public void insert(Subscription sub) {
		subscriptionDao.insert(sub);
	}

	@Override
	public int update(Subscription sub, int subscriptionId) {
		return subscriptionDao.update(sub, subscriptionId);
	}

	@Override
	public int delete(int id) {
		return subscriptionDao.delete(id);
	}

	@Override
	public int allSubscriptionsCount(int id) {
		return subscriptionDao.allSubscriptionsCount(id);
	}

}
