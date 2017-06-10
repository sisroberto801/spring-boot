package com.dh.demo.repository;

import com.dh.demo.domain.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author rOlguin
 */
public interface StudentRepository extends MongoRepository<Student,String> {
}