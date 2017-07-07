package com.whatsup.controller;

import com.whatsup.model.User;
import com.whatsup.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
public class AuthenticationController {

    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/login")
    public String showLoginForm(@ModelAttribute User user) {
        return "login";
    }


    @PostMapping("/register")
    public String create(@ModelAttribute User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        usersRepository.saveAndFlush(user);
        return "redirect:index";
    }




}
