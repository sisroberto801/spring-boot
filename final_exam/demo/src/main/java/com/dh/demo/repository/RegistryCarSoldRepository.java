package com.dh.demo.repository;

import com.dh.demo.domain.RegistryCarSold;
import com.dh.demo.domain.Seller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author rOlguin
 */
@Repository
public interface RegistryCarSoldRepository extends JpaRepository<RegistryCarSold,Long> {

    @Query("select r from RegistryCarSold r where r.seller.id =:sellerId")
    List<RegistryCarSold> findAllRegistryCarSold(@Param("sellerId") Long sellerId);
}
