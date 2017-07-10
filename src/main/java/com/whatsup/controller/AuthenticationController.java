package com.whatsup.controller;

import com.whatsup.model.User;
import com.whatsup.repository.UsersRepository;
import com.whatsup.svcs.UserWithRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;


/**
 * Created by fer on 6/23/17.
 */
@EnableWebSecurity
@Controller
@ComponentScan(basePackageClasses = UserWithRoles.class)
public class AuthenticationController {

    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

    @GetMapping("/yelp")
    public String shownewYelpAPI() {
        return "yelpAPI";
    }



    @PostMapping("/register")
    public String create(@ModelAttribute User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        usersRepository.saveAndFlush(user);
        return "login";
    }

    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }


    @GetMapping("/dashboard")
    public String showDashboard() {
        return "dashboard";
    }



    @GetMapping("")
    public String showAppPage() {
        return "index";
    }

}
