package com.whatsup.controller;

import com.whatsup.models.User;
import com.whatsup.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
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
public class UserController {

	@Autowired
	private UsersRepository usersRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

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

	@GetMapping("/dashboard")
	public String showDashboard() {
		return "dashboard";
	}
}
