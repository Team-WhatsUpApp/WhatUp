package com.whatsup.controller;

import com.whatsup.models.Coupon;
import com.whatsup.repositories.CouponsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Created by mosesfranco on 7/12/17
 * Codeup
 * Pinnacles
 */
@Controller
public class CouponController {
	@Autowired
	CouponsRepository couponDao;

	@GetMapping("/coupon/create")
	public String formsCoupon(){
		return "coupon/create";
	}

	@PostMapping("/coupon/create")
	public String createCoupon(@ModelAttribute Coupon coupon){
		couponDao.save(coupon);
		return "coupon";
	}
}
