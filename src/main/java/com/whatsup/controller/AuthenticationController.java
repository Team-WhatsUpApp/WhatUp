package com.whatsup.controller;

import com.whatsup.model.User;
import com.whatsup.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
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

    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

    @GetMapping("/register")
    public String showRegisterForm(Model model){
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String create(@ModelAttribute User user) {
        usersRepository.saveAndFlush(user);
        return "index";
    }


    /*@RequestMapping(value = "/{register}", method = RequestMethod.POST )
    @ResponseStatus(HttpStatus.CREATED)
    public String post(@ModelAttribute("User") User user, ModelMap modelMap, @PathVariable String pathURL) {
        if (user.getId() == 0) {
            user.;
            if (user.getEmail().length() > 0) {
                sendMessage("Registration was successful", "WhatsUp Account has been created", user.getEmail(), "Thanks for joining! Your username is " + user.getUsername() + ".");
            }
        } else {
            user.merge();
        }
        return "thanks";

    }*/

}
