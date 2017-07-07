package com.whatsup.repositories;

import com.whatsup.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by mosesfranco on 7/6/17
 * Codeup
 * Pinnacles
 */
@Repository
public interface UsersRepository extends CrudRepository<User, Long> {
	public User findByUsername(String username);
}
