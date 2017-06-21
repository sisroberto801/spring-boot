package com.dh.demo.repository;

import com.dh.demo.domain.Car;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author rOlguin
 */
public interface CarRepository extends JpaRepository<Car,Long> {
}
