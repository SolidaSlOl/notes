package com.notes.service;

/**
 * Security Service.
 * @author Mikita Herasiutsin (mikita.herasiutsin@gmail.com)
 * @version 1.0
 * @since 1.0
 */
public interface SecurityService {

    /**
     * Find username of currently logged in user.
     * @return Username
     */
    String findLoggedInUsername();

    /**
     * Auto login user.
     * @param username Username
     * @param password Password
     */
    void autologin(String username, String password);
}
