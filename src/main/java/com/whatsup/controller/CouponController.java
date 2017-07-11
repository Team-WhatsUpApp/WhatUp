package com.whatsup.controller;

import com.whatsup.model.Coupon;
import com.whatsup.repository.CouponsRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by DelMonroe on 7/10/17.
 */
@Controller
public class CouponController {

    @Autowired
    private CouponsRepository couponsRepository;

//    List all coupons

    @GetMapping("/coupons")
    public List<Coupon> list() {
        return couponsRepository.findAll();
    }

//    Create a coupon

    @PostMapping("/coupons")
    public Coupon create(@RequestBody Coupon coupon) {
        return couponsRepository.saveAndFlush(coupon);
    }

//    Find one coupon

    @GetMapping("/coupon/{id}")
    public Coupon get(@PathVariable Long id) {
        return couponsRepository.findOne(id);
    }



//    Edit a coupon

    @PutMapping("/coupon/{id}")
    public Coupon update(@PathVariable Long id, @RequestBody Coupon coupon) {
        Coupon existingCoupon = couponsRepository.findOne(id);
        BeanUtils.copyProperties(coupon, existingCoupon);
        return couponsRepository.saveAndFlush(existingCoupon);
    }

//    Delete coupon

    @DeleteMapping("coupon/{id}")
    public Coupon delete(@PathVariable Long id) {
        Coupon existingShipwreck = couponsRepository.findOne(id);
        couponsRepository.delete(existingShipwreck);
        return existingShipwreck;
    }
}


