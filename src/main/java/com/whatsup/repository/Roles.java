package com.whatsup.repository;

/**
 * Created by DelMonroe on 7/5/17.
 */
import com.whatsup.model.UserRole;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface Roles extends CrudRepository<UserRole, Long> {

    // Using HQL
    @Query("select ur.role from UserRole ur, User u where u.username=?1 and ur.userId = u.id")
    public List<String> ofUserWith(String username);

}
