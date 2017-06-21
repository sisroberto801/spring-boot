package com.dh.demo.repository;

import com.dh.demo.domain.Seller;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author rOlguin
 */
public interface SellerRepository extends JpaRepository<Seller,Long> {
}
