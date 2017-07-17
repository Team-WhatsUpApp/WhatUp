package com.whatsup.repositories;

import com.whatsup.models.Coupon;
import com.whatsup.models.Vendor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by mosesfranco on 7/6/17
 * Codeup
 * Pinnacles
 */
@Repository
public interface CouponsRepository extends CrudRepository<Coupon, Long> {


    @Query(
        nativeQuery = true,
        value = "SELECT * FROM coupons c WHERE c.id NOT IN (SELECT c.id FROM coupons c JOIN user_has_coupons uc ON c.id = uc.coupon_id WHERE uc.user_id = ?1)"
    )
    Iterable<Coupon> notSelectedByUser(long userId);

	List<Coupon> findAll();

	List<Coupon> findByOwner(Vendor owner);

}
