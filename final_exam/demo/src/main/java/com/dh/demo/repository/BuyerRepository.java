package com.dh.demo.repository;

import com.dh.demo.domain.Buyer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author rOlguin
 */
public interface BuyerRepository extends JpaRepository<Buyer,Long> {
}
