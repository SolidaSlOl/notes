package com.notes.repository;

import com.notes.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Spring Data Repository.
 * @author Mikita Herasiutsin (mikita.herasiutsin@gmail.com)
 * @version 1.0
 * @since 1.0
 */
public interface UserRepository extends JpaRepository<User, Integer> {

    /**
     * Find user by name
     * @param username Username
     * @return user
     */
    User findByUsername(String username);
}
