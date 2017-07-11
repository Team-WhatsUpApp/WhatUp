package com.whatsup.repository;

/**
 * Created by DelMonroe on 7/5/17.
 */
import com.whatsup.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<User, Long> {
     User findByUsername(String username);
}