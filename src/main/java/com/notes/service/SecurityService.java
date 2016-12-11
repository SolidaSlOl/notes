package com.notes.service;

/**
 * Created with IntelliJ IDEA.
 * @author Mikita Herasiutsin (mikita.herasiutsin@gmail.com)
 * @version 1.0
 * @since 1.0
 */
public interface SecurityService {
    String findLoggedInUsername();

    void autologin(String username, String password);
}
