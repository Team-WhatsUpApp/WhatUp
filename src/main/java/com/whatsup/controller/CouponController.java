package com.whatsup.controller;

import com.whatsup.models.Coupon;
import com.whatsup.models.User;
import com.whatsup.models.Vendor;
import com.whatsup.repositories.CouponsRepository;
import com.whatsup.repositories.VendorsRepository;
import com.whatsup.svcs.CouponSvc;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
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
    private VendorsRepository vendorsRepository;


    @Autowired
    public CouponController(CouponsRepository couponsRepository, CouponSvc couponSvc, VendorsRepository vendorsRepository) {
        this.couponsRepository = couponsRepository;
        this.couponSvc = couponSvc;
        this.vendorsRepository = vendorsRepository;
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
    public String couponPage(Model model){
        model.addAttribute("coupons", couponsRepository.findAll());
        return "dashboard_vendor";
    }

    @GetMapping("/coupons")
    public String getAllCoupons(Model model) {
        Iterable<Coupon> coupons = couponsRepository.findAll();
        model.addAttribute("coupons", coupons);
        return "coupon/index";
    }


    @GetMapping("/coupon/{id}")
    public String getCoupon(@PathVariable Long id, Model model) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Coupon coupon = couponsRepository.findOne(id);
        model.addAttribute("coupon", coupon);
        model.addAttribute("user", user);
        return "coupon/show";
    }

    @GetMapping("/coupon/create")
    public String showCreate(Model model) {
        model.addAttribute("coupon", new Coupon());
        return "coupon/create";
    }

    @PostMapping("/coupon/create")
    public String createCoupon(@ModelAttribute Coupon coupon) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Vendor vendor = vendorsRepository.findByOwner(user);
        coupon.setOwner(vendor);
        couponsRepository.save(coupon);
        return "redirect:/dashboards";
    }



    //    Edit a coupon
    @GetMapping("/coupon/{id}/edit")
    public String showEdit(@PathVariable Long id , Model model) {
        model.addAttribute("coupon", couponsRepository.findOne(id));
        return "coupon/edit";
    }

    @PostMapping("/coupon/{id}/edit")
    public String updateCoupon(@PathVariable long id, @ModelAttribute Coupon coupon, Model model) {
        Coupon existingCoupon = couponsRepository.findOne(id);
        BeanUtils.copyProperties(coupon, existingCoupon);
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Vendor vendor = vendorsRepository.findByOwner(user);
        coupon.setOwner(vendor);
        couponsRepository.save(coupon);
        model.addAttribute("coupon", coupon);
        return "redirect:/dashboards";
    }

//    Delete coupon

    @PostMapping("/coupon/{id}/delete")
    public String deleteCoupon(@PathVariable Long id) {
        Coupon existingCoupon = couponsRepository.findOne(id);
        couponsRepository.delete(existingCoupon);
        return "redirect:/dashboards";
    }
}


