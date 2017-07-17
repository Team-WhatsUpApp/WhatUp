package com.whatsup.controller;

import com.whatsup.models.User;
import com.whatsup.repositories.UsersRepository;
import com.whatsup.svcs.UserWithRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestWrapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;


@Controller
public class AuthenticationController {


    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/")
    public String showHome() {
        return "index";
    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

   /* @GetMapping("/PasswordReset")
    public String showForgotPasswordForm() {
        return "forgot_password";
    }*/

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

    @GetMapping("/dashboards")
    public String dashboard(HttpServletRequest request) {
        UserWithRoles user = (UserWithRoles) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (user.getUserRoles().contains("ROLE_VENDOR")) {
            return "redirect:/vendor/" + user.getId() + "/profile";
        }
        return "redirect:/user/" + user.getId() + "/profile";
    }

}



