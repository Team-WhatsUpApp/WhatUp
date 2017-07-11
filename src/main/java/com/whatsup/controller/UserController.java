package com.whatsup.controller;

import com.whatsup.model.User;
import com.whatsup.repository.UserService;
import com.whatsup.repository.UsersRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by DelMonroe on 7/11/17.
 */
@Controller
public class UserController {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private UserService userService;

//    Show all users

    @GetMapping("/users")
    public String getAllUsers(Model model) {
        model.addAttribute(userService.getAllUsers());
        return "dashboard";
    }

//    Edit a user

    @PutMapping(value = "/user/{id}")
    public User update(@PathVariable Long id, @RequestBody User user) {
        User existingUser = usersRepository.findOne(id);
        BeanUtils.copyProperties(user, existingUser);
        return usersRepository.saveAndFlush(existingUser);
    }

//    Delete a user

    @DeleteMapping("/user/{id}")
    public User delete(@PathVariable Long id) {
        User existingUser = usersRepository.findOne(id);
        usersRepository.delete(existingUser);
        return existingUser;
    }


}
