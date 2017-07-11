package com.whatsup.controller;

<<<<<<< HEAD
import com.whatsup.models.User;
import com.whatsup.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
=======
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
>>>>>>> master
import org.springframework.web.bind.annotation.*;


/**
 * Created by fer on 6/23/17.
 */
@EnableWebSecurity
@Controller
<<<<<<< HEAD
=======
@ComponentScan(basePackageClasses = UserWithRoles.class)
>>>>>>> master
public class AuthenticationController {

    @Autowired
    private UsersRepository usersRepository;
<<<<<<< HEAD
=======
    @Autowired
    private PasswordEncoder passwordEncoder;
>>>>>>> master

    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

<<<<<<< HEAD
    @GetMapping("/register")
    public String showRegisterForm(Model model){
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String create(@ModelAttribute User user) {
        usersRepository.save(user);
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
=======
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
>>>>>>> master

}
