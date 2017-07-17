package com.whatsup.controller;

import com.whatsup.models.Coupon;
import com.whatsup.models.User;
import com.whatsup.models.Vendor;
import com.whatsup.repositories.CouponsRepository;
import com.whatsup.repositories.UsersRepository;
import com.whatsup.repositories.VendorsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by DelMonroe on 7/13/17.
 */
@Controller
public class VendorsController {

    @Autowired
    private VendorsRepository vendorRepository;

    @Autowired
    private CouponsRepository couponsRepository;

    @Autowired
    private UsersRepository usersRepository;

    @GetMapping("/vendors")
    public @ResponseBody
    Iterable<Vendor> getAllVendors() {
        return vendorRepository.findAll();
    }

//    Show a Vendor page
    @GetMapping("/vendor/{id}/profile")
    public String showVendor(@PathVariable long id, Model model) {
        User vendor = usersRepository.findOne(id);
        Iterable<Coupon> coupons = couponsRepository.findAll();
        model.addAttribute("vendor",vendor);
        model.addAttribute("coupons", coupons);
        return  "dashboard_vendor";
    }

}
