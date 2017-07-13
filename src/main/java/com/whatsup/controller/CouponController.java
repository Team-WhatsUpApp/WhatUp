package com.whatsup.controller;

import com.sun.tools.corba.se.idl.ValueEntry;
import com.whatsup.models.Coupon;
import com.whatsup.models.User;
import com.whatsup.models.Vendor;
import com.whatsup.repositories.CouponsRepository;
import com.whatsup.repositories.UsersRepository;
import com.whatsup.repositories.VendorsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	@Autowired
	UsersRepository userDao;
	@Autowired
	VendorsRepository vendorDao;

	@GetMapping("/coupon/create")
	public String formsCoupon(Model model) {
		model.addAttribute("coupon", new Coupon());
		return "coupon/create";
	}

	@PostMapping("/coupon/create")
	public String createCoupon(@ModelAttribute Coupon coupon) {
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Vendor vendor = vendorDao.findByOwner(user);
		coupon.setOwner(vendor);
		couponDao.save(coupon);
		return "coupon";
	}
}
