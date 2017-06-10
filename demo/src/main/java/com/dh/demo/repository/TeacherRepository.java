package com.dh.demo.repository;

import com.dh.demo.domain.Teacher;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

/**
 * @author rOlguin
 */
public interface TeacherRepository extends MongoRepository<Teacher,String>{
    @Query("{id:?0,name:?1}")
    List<Teacher> getTeacherByName (String id,String name);
}
