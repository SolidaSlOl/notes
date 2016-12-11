package com.notes.service;

import com.notes.model.User;

/**
 * Created with IntelliJ IDEA.
 * @author Mikita Herasiutsin (mikita.herasiutsin@gmail.com)
 * @version 1.0
 * @since 1.0
 */
public interface UserService {

    void save(User user);

    User findByUsername(String username);
}
