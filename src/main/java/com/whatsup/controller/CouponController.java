package com.whatsup.controller;

import com.whatsup.models.Coupon;
import com.whatsup.repositories.CouponsRepository;
import com.whatsup.svcs.CouponSvc;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by DelMonroe on 7/10/17.
 */
@Controller
public class CouponController {


    private final CouponsRepository couponsRepository;
    private final CouponSvc couponSvc;

    @Autowired
    public CouponController(CouponsRepository couponsRepository, CouponSvc couponSvc) {
        this.couponsRepository = couponsRepository;
        this.couponSvc = couponSvc;
    }

//    List all coupons

    @GetMapping("/coupons")
    public String viewAllCoupons(Model model) {
        Iterable<Coupon> coupons = couponSvc.findAll();
        model.addAttribute("coupons", coupons);
        return "dashboard_vendor";
    }

//    Create a coupon

  /*  @GetMapping("/coupon/coupon")
    public*/


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
        return couponsRepository.save(existingCoupon);
    }

//    Delete coupon

    @DeleteMapping("coupon/{id}")
    public Coupon delete(@PathVariable Long id) {
        Coupon existingCoupon = couponsRepository.findOne(id);
        couponsRepository.delete(existingCoupon);
        return existingCoupon;
    }
}


