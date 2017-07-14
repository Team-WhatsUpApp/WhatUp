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
/*
    @GetMapping("/coupons")
    public String viewAllCoupons(Model model) {
        Iterable<Coupon> coupons = couponSvc.findAll();
        model.addAttribute("coupons", coupons);
        return "dashboard_vendor";
    }*/

    @RequestMapping(path="/vendor", method = RequestMethod.GET)
    public String couponPage(){
        return "dashboard_vendor";
    }

    @GetMapping("/coupons")
    public @ResponseBody Iterable<Coupon> getAllCoupons() {
        return couponsRepository.findAll();
    }


    @GetMapping("/coupon/{id}")
    public Coupon get(@PathVariable Long id) {
        return couponsRepository.findOne(id);
    }

    @GetMapping("/coupon/create")
    public String showCreate(Model model) {
        model.addAttribute("coupon", new Coupon());
        return "coupon/create";
    }

    @PostMapping("/coupon/create")
    public String createCoupon(@ModelAttribute Coupon coupon) {
        couponsRepository.save(coupon);
        return "redirect:/vendor";
    }



//    Edit a coupon
    @GetMapping("/coupon/{id}/edit")
    public String showEdit(Long id , Model model) {
        model.addAttribute("coupon", couponsRepository.findOne(id));
        return "coupon/edit";
}

    @PutMapping("/coupon/{id}/edit")
    public Coupon updateCoupon(@PathVariable Long id, @RequestBody Coupon coupon) {
        Coupon existingCoupon = couponsRepository.findOne(id);
        BeanUtils.copyProperties(coupon, existingCoupon);
        return couponsRepository.save(existingCoupon);
    }

//    Delete coupon

    @DeleteMapping("coupon/{id}/delete")
    public Coupon deleteCoupon(@PathVariable Long id) {
        Coupon existingCoupon = couponsRepository.findOne(id);
        couponsRepository.delete(existingCoupon);
        return existingCoupon;
    }
}


