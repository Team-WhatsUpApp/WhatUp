package com.whatsup.repository;

import com.whatsup.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by DelMonroe on 7/12/17.
 */
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}

