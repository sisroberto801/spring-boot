package com.dh.demo.repository;

import com.dh.demo.domain.Subject;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author rOlguin
 */
public interface SubjectRepository extends MongoRepository<Subject,String> {
}