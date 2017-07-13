package com.whatsup.repository;

import com.whatsup.model.User;

import java.util.List;

/**
 * Created by DelMonroe on 7/11/17.
 */


public interface UserService {

    Iterable<User>  getAllUsers();
    User getUserById(long id);
}
