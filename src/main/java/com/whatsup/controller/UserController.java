package com.whatsup.controller;

import com.whatsup.models.Coupon;
import com.whatsup.models.User;
import com.whatsup.repositories.CouponsRepository;
import com.whatsup.repositories.UsersRepository;
import com.whatsup.svcs.CouponSvc;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


/**
 * Created by DelMonroe on 7/11/17.
 */
@Controller
public class UserController {

    @Autowired
    private UsersRepository userRepository;

    @Autowired
    private CouponsRepository couponsRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private CouponSvc couponSvc;

    @GetMapping("/admin")
    public String userPage(Model model) {
        model.addAttribute("users", userRepository.findAll());
        return "dashboard_admin";}

//    Show all users
    @GetMapping("/users")
    public @ResponseBody Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

//    Show a user page
    @GetMapping("/user/{id}/profile")
    public String showUser(@PathVariable long id, Model model) {
        User user = userRepository.findOne(id);
        Iterable<Coupon> coupons = couponsRepository.notSelectedByUser(id);
        model.addAttribute("user",user);
        model.addAttribute("userCoupons", user.getUserCouponList());
        model.addAttribute("coupons", coupons);
        return  "dashboard_user";
    }

   /* @GetMapping("/user")
    public @ResponseBody User getUser(Long id) {return userRepository.findOne(id);}
*/
//    Create a User

    @GetMapping("/user/create")
    public String showCreateUser(Model model) {
        model.addAttribute("users", new User());
        return "user/create";
    }

    @PostMapping("/user/create")
    public String createUser(@ModelAttribute User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return "redirect:/admin";
    }


//    Edit a user

    @GetMapping(value = "/user/{id}/edit")
    public String showUserEdit(@PathVariable Long id, Model model) {
        model.addAttribute("user", userRepository.findById(id));
        return "user/edit";
    }

    @PostMapping("/user/{id}/edit")
    public String updateUser(@PathVariable long id, @ModelAttribute User user, Model model) {
        User existingUser = userRepository.findById(id);
        BeanUtils.copyProperties(user, existingUser);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        model.addAttribute("user", user);
        return "redirect:/admin";
    }

//    Delete a user

    @PostMapping("/user/{id}/delete")
    public String deleteUser(@PathVariable Long id) {
        User existingUser = userRepository.findById(id);
        userRepository.delete(existingUser);
        return "redirect:/admin";
    }

    @PostMapping("/user/{id}/savecoupon")
    public String userSavedCoupon(
        @PathVariable Long id,
        @RequestParam(name = "coupon_id") Long couponId
    ) {
        User existingUser = userRepository.findById(id);
        Coupon activeCoupon = couponsRepository.findOne(couponId);
        existingUser.getUserCouponList().add(activeCoupon);
        couponSvc.save(activeCoupon);
        return "redirect:/user/" + existingUser.getId() + "/profile";

    }
}
