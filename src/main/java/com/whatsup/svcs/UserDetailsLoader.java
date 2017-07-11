package com.whatsup.svcs;

/**
 * Created by DelMonroe on 7/5/17.
 */
import com.whatsup.model.User;
import com.whatsup.repository.Roles;
import com.whatsup.repository.UserService;
import com.whatsup.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("userService")
public class UserDetailsLoader implements UserService, UserDetailsService {

    @Autowired
    private final UsersRepository usersRepository;

    @Autowired
    private final Roles roles;

    @Autowired
    public UserDetailsLoader(UsersRepository users, Roles roles) {
        this.usersRepository = users;
        this.roles = roles;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = usersRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("No user found for " + username);
        }

        List<String> userRoles = roles.ofUserWith(username);
        return new UserWithRoles(user, userRoles);
    }

    @Override
    public List<User> getAllUsers() {
        return usersRepository.findAll();
    }

    @Override
    public User getUserById(long id) {
        return null;
    }
}
