package com.whatsup.repository;

import com.whatsup.model.Coupon;
import com.whatsup.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by DelMonroe on 7/10/17.
 */
@Repository
public interface CouponsRepository extends JpaRepository<Coupon, Long> {
}
