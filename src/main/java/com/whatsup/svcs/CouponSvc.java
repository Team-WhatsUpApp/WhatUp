package com.whatsup.svcs;

import com.whatsup.models.Coupon;
import com.whatsup.repositories.CouponsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by DelMonroe on 7/14/17.
 */
@Service("couponSvc")
public class CouponSvc {

    private CouponsRepository couponsRepository;

    @Autowired
    public CouponSvc(CouponsRepository couponsRepository) {
        this.couponsRepository = couponsRepository;
    }

    public Iterable<Coupon> findAll() {
        return couponsRepository.findAll();
    }

    public Coupon findOne(long id){
        return couponsRepository.findOne(id);
    }

    public Coupon save(Coupon coupon){
        couponsRepository.save(coupon);
        return coupon;
    }

    public void deleteCoupon(long id){
        couponsRepository.delete(id);
    }


}
