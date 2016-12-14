package com.notes.service;

import com.notes.model.User;

/**
 * User Service.
 * @author Mikita Herasiutsin (mikita.herasiutsin@gmail.com)
 * @version 1.0
 * @since 1.0
 */
public interface UserService {

    /**
     * Save user.
     * @param user User
     */
    void register(User user);

    /**
     * Find user by username.
     * @param username Username
     */
    User findByUsername(String username);

    /**
     * Find current logged in user.
     * @return User
     */
    User findCurrentUser();
}
