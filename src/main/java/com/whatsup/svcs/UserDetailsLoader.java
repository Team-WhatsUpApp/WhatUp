package com.whatsup.svcs;

/**
 * Created by DelMonroe on 7/5/17.
 */

import com.whatsup.models.User;
import com.whatsup.repositories.Roles;
import com.whatsup.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("customUserDetailsService")
public class UserDetailsLoader implements UserDetailsService {

	@Autowired
	private final UsersRepository users;
	@Autowired
	private final Roles roles;

	@Autowired
	public UserDetailsLoader(UsersRepository users, Roles roles) {
		this.users = users;
		this.roles = roles;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = users.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("No user found for " + username);
		}

		List<String> userRoles = roles.ofUserWith(username);
		return new UserWithRoles(user, userRoles);
	}
}
