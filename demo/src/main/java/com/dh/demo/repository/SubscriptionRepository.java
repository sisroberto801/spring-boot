package com.dh.demo.repository;

import com.dh.demo.domain.Subscription;
import com.dh.demo.domain.Teacher;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

/**
 * @author rOlguin
 */
public interface SubscriptionRepository extends MongoRepository<Subscription,String> {
}