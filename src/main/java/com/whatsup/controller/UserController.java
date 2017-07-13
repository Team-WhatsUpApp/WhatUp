package com.whatsup.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.whatsup.model.User;
import com.whatsup.repository.UserRepository;
import com.whatsup.repository.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by DelMonroe on 7/11/17.
 */
@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

//    Show all users
    @GetMapping("/userstable")
    public @ResponseBody Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

//    Edit a user

    @PutMapping(value = "/user/{id}")
    public User update(@PathVariable Long id, @RequestBody User user) {
        User existingUser = userRepository.findOne(id);
        BeanUtils.copyProperties(user, existingUser);
        return userRepository.saveAndFlush(existingUser);
    }

//    Delete a user

    @DeleteMapping("/user/{id}")
    public User delete(@PathVariable Long id) {
        User existingUser = userRepository.findOne(id);
        userRepository.delete(existingUser);
        return existingUser;
    }




}
