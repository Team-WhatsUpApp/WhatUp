package com.whatsup.repositories;

import com.whatsup.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by mosesfranco on 7/6/17
 * Codeup
 * Pinnacles
 */
@Repository
public interface UsersRepository extends JpaRepository<User, Long> {
	public User findByUsername(String username);

	public User findById(long id);
}
