package com.whatsup.controller;

import com.whatsup.models.User;
import com.whatsup.svcs.UserWithRoles;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


/**
 * Created by fer on 6/23/17.
 */
@EnableWebSecurity
@Controller
@ComponentScan(basePackageClasses = UserWithRoles.class)
public class AuthenticationController {

	@GetMapping("/login")
	public String showLoginForm() {
		return "login";
	}

	@GetMapping("/")
	public String showHome() {
		return "index";
	}

	@GetMapping("/register")
	public String showRegisterForm(Model model) {
		model.addAttribute("user", new User());
		return "register";
	}
}