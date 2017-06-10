package com.dh.demo.repository;

import com.dh.demo.domain.Room;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author rOlguin
 */
public interface RoomRepository extends MongoRepository<Room,String> {
}
