package com.whatsup.repositories;

import com.whatsup.models.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by mosesfranco on 7/6/17
 * Codeup
 * Pinnacles
 */
public interface UsersRepository extends CrudRepository<User, Long> {
	public User findByUsername(String username);
}
