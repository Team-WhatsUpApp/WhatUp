package com.whatsup.controller;

import com.whatsup.repositories.VendorsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by DelMonroe on 7/13/17.
 */
@RestController
public class VendorsController {

    @Autowired
    private VendorsRepository vendorRepository;

    @GetMapping("/coupon/create")
    public String createCoupon() {
        return "coupons/create";

    }

}
