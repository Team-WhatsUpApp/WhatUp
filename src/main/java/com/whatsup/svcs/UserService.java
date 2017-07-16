package com.whatsup.svcs;

import com.whatsup.models.User;

import java.util.Collection;
import java.util.Optional;

/**
 * Created by DelMonroe on 7/15/17.
 */
public interface UserService {

        public Optional<User> findUserByEmail(String email);
        public Optional<User> findUserByResetToken(String resetToken);
        public void save(User user);

}
